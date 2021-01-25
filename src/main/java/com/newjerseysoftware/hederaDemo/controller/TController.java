package com.newjerseysoftware.hederaDemo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.HederaPreCheckStatusException;
import com.hedera.hashgraph.sdk.HederaReceiptStatusException;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.newjerseysoftware.hederaDemo.model.Transaction;
import com.newjerseysoftware.hederaDemo.model.User;
import com.newjerseysoftware.hederaDemo.model.Vendor;
import com.newjerseysoftware.hederaDemo.repository.UserRepository;
import com.newjerseysoftware.hederaDemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeoutException;
@RequestMapping("api/v1/transaction")
@RestController
@CrossOrigin(origins = "")
public class TController {
    public User user;
    public Vendor vendor;
    public int fee;
    public TController(){
        user=null;
        vendor=null;
        fee=10;
    }


    @PostMapping
    public void addClients(@RequestBody Map<String, String> clients){
        user= new User();
               user.setFirstname(clients.get(0));
        vendor=new Vendor();
               vendor.setFirstname(clients.get(1));
               startTransaction();

   }
    //add path
    //@PostMapping
    public void startTransaction() {
        //System.out.println("test");
         Transaction transaction=new Transaction(this.user, vendor, 10);
        System.out.println("test");
        //Transaction transaction= new Transaction(user, vendor, fee);

    }

    //@GetMapping
   /* public String testReturn(User user) throws NullPointerException{
        return user.getUserFirstName();
        //return userService.getAllUsers().toString();
    }*/
    /* public String testReturn(@RequestBody User user) throws NullPointerException, IOException {
        //System.out.println(user.getAccountId().toString());
        return "";
        //return user.getAccountId().toString();
    }*/
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
