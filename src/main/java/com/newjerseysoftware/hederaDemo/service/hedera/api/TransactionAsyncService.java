package com.newjerseysoftware.hederaDemo.service.hedera.api;

import com.hedera.hashgraph.sdk.TokenId;
import com.newjerseysoftware.hederaDemo.components.Hedera;
import com.newjerseysoftware.hederaDemo.model.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TransactionAsyncService {
    public TransactionAsyncService() { }

    @Autowired
    private Hedera hedera;

    public TransactionAsyncService(Hedera hedera) {
        this.hedera = hedera;
    }

    private static Logger log = LoggerFactory.getLogger(TransactionAsyncService.class);

    @Async()
    public Token createToken(String tokenName, String tokenSymbol,
                             String initialSupply) {

        TokenId tokenId;
        Token token = new Token();
        log.info("{}","creating token...");

        try {

            tokenId = hedera.createHederaToken(tokenName,tokenSymbol,initialSupply);

            token.setTokenid(""+tokenId);
            token.setName(tokenName);
            token.setSymbol(tokenSymbol);
            token.setInitialsupply(initialSupply);
            log.info("{}","token created " + tokenId);

        //} catch (TimeoutException|HederaReceiptStatusException|HederaPreCheckStatusException e) {
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return CompletableFuture.completedFuture(token)
                .getNow(null);

    }

}
