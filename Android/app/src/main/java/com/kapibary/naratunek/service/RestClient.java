package com.kapibary.naratunek.service;

import com.google.firebase.auth.FirebaseAuth;
import com.payu.android.sdk.payment.service.exception.ExternalRequestError;
import com.studioidan.httpagent.HttpAgent;
import com.studioidan.httpagent.JsonArrayCallback;
import com.studioidan.httpagent.JsonCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class RestClient {
    private static final FirebaseAuth auth = FirebaseAuth.getInstance();
    private static final String serverUrl = "https://guarded-crag-45195.herokuapp.com/api";

    private static HttpAgent get(String endpoint) {
        String token = auth.getCurrentUser().getIdToken(false).getResult().getToken();
        return HttpAgent.get(serverUrl + endpoint)
                .headers("X-Authorization-Firebase", token);
    }

    public static String getPayUAccesToken() throws ExternalRequestError {
        try {
            String json = get("/user/access-tokens/payu").execute().get();
            return new JSONObject(json).getString("access_token");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new ExternalRequestError(ExternalRequestError.ExternalErrorType.NETWORK_ERROR);
        } catch(JSONException e)
        {
            e.printStackTrace();
            throw new ExternalRequestError(ExternalRequestError.ExternalErrorType.SERVER_ERROR);
        }
    }

    public static void get(String endpoint, JsonCallback callback){
        get(endpoint).goJson(callback);
    }
    public static void getArray(String endpoint, JsonArrayCallback callback){
        get(endpoint).goJsonArray(callback);
    }
}