package com.kapibary.naratunek.payU;

import android.content.Context;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.kapibary.naratunek.service.RestClient;
import com.payu.android.sdk.payment.model.MerchantOAuthAccessToken;
import com.payu.android.sdk.payment.service.TokenProviderService;
import com.payu.android.sdk.payment.service.exception.ExternalRequestError;

@SuppressWarnings("unused")
public class MerchantTokenProviderService extends TokenProviderService {
    private final FirebaseAuth auth = FirebaseAuth.getInstance();

    public MerchantTokenProviderService(Context context) {
        super(context);
    }

    @Override
    public MerchantOAuthAccessToken provideAccessToken() throws ExternalRequestError {
        String accessToken = RestClient.getPayUAccesToken();
        Log.d("MerchantTokenProvider", "accessToken: " + accessToken);
        return new MerchantOAuthAccessToken(accessToken);
    }
}
