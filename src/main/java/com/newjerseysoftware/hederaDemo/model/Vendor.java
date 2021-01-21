package com.newjerseysoftware.hederaDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hedera.hashgraph.sdk.PrivateKey;
import com.hedera.hashgraph.sdk.PublicKey;
//import com.mysql.cj.xdevapi.Table;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "vendors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vendor {

    public Vendor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "accountid")
    private String accountid;

    @Column(name = "publickey")
    private String publickey;

    @Column(name="privatekey")
    private String privatekey;



    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public void setPrivatekey(){
        PrivateKey newPrivKey = PrivateKey.generate();
        this.privatekey=newPrivKey.toString();
    }
    private String getPrivatekey(){
        return this.privatekey;
    }
    public void setPublicKey(){
        PublicKey newPublicKey=PrivateKey.fromString(this.privatekey).getPublicKey();
        this.publickey=newPublicKey.toString();
    }
    public String getPublicKey(){
        return this.publickey;
    }
}

