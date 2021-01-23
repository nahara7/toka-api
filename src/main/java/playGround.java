import com.hedera.hashgraph.sdk.proto.Response;
import com.squareup.okhttp.*;
import com.squareup.okhttp.Request;

class playGround {
     OkHttpClient client2 = new OkHttpClient().newBuilder()
             .build();
     Request request = new Request.Builder()
             .url("https://hedera/api/CryptoCreate/{CryptoCreateTransactionBody}")
             .method("GET", null)
             .addHeader("ad418e056319da3959b8dd68116bf526d8819680", "e224b0e9-b721-3ccb-b24b-8c2659e3fb33")
             .build();
     Response response = client2.newCall(request).execute();
}
