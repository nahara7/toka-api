package com.newjerseysoftware.hederaDemo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.HederaPreCheckStatusException;
import com.hedera.hashgraph.sdk.HederaReceiptStatusException;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.newjerseysoftware.hederaDemo.model.User;
import com.newjerseysoftware.hederaDemo.model.Vendor;
import com.newjerseysoftware.hederaDemo.repository.UserRepository;
import com.newjerseysoftware.hederaDemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
@RequestMapping("api/v1/transaction")
@RestController
@CrossOrigin(origins = "")
public class TransactionController {


    //add repository


    private final UserRepository userRepository;
    //private final VendorService vendorService;
    private User user;

    private TransactionReceipt transactionReceipt;
    private TransactionService transactionService;
    //private demo.model.Transaction transaction;
    private String receipt;
    Client client = Client.forTestnet();

    private int fee;

    @Autowired
    //this is where you get it from
    //@GetMapping'/emoUserAccess'
    //@GetMapping
    //create Vendor repository
    public TransactionController(UserRepository userRepository) {//@RequestBody VendorService vendorService)  {
        this.userRepository = userRepository;

        System.out.println("test");
    }

    @PostMapping
    public void addClients(@RequestBody User user, @RequestBody Vendor vendor) throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException, IOException {
        System.out.println("test");
        //userService.addUser(user);
        //vendorService.addVendor(vendor);

    }
    //add path
    //@PostMapping
    public void startTransaction(User user, Vendor vendor) {
        System.out.println("test");
        //Transaction transaction= new Transaction(user, vendor, fee);

    }

    //@GetMapping
   /* public String testReturn(User user) throws NullPointerException{
        return user.getUserFirstName();
        //return userService.getAllUsers().toString();
    }*/
    @JsonDeserialize
    public String testReturn(@RequestBody User user) throws NullPointerException, IOException {
        //System.out.println(user.getAccountId().toString());
        return "";
        //return user.getAccountId().toString();
    }
}
   /*public List<User> getAllUsers(){
       System.out.println(userService.getAllUsers()+ "test");

       return userService.getAllUsers();}*/
    /*public TransactionController(@RequestBody UserService userService, @RequestBody VendorService vendorService, @RequestBody int fee) throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException {

    }
    @PostMapping
    public void startTransaction(User user, Vendor vendor) throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException {
        userService.addUser(user);
        vendorService.addVendor(vendor);
        this.transactionService= new TransactionService(user,vendor, fee);


    }
    @GetMapping
    public String getTransactionReceipt() throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException, JsonProcessingException{
        transactionService.transactionUserVendor();
        return transactionService.returnReceipt().toString();
    }
}*/
