package com.example.hw02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_AddTopping;
    private Button btn_Checkout;
    private Button btn_ClearPizza;
    private CheckBox cb_Delivery;
    private ProgressBar progressBar;
    private CharSequence[]  toppings = {"Bacon", "Cheese","Garlic", "Green Pepper", "Mushroom", "Olives", "Onions", "Red Pepper"};
    private ArrayList<String> selectedToppings = new ArrayList<String>();
    public static final String TAG_ORDER = "order";
    public static final String TAG_TOPPING = "topping";
    private static final int REQ_CODE = 5;
    private TableRow tr1;
    private TableRow tr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pizza Store");

        progressBar = findViewById(R.id.progressBar);
        cb_Delivery = findViewById(R.id.cb_delivery);

        /* Find Tablelayout defined in main.xml */
        TableLayout tl = findViewById(R.id.tbl_selectedToppings);
        /* Create a new row to be added. */
        tr1 = new TableRow(this);
        tr1.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        tr2 = new TableRow(this);
        tr2.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        /* Add row to TableLayout. */
        tl.addView(tr1,new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        tl.addView(tr2,new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        // Creating and Building the Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose A Topping");
        builder.setSingleChoiceItems(toppings, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {

                if(selectedToppings.size() >= 10){
                    Toast.makeText(MainActivity.this, "Maximum Topping capacity reached!", Toast.LENGTH_SHORT).show();
                }else {
                    final String selectedTopping = toppings[index].toString();

                    switch (toppings[index].toString()) {
                        case "Bacon":
                            // Add image to row.
                            ImageView im_bacon = new ImageView(MainActivity.this);
                            im_bacon.setBackgroundResource(R.drawable.bacon);
                            if(tr1.getChildCount() <5){
                                tr1.addView(im_bacon);
                                selectedToppings.add(selectedTopping);
                            }else if(tr2.getChildCount() <5){
                                tr2.addView(im_bacon);
                                selectedToppings.add(selectedTopping);
                            }

                            im_bacon.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view_bacon) {
                                Log.d("TOPPINGS", "onClick: Image clicked");
                                if(tr1.getChildCount() < 0){
                                    tr2.removeView(view_bacon);
                                    selectedToppings.remove(selectedTopping);
                                }else{
                                    tr1.removeView(view_bacon);
                                    selectedToppings.remove(selectedTopping);
                                }
                            }
                        });

                            break;
                        case "Cheese":
                            ImageView im_cheese = new ImageView(MainActivity.this);
                            im_cheese.setBackgroundResource(R.drawable.cheese);
                            if(tr1.getChildCount() <5){
                                tr1.addView(im_cheese);
                                selectedToppings.add(selectedTopping);
                            }else if(tr2.getChildCount() <5){
                                tr2.addView(im_cheese);
                                selectedToppings.add(selectedTopping);
                            }
                            im_cheese.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_cheese) {
                                    if(tr1.getChildCount() < 0){
                                        tr2.removeView(view_cheese);
                                        selectedToppings.remove(selectedTopping);
                                    }else{
                                        tr1.removeView(view_cheese);
                                        selectedToppings.remove(selectedTopping);
                                    }
                                }
                            });

                            break;
                        case "Garlic":
                            ImageView im_garlic = new ImageView(MainActivity.this);
                            im_garlic.setBackgroundResource(R.drawable.garlic);
                            if(tr1.getChildCount() <5){
                                tr1.addView(im_garlic);
                                selectedToppings.add(selectedTopping);
                            }else if(tr2.getChildCount() <5){
                                tr2.addView(im_garlic);
                                selectedToppings.add(selectedTopping);
                            }
                            im_garlic.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_garlic) {
                                    if(tr1.getChildCount() < 0){
                                        tr2.removeView(view_garlic);
                                        selectedToppings.remove(selectedTopping);
                                    }else{
                                        tr1.removeView(view_garlic);
                                        selectedToppings.remove(selectedTopping);
                                    }
                                }
                            });
                            break;
                        case "Green Pepper":
                            ImageView im_greenPepper = new ImageView(MainActivity.this);
                            im_greenPepper.setBackgroundResource(R.drawable.green_pepper);
                            if(tr1.getChildCount() <5){
                                tr1.addView(im_greenPepper);
                                selectedToppings.add(selectedTopping);
                            }else if(tr2.getChildCount() <5){
                                tr2.addView(im_greenPepper);
                                selectedToppings.add(selectedTopping);
                            }
                            im_greenPepper.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_greenPepper) {
                                    if(tr1.getChildCount() < 0){
                                        tr2.removeView(view_greenPepper);
                                        selectedToppings.remove(selectedTopping);
                                    }else{
                                        tr1.removeView(view_greenPepper);
                                        selectedToppings.remove(selectedTopping);
                                    }
                                }
                            });
                            break;
                        case "Mushroom":
                            ImageView im_mushroom = new ImageView(MainActivity.this);
                            im_mushroom.setBackgroundResource(R.drawable.mushroom);
                            if(tr1.getChildCount() <5){
                                tr1.addView(im_mushroom);
                                selectedToppings.add(selectedTopping);
                            }else if(tr2.getChildCount() <5){
                                tr2.addView(im_mushroom);
                                selectedToppings.add(selectedTopping);
                            }
                            im_mushroom.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_mushroom) {
                                    if(tr1.getChildCount() < 0){
                                        tr2.removeView(view_mushroom);
                                        selectedToppings.remove(selectedTopping);
                                    }else{
                                        tr1.removeView(view_mushroom);
                                        selectedToppings.remove(selectedTopping);
                                    }
                                }
                            });
                            break;
                        case "Olives":
                            ImageView im_olive = new ImageView(MainActivity.this);
                            im_olive.setBackgroundResource(R.drawable.olive);
                            if(tr1.getChildCount() <5){
                                tr1.addView(im_olive);
                                selectedToppings.add(selectedTopping);
                            }else if(tr2.getChildCount() <5){
                                tr2.addView(im_olive);
                                selectedToppings.add(selectedTopping);
                            }
                            im_olive.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_olive) {
                                    if(tr1.getChildCount() < 0){
                                        tr2.removeView(view_olive);
                                        selectedToppings.remove(selectedTopping);
                                    }else{
                                        tr1.removeView(view_olive);
                                        selectedToppings.remove(selectedTopping);
                                    }
                                }
                            });
                            break;
                        case "Onions":
                            ImageView im_onion = new ImageView(MainActivity.this);
                            im_onion.setBackgroundResource(R.drawable.onion);
                            if(tr1.getChildCount() <5){
                                tr1.addView(im_onion);
                                selectedToppings.add(selectedTopping);
                            }else if(tr2.getChildCount() <5){
                                tr2.addView(im_onion);
                                selectedToppings.add(selectedTopping);
                            }
                            im_onion.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_onion) {
                                    if(tr1.getChildCount() < 0){
                                        tr2.removeView(view_onion);
                                        selectedToppings.remove(selectedTopping);
                                    }else{
                                        tr1.removeView(view_onion);
                                        selectedToppings.remove(selectedTopping);
                                    }
                                }
                            });
                            break;
                        case "Red Pepper":
                            ImageView im_redPepper = new ImageView(MainActivity.this);
                            im_redPepper.setBackgroundResource(R.drawable.red_pepper);
                            if(tr1.getChildCount() <5){
                                tr1.addView(im_redPepper);
                                selectedToppings.add(selectedTopping);
                            }else if(tr2.getChildCount() <5){
                                tr2.addView(im_redPepper);
                                selectedToppings.add(selectedTopping);
                            }
                            im_redPepper.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_redPepper) {
                                    if(tr1.getChildCount() < 0){
                                        tr2.removeView(view_redPepper);
                                        selectedToppings.remove(selectedTopping);
                                    }else{
                                        tr1.removeView(view_redPepper);
                                        selectedToppings.remove(selectedTopping);
                                    }
                                }
                            });
                            break;
                        default:

                    }
                    progressBar.setMax(10);
                    progressBar.setProgress(selectedToppings.size());
                }
            }
        });

        final AlertDialog alert = builder.create();

        btn_AddTopping = findViewById(R.id.btn_addTopping);
        btn_AddTopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
            }

        });

        btn_Checkout = findViewById(R.id.btn_checkout);
        btn_Checkout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this, OrderActivity.class);

                Order pizzaOrder = new Order(selectedToppings.size(), cb_Delivery.isChecked());

                Bundle sentData = new Bundle();
                sentData.putSerializable("pizzaOrder",pizzaOrder);
                sentData.putStringArrayList("toppings", selectedToppings);
                intent.putExtra(TAG_ORDER, sentData);

                startActivity(intent);

            }
        });

        btn_ClearPizza = findViewById(R.id.btn_clearPizza);
        btn_ClearPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedToppings.clear();
                progressBar.setProgress(0);
                tr1.removeAllViews();
                tr2.removeAllViews();
                cb_Delivery.setChecked(false);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("TOPPINGS" ,"onActivity Result");
    }
/*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("TOPPINGS" ,"onActivity Result");
        if (requestCode==REQ_CODE){
            if(resultCode==RESULT_OK){
                selectedToppings.clear();
                progressBar.setProgress(0);
                tr1.removeAllViews();
                tr2.removeAllViews();
                cb_Delivery.setChecked(false);
            }
        }*/
    //}
}
