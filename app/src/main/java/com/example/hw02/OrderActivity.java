package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private Bundle extrasFromMain;
    private Order order;
    private final String TAG_ORDER = "order";
    private final String TAG_TOPPING = "topping";
    public TextView tv_toppingsTotal;
    private TextView tv_deliveryPrice;
    private Button btn_finish;
    private ArrayList<String> toppingsFromMain = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tv_toppingsTotal = findViewById(R.id.tv_toppingsTotal);
        btn_finish = findViewById(R.id.btn_finish);
        tv_deliveryPrice = findViewById(R.id.tv_deliveryCost);

        extrasFromMain = getIntent().getExtras().getBundle(TAG_ORDER);

        order = (Order) extrasFromMain.getSerializable("pizzaOrder");
        toppingsFromMain =  extrasFromMain.getStringArrayList("toppings");

        DecimalFormat df = new DecimalFormat("##.00");

        if (order.IsDeliveryChecked()){
            tv_deliveryPrice.setText("$" + df.format(order.GetDeliveryCost()));
        }else{
            tv_deliveryPrice.setText("$0.00");
        }

        if(order.GetToppingsCount() <= 0){
            tv_toppingsTotal.setText("$0.00");
        }else{
            tv_toppingsTotal.setText("$"+ df.format(order.GetToppingsTotal()));
        }

        //ArrayList<String> toppingNames = extrasFromMain.getStringArrayList(TAG_TOPPING);
        Log.d("TOPPINGS", "onCreate: " + toppingsFromMain );

        btn_finish.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
