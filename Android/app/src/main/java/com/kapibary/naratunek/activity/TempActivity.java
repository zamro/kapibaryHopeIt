package com.kapibary.naratunek.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

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
    AutoCompleteTextView amountView;
    Button paymentButton;
    boolean isPaymentSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        amountView = (AutoCompleteTextView) findViewById(R.id.amount);
        paymentButton = (Button) findViewById(R.id.button);
        mPaymentService = PaymentService.createInstance(this);
    }

    void startPayment(View view) {
        if(!amountView.getText().toString().isEmpty() && isPaymentSelected) {
            Double amount = 100 * Double.valueOf(amountView.getText().toString());
            mPaymentService
                    .pay(new Order.Builder()
                            .withAmount(amount.longValue())
                            .withCurrency(Currency.PLN)
                            .withDescription("Example payment")
                            .build());
        }
    }
    private PaymentService mPaymentService;
    private PaymentEventBus mPaymentEventBus = new PaymentEventBus();
    protected void onPause() {
        mPaymentEventBus.unregister(this);
        super.onPause();
    }
    protected void onResume() {
        super.onResume();
        mPaymentEventBus.register(this);
    }
    public void onPaymentProcessEventBackgroundThread(PaymentSuccessEvent event) {
        Log.d("DUPA", "Udało się" + event.getOrderId());
        Snackbar.make(amountView, R.string.permission_rationale, 10);
    }
    public void onPaymentProcessEventBackgroundThread(PaymentFailedEvent event) {
        Log.d("DUPA", "Nie udało się" + event.getBusinessError().toString());
        Snackbar.make(amountView, "Failed", 10);
    }
    public void onPaymentProcessEventMainThread(PresentSelectedPaymentMethodEvent event) {
        Log.d("DUPA", "PresentSelectedPaymentMethodEvent");
        isPaymentSelected = true;
    }

    public void onPaymentProcessEventMainThread(AbsentSelectedPaymentMethodEvent event) {
        Log.d("DUPA", "AbsentSelectedPaymentMethodEvent");
        isPaymentSelected = false;
    }
}
