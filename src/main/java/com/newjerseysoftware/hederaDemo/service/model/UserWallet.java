package com.newjerseysoftware.hederaDemo.model;

import com.hedera.hashgraph.sdk.*;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class UserWallet {
    private final User user;
    Client client= Client.forTestnet();
    public UserWallet(User user) {
        this.user = user;
    }
    public String getAccountBalance() throws IOException, TimeoutException, HederaPreCheckStatusException {
      /*  AccountId AccountID= AccountId.fromString(user.getAccountid());
        this.request = new Request.Builder()
               .url("https://api-testnet.dragonglass.me/hedera/api/accounts/{accountID}/balances/{asOfInEpoch}")
               .method("GET", null)
               .addHeader("ad418e056319da3959b8dd68116bf526d8819680", "e224b0e9-b721-3ccb-b24b-8c2659e3fb33")
               .build();
        Response response = client.newCall(request).execute();
        return response.toString();*/
        AccountBalanceQuery query= new AccountBalanceQuery()
                .setAccountId(AccountId.fromString(user.getAccountid()));
        AccountBalance accountBalance=query.execute(client);
        return accountBalance.hbars.toString();
    }
    public String getAccountInfo() throws TimeoutException, HederaPreCheckStatusException {
        client.setOperator(AccountId.fromString(Objects.requireNonNull(System.getenv("nahara_account_id"))),
                PrivateKey.fromString(Objects.requireNonNull(System.getenv("my_private_key"))));
        AccountInfoQuery query= new AccountInfoQuery()
                .setAccountId(AccountId.fromString(user.getAccountid()));
        AccountInfo accountInfo = query.execute(client);
        return accountInfo.toString();
    }

}

