package com.newjerseysoftware.hederaDemo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.hedera.hashgraph.sdk.HederaPreCheckStatusException;
import com.hedera.hashgraph.sdk.HederaReceiptStatusException;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.newjerseysoftware.hederaDemo.model.User;
import com.newjerseysoftware.hederaDemo.model.Vendor;
import com.newjerseysoftware.hederaDemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeoutException;
@RequestMapping("api/v1/transaction")
@RestController
@CrossOrigin(origins = "")
public class TransactionController {


    //add repository

    private TransactionService transactionService;
    private int fee;
    private User user;
    private Vendor vendor;
    private TransactionReceipt transactionReceipt;
    @Autowired
    public TransactionController(@RequestBody User user, @RequestBody Vendor vendor) throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException {

        this.user=user;
        this.vendor=vendor;
        this.fee=fee;
    }
    @PostMapping
    public void startTransaction(User user, Vendor vendor) throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException {
        this.transactionService= new TransactionService(user,vendor, fee);
        transactionService.transactionUserVendor();


    }
    @GetMapping
    public String getTransactionReceipt() throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException, JsonProcessingException { transactionService.transactionUserVendor();
        return transactionService.returnReceipt().toString();

    }
    /*public String getAllUsers() throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException, JsonProcessingException {
        //ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        //String result= mapper.writeValueAsString(userService.getAllUsers());
        //return userService.getAllUsers().toString();
        return vendorService.getAllVendors().toString();

    }*/
}
