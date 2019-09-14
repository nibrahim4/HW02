package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private Bundle extrasFromMain;
    private Order order;
    private final String TAG_ORDER = "order";
    private final String TAG_TOPPING = "topping";
    public TextView tv_toppingsTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tv_toppingsTotal = findViewById(R.id.tv_toppingsTotal);

        extrasFromMain = getIntent().getExtras().getBundle(TAG_ORDER);

        order = (Order) extrasFromMain.getSerializable("pizzaOrder");

        DecimalFormat df = new DecimalFormat("##.00");

        tv_toppingsTotal.setText("$"+ df.format(order.GetToppingsTotal()).toString());

        ArrayList<String> toppingNames = extrasFromMain.getStringArrayList(TAG_TOPPING);
        Log.d("TOPPINGS", "onCreate: " + toppingNames );
    }
}
