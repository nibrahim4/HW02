package com.example.hw02;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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
    private GridLayout gl;
    private int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pizza Store");

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setProgress(0);
        cb_Delivery = findViewById(R.id.cb_delivery);
        gl = findViewById(R.id.gl_selectedToppings);
        gl.setForegroundGravity(Gravity.CENTER);

        // Creating and Building the Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose A Topping");
        builder.setSingleChoiceItems(toppings, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {

                if(selectedToppings.size() >= 10){
                    Toast.makeText(MainActivity.this, "Maximum Capacity!", Toast.LENGTH_LONG).show();
                }else {
                    final String selectedTopping = toppings[index].toString();


                    switch (toppings[index].toString()) {
                        case "Bacon":
                            // Add image to row.
                            ImageView im_bacon = new ImageView(MainActivity.this);
                            im_bacon.setBackgroundResource(R.drawable.bacon);
                            im_bacon.setForegroundGravity(Gravity.CENTER_VERTICAL);
                            gl.addView(im_bacon);
                            selectedToppings.add(selectedTopping);

                            im_bacon.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view_bacon) {
                                gl.removeView(view_bacon);
                                selectedToppings.remove(selectedTopping);
                                progressBar.setProgress(selectedToppings.size());

                            }
                        });

                            break;
                        case "Cheese":
                            ImageView im_cheese = new ImageView(MainActivity.this);
                            im_cheese.setBackgroundResource(R.drawable.cheese);
                            im_cheese.setForegroundGravity(Gravity.CENTER_VERTICAL);
                            gl.addView(im_cheese);
                            selectedToppings.add(selectedTopping);
                            im_cheese.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_cheese) {
                                    gl.removeView(view_cheese);
                                    selectedToppings.remove(selectedTopping);
                                    progressBar.setProgress(selectedToppings.size());
                                }
                            });

                            break;
                        case "Garlic":
                            ImageView im_garlic = new ImageView(MainActivity.this);
                            im_garlic.setBackgroundResource(R.drawable.garlic);
                            im_garlic.setForegroundGravity(Gravity.CENTER_VERTICAL);
                            gl.addView(im_garlic);
                            selectedToppings.add(selectedTopping);

                            im_garlic.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_garlic) {
                                    gl.removeView(view_garlic);
                                    selectedToppings.remove(selectedTopping);
                                    progressBar.setProgress(selectedToppings.size());
                                }
                            });
                            break;
                        case "Green Pepper":
                            ImageView im_greenPepper = new ImageView(MainActivity.this);
                            im_greenPepper.setBackgroundResource(R.drawable.green_pepper);
                            im_greenPepper.setForegroundGravity(Gravity.CENTER_VERTICAL);
                            gl.addView(im_greenPepper);
                            selectedToppings.add(selectedTopping);

                            im_greenPepper.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_greenPepper) {
                                    gl.removeView(view_greenPepper);
                                    selectedToppings.remove(selectedTopping);
                                    progressBar.setProgress(selectedToppings.size());
                                }
                            });
                            break;
                        case "Mushroom":
                            ImageView im_mushroom = new ImageView(MainActivity.this);
                            im_mushroom.setBackgroundResource(R.drawable.mushroom);
                            im_mushroom.setForegroundGravity(Gravity.CENTER_VERTICAL);
                            gl.addView(im_mushroom);
                            selectedToppings.add(selectedTopping);

                            im_mushroom.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_mushroom) {
                                    gl.removeView(view_mushroom);
                                    selectedToppings.remove(selectedTopping);
                                    progressBar.setProgress(selectedToppings.size());
                                }
                            });
                            break;
                        case "Olives":
                            ImageView im_olive = new ImageView(MainActivity.this);
                            im_olive.setBackgroundResource(R.drawable.olive);
                            im_olive.setForegroundGravity(Gravity.CENTER_VERTICAL);
                            gl.addView(im_olive);
                            selectedToppings.add(selectedTopping);

                            im_olive.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_olive) {
                                    gl.removeView(view_olive);
                                    selectedToppings.remove(selectedTopping);
                                    progressBar.setProgress(selectedToppings.size());
                                }
                            });
                            break;
                        case "Onions":
                            ImageView im_onion = new ImageView(MainActivity.this);
                            im_onion.setBackgroundResource(R.drawable.onion);
                            im_onion.setForegroundGravity(Gravity.CENTER_VERTICAL);
                            gl.addView(im_onion);
                            selectedToppings.add(selectedTopping);

                            im_onion.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_onion) {
                                    gl.removeView(view_onion);
                                    selectedToppings.remove(selectedTopping);
                                    progressBar.setProgress(selectedToppings.size());
                                }
                            });
                            break;
                        case "Red Pepper":
                            ImageView im_redPepper = new ImageView(MainActivity.this);
                            im_redPepper.setBackgroundResource(R.drawable.red_pepper);
                            im_redPepper.setForegroundGravity(Gravity.CENTER_VERTICAL);
                            gl.addView(im_redPepper);
                            selectedToppings.add(selectedTopping);
                            im_redPepper.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view_redPepper) {
                                    gl.removeView(view_redPepper);
                                    selectedToppings.remove(selectedTopping);
                                    progressBar.setProgress(selectedToppings.size());
                                }
                            });
                            break;
                        default:

                    }
                    id = id + 1;

                    progressBar.setProgress(selectedToppings.size());
                }
            }
        });

        final AlertDialog alert = builder.create();

        btn_AddTopping = findViewById(R.id.btn_addTopping);
        btn_AddTopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedToppings.size() >= 10) {
                    Toast.makeText(MainActivity.this, "Maximum Topping capacity reached!", Toast.LENGTH_LONG).show();
                }else{
                    alert.show();
                }

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

                startActivityForResult(intent, REQ_CODE);

            }
        });

        btn_ClearPizza = findViewById(R.id.btn_clearPizza);
        btn_ClearPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedToppings.clear();
                progressBar.setProgress(0);
            }
        });
    }

@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQ_CODE){
            if(resultCode==RESULT_OK){
                selectedToppings.clear();
                progressBar.setProgress(0);
                cb_Delivery.setChecked(false);
            }
        }
    }
}
