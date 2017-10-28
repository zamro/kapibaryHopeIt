package com.kapibary.naratunek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.kapibary.naratunek.R;
import com.payu.android.sdk.payment.PaymentEventBus;
import com.payu.android.sdk.payment.PaymentService;
import com.payu.android.sdk.payment.event.AbsentSelectedPaymentMethodEvent;
import com.payu.android.sdk.payment.event.PaymentFailedEvent;
import com.payu.android.sdk.payment.event.PaymentSuccessEvent;
import com.payu.android.sdk.payment.event.PresentSelectedPaymentMethodEvent;
import com.payu.android.sdk.payment.model.Currency;
import com.payu.android.sdk.payment.model.Order;

public class TempActivity extends AppCompatActivity {
    private AutoCompleteTextView amountView;
    private Button button;
    private boolean isPaymentSelected = false;
    private PaymentService mPaymentService;
    private final PaymentEventBus mPaymentEventBus = new PaymentEventBus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        amountView = (AutoCompleteTextView) findViewById(R.id.amount);
        button = (Button) findViewById(R.id.button);
        mPaymentService = PaymentService.createInstance(this);
    }

    @SuppressWarnings("unused")
    public void startPayment(View view) {
        if(!amountView.getText().toString().isEmpty() && isPaymentSelected) {
            Double amount = 100 * Double.valueOf(amountView.getText().toString());
            mPaymentService
                    .pay(new Order.Builder()
                            .withAmount(amount.longValue())
                            .withCurrency(Currency.PLN)
                            .withDescription("Example payment")
                            .withNotifyUrl("https://guarded-crag-45195.herokuapp.com/api/payments")
                            .build());
            button.setEnabled(false);
        }
    }

    protected void onPause() {
        mPaymentEventBus.unregister(this);
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        mPaymentEventBus.register(this);
    }

    @SuppressWarnings("unused")
    public void onPaymentProcessEventMainThread(PaymentSuccessEvent event) {
        Toast.makeText(TempActivity.this, "Płatność zakończona powodzeniem.",
                Toast.LENGTH_SHORT).show();
        button.setEnabled(true);
        finish();
    }

    @SuppressWarnings("unused")
    public void onPaymentProcessEventMainThread(PaymentFailedEvent event) {
        Toast.makeText(TempActivity.this, "Płatność zakończona błędem. Pieniądze z konta nie zostały pobrane.",
                Toast.LENGTH_SHORT).show();
        button.setEnabled(true);
    }

    @SuppressWarnings("unused")
    public void onPaymentProcessEventMainThread(PresentSelectedPaymentMethodEvent event) {
        isPaymentSelected = true;
    }

    @SuppressWarnings("unused")
    public void onPaymentProcessEventMainThread(AbsentSelectedPaymentMethodEvent event) {
        isPaymentSelected = false;
    }
}
