package com.newjerseysoftware.hederaDemo.model;

import com.hedera.hashgraph.sdk.*;
import com.hedera.hashgraph.sdk.proto.TransactionID;

import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class Transaction {
    private User user;
    private final Vendor vendor;
    private final Long fee;
    Client client=Client.forTestnet();
    public Transaction(User user, Vendor vendor, Long fee){
        this.user=user;
        this.vendor=vendor;
        this.fee=fee;
    }
    public User getUser(){
        return this.user;
    }
    public Vendor getVendor(){
        return this.vendor;
    }
    public Long getFee(){
        return this.fee;
    }
    public class Promotion{
        private User user;
        private Vendor vendor;
        private long promotion;
        private String memo;
        public Promotion(User user, Vendor vendor, Long promotion){
            this.user = user;
            this.vendor = vendor;
            this.promotion = promotion;
        }
        public User getUser(){
            return this.user;

        }public Vendor getVendor(){
            return this.getVendor();
        }
        public Long getPromotion(){
            return this.promotion;
        }

        public String getMemo(){
            return this.memo;
        }

    }
}

