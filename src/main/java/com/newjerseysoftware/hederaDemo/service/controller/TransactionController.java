package com.newjerseysoftware.hederaDemo.controller;

import com.hedera.hashgraph.sdk.HederaPreCheckStatusException;
import com.hedera.hashgraph.sdk.HederaReceiptStatusException;
import com.newjerseysoftware.hederaDemo.model.Token;
import com.newjerseysoftware.hederaDemo.model.User;
import com.newjerseysoftware.hederaDemo.model.Vendor;
import com.newjerseysoftware.hederaDemo.repository.TokenRepository;
//import com.newjerseysoftware.hederaDemo.service.hedera.api.TransactionAsyncService;
import com.newjerseysoftware.hederaDemo.service.hedera.api.TransactionAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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
    //@PostMapping
    public void addClients(@PathVariable(value = "id") Long idUser, @PathVariable(value = "id") Long idVendor) throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException, IOException {
        System.out.println("test");
        //find vendor and users

    }

}
