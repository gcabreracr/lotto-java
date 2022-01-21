package metodos;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpClient {

    public static JSONObject httpPOST(String url, JSONObject json) throws IOException {
        
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json.toString());
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type","text/html; charset=utf-8")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
             
        return new JSONObject(response.body().string());
        
    }

    public static JSONObject httpGET(String url) throws IOException, JSONException {
       

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        
        return new JSONObject(response.body().string());
    }

}
