package com.kapibary.naratunek.payU;


import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;
import com.payu.android.sdk.payment.model.MerchantOAuthAccessToken;
import com.payu.android.sdk.payment.service.TokenProviderService;
import com.payu.android.sdk.payment.service.exception.ExternalRequestError;
import com.studioidan.httpagent.HttpAgent;
import com.studioidan.httpagent.JsonCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

@SuppressWarnings("unused")
public class MerchantTokenProviderService extends TokenProviderService {

    public MerchantTokenProviderService(Context context) {
        super(context);
    }

    private final FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    public MerchantOAuthAccessToken provideAccessToken() throws ExternalRequestError {
        String token = auth.getCurrentUser().getIdToken(false).getResult().getToken();
        Log.d("MerchantTokenProvider", "token: " + token);
        String accesToken = "";
        try {
            String json = HttpAgent.get("https://guarded-crag-45195.herokuapp.com/api/user/access-tokens/payu")
                    .headers("X-Authorization-Firebase", token).execute().get();
            accesToken = new JSONObject(json).getString("access_token");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new ExternalRequestError(ExternalRequestError.ExternalErrorType.NETWORK_ERROR);
        } catch(JSONException e)
        {
            e.printStackTrace();
            throw new ExternalRequestError(ExternalRequestError.ExternalErrorType.SERVER_ERROR);
        }
        Log.d("MerchantTokenProvider", "accesToken: " + accesToken);
        return new MerchantOAuthAccessToken(accesToken);
    }
}
