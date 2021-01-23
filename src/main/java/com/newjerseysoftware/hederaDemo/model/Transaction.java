package com.newjerseysoftware.hederaDemo.model;


import com.hedera.hashgraph.sdk.*;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.hedera.hashgraph.sdk.TransactionResponse;
import com.hedera.hashgraph.sdk.proto.TransactionID;
import com.hedera.hashgraph.sdk.proto.*;

import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class Transaction {
    public TransactionResponse transaction;
    private final User user;
    private final Vendor vendor;
    private final int fee;
    Client client=Client.forTestnet();

    public Transaction(User user, Vendor vendor, int fee){
        this.user=user;
        this.vendor=vendor;
        this.fee=fee;
    }
    public void transactionUserVendor() throws StringIndexOutOfBoundsException, TimeoutException, HederaPreCheckStatusException, HederaReceiptStatusException {
        //token ID
        TokenId TokenId= com.hedera.hashgraph.sdk.TokenId.fromString("0.0.271996");
        client.setOperator(AccountId.fromString(("0.0.257777")), PrivateKey.fromString(Objects.requireNonNull(System.getenv("my_private_key"))));
        TokenTransferTransaction transfer= new TokenTransferTransaction();
              /*  //.addSender(TokenId, user.getAccountid(), -fee)
                .addTransfer(TokenId, user.getAccountid(), fee)
                .addRecipient(TokenId, vendor.getAccountid(), fee);
               // .addTransfer(TokenId, user.getAccountid(), fee);



               /*).ad(TokenId, user.getAccountid(), -(fee))
                //.addTokenTransfer(TokenId, vendor.getAccountid(), fee);
        //.setTransactionMemo("transfer test")*/
        //add api call for status to be updated !
        //still say invalid signature with diff variations of signatures
        // TransactionResponse txId = transfer.sign(user.getPrivateKey()).execute(client);
        TransactionResponse txId = transfer.signWithOperator(client).execute(client);
        TransactionReceipt receipt= txId.getReceipt(client);
        System.out.println(receipt.status);
        //TransactionResponse txId = transfer.sign(user.getPrivateKey()).execute(client);
        System.out.println("it works");
        //build(client).sign(AccountId.fromString(("0.0.257777").execute(client)));
        this.transaction=txId;

    }
    //for when vendor has a promotion
    public void vendorPromotion(int promo, String promotion) throws StringIndexOutOfBoundsException, TimeoutException, HederaPreCheckStatusException, HederaReceiptStatusException {
        //add private key configuration
        //client.setOperator(user.getAccountid(), user.get());
        //TransactionResponse transactionResponse= new TokenTransferTransaction();

        //this.transaction=transactionResponse;
        //perhaps return perhaps not necessary
        //return transactionResponse;
    }
    public void cashBack(int percentage, int total)throws StringIndexOutOfBoundsException, TimeoutException, HederaPreCheckStatusException, HederaReceiptStatusException {
        //add percentage
        /*client.setOperator(user.getAccountId(), user.getPrivateKey());
        TransactionResponse transactionResponse= new TransferTransaction()
                .addHbarTransfer(vendor.getAccountId(), Hbar.fromTinybars(-(fee)))
                .addHbarTransfer(user.getAccountId(), Hbar.fromTinybars(fee))
                .execute(client);
        this.transaction=transactionResponse;
        //perhaps return perhaps no
        //return transactionResponse;
    }*/
    /*public TransactionReceipt returnReceipt() throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException {
        //api call ??
        //return this.transaction.getReceipt(client);
    }
    public TransactionReceipt findTransaction(TransactionID transactionID){
        //api call
        // transactionLookup(transactionID)
        return null;
    }*/
    }
}







