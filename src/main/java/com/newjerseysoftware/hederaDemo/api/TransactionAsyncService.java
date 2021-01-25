package com.newjerseysoftware.hederaDemo.api;

import com.hedera.hashgraph.sdk.*;
import com.newjerseysoftware.hederaDemo.model.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
//import com.newjerseysoftware.hederaDemo.api.Hedera;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

@Service
public class TransactionAsyncService {
    public TransactionAsyncService() { }

    @Autowired
    private Hedera hedera;

    public TransactionAsyncService(Hedera hedera) {
        hedera = hedera;
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
