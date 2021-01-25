package com.newjerseysoftware.hederaDemo;

import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.HederaPreCheckStatusException;
import com.hedera.hashgraph.sdk.HederaReceiptStatusException;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.newjerseysoftware.hederaDemo.model.Transaction;
import com.newjerseysoftware.hederaDemo.model.User;

import com.newjerseysoftware.hederaDemo.model.Vendor;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NaharaTransactionTests {
    @Test
    public void checkTransaction() throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException, IOException {
        Client client= Client.forTestnet();
        User user=new User();
        user.setPrivateKey();
        user.setPublickey();
        user.setAccountid();

        Vendor vendor=new Vendor();
        vendor.setPrivateKey();
        vendor.setPublicKey();
        vendor.setAccountid();


        Transaction transaction= new Transaction(user, vendor, 10);
        //transaction.transactionUserVendor();
        transaction.vendorPromotion(10, "get 10 JVT!");
        transaction.cashBack(5,50);
        TransactionReceipt receipt =transaction.returnReceipt();
        System.out.println(receipt.toString());

       // UserWallet userWallet=new UserWallet(user);
        //System.out.println(userWallet.getAccountBalance());
        //System.out.println(userWallet.getAccountInfo());
    }
    public void checkUserCreate(){

    }

}
