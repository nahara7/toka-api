package com.newjerseysoftware.hederaDemo.model;

import com.hedera.hashgraph.sdk.*;
import com.hedera.hashgraph.sdk.proto.TransactionID;

import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class Transaction {
    public TransactionResponse transaction;
    public TransactionRecord record;
    public TransactionReceipt receipt;
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
        Token token=new Token();
        //TokenId TokenId= com.hedera.hashgraph.sdk.TokenId.fromString(token.getTokenid());
        TokenId TokenId= com.hedera.hashgraph.sdk.TokenId.fromString("0.0.275240");
        //account Id=Nahara
        client.setOperator(AccountId.fromString(Objects.requireNonNull(System.getenv("nahara_account_id"))),
                PrivateKey.fromString(Objects.requireNonNull(System.getenv("my_private_key"))));
              TransferTransaction transfer= new TransferTransaction()
                .addHbarTransfer( AccountId.fromString(user.getAccountid()), Hbar.from(-(fee)))
                .addHbarTransfer(AccountId.fromString(vendor.getAccountid()), Hbar.from(fee));
        //must attribute JVT token to user to do this transaction
       /* TransferTransaction transfer= new TransferTransaction()
                .addTokenTransfer(TokenId, AccountId.fromString(user.getAccountid()), -(fee))
                .addTokenTransfer(TokenId, AccountId.fromString(vendor.getAccountid()), fee);*/
        TransferTransaction txId = transfer.freezeWith(client).sign(PrivateKey.fromString(user.getPrivateKey()));
        txId.execute(client);
        TransactionId tId= txId.getTransactionId();
        this.receipt= tId.getReceipt(client);
        System.out.println(receipt.status);
    }
    //for when vendor has a promotion
    public void vendorPromotion(int promo, String promotion) throws StringIndexOutOfBoundsException, TimeoutException, HederaPreCheckStatusException, HederaReceiptStatusException {
        client.setOperator(AccountId.fromString(Objects.requireNonNull(System.getenv("nahara_account_id"))),
                PrivateKey.fromString(Objects.requireNonNull(System.getenv("my_private_key"))));
        TransferTransaction transfer= new TransferTransaction()
                .addHbarTransfer(AccountId.fromString(vendor.getAccountid()), Hbar.fromTinybars(-(promo)))
                .addHbarTransfer(AccountId.fromString(user.getAccountid()), Hbar.fromTinybars(promo))
                .setTransactionMemo("promotion: " + promotion);
        TransferTransaction txId = transfer.freezeWith(client).sign(PrivateKey.fromString(vendor.getPrivateKey()));
        txId.execute(client);
        TransactionId tId= txId.getTransactionId();
        this.record=tId.getRecord(client);
        this.receipt= tId.getReceipt(client);
        System.out.println(receipt.status);
    }
    public void cashBack(int percentage, int total)throws StringIndexOutOfBoundsException, TimeoutException, HederaPreCheckStatusException, HederaReceiptStatusException {
        double fee=(double)(total*(5.0f/100.0));
        System.out.println(fee);
        client.setOperator(AccountId.fromString(Objects.requireNonNull(System.getenv("nahara_account_id"))),
                PrivateKey.fromString(Objects.requireNonNull(System.getenv("my_private_key"))));
        TransferTransaction transfer= new TransferTransaction()
                .addHbarTransfer(AccountId.fromString(vendor.getAccountid()), Hbar.fromTinybars((long) -(fee)))
                .addHbarTransfer(AccountId.fromString(user.getAccountid()), Hbar.fromTinybars((long) fee));
        TransferTransaction txId = transfer.freezeWith(client).sign(PrivateKey.fromString(vendor.getPrivateKey()));
        txId.execute(client);
        TransactionId tId= txId.getTransactionId();
        this.record=tId.getRecord(client);
        this.receipt= tId.getReceipt(client);
        System.out.println(receipt.status);
    }
    public TransactionReceipt returnReceipt() throws HederaReceiptStatusException, TimeoutException, HederaPreCheckStatusException {
        return this.receipt;
    }
    public TransactionRecord findTransaction(TransactionID transactionId){
        //dragon glass api call
        return null;
    }
}

