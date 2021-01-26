package com.newjerseysoftware.hederaDemo.controller;

import com.hedera.hashgraph.sdk.HederaPreCheckStatusException;
import com.hedera.hashgraph.sdk.HederaReceiptStatusException;
import com.newjerseysoftware.hederaDemo.api.TransactionAsyncService;
import com.newjerseysoftware.hederaDemo.model.Token;
import com.newjerseysoftware.hederaDemo.model.Transaction;
import com.newjerseysoftware.hederaDemo.repository.TokenRepository;
import com.hedera.hashgraph.sdk.*;
//import com.newjerseysoftware.hederaDemo.service.hedera.api.TransactionAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("api/v1.0/transaction")
@CrossOrigin(origins = "")
public class TransactionController {

    //log.info("{}","token end point..." + token.getName());

    private static Logger log = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TransactionAsyncService transactionAsyncService;

    private Token token;
    @PostMapping("/token")
    public ResponseEntity<Token> createToken(@Valid @RequestBody Token token) {

        log.info("{}","/token..." + token.getSymbol());

        Token newToken = transactionAsyncService.createToken(
                    token.getName(),
                    token.getSymbol(),
                    token.getInitialsupply());

        log.info("{}","new token id..." + newToken.getTokenid());

        tokenRepository.save(newToken);

        return ResponseEntity.ok().body(newToken);
    }
    @PostMapping
    public ResponseEntity<TransactionReceipt> transactionUserVendor(@Valid @RequestBody Transaction transaction) throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException {
        TransactionReceipt receipt = transactionAsyncService.transactionUserVendor(transaction.getUser(), transaction.getVendor(), transaction.getFee());
        return ResponseEntity.ok().body(receipt);

        }
    @PostMapping
    public ResponseEntity<TransactionReceipt> promotion(@Valid @RequestBody Transaction.Promotion promotion) throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException {
        TransactionReceipt receipt = transactionAsyncService.vendorPromotion(promotion.getUser(), promotion.getVendor(), promotion.getPromotion(), promotion.getMemo());
        return ResponseEntity.ok().body(receipt);
    }


    }





