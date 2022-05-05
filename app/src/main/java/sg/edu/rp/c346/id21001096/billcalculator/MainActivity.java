package sg.edu.rp.c346.id21001096.billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button split;
    Button reset;
    EditText inputamt;
    EditText inputpax;
    RadioGroup mode;
    EditText inputdiscount;
    ToggleButton svs;
    ToggleButton gst;
    TextView tvEachPays;
    TextView tvTotalBill;
    RadioButton paynow;
    RadioButton cash;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        inputamt = findViewById(R.id.inputamt);
        inputpax = (EditText) findViewById(R.id.inputpax);
        mode = findViewById(R.id.mode);
        inputdiscount = findViewById(R.id.inputdiscount);
        mode = findViewById(R.id.mode);
        svs = findViewById(R.id.svs);
        gst = findViewById(R.id.gst);
        tvTotalBill = findViewById(R.id.tvTotalBill);
        tvEachPays = findViewById(R.id.tvEachPays);
        paynow = findViewById(R.id.paynow);
        cash = findViewById(R.id.cash);



        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputamt.getText().toString().length() == 0 || inputpax.getText().toString().length() == 0) {
                    tvTotalBill.setText("Error");

                } else {
                    String data1 = inputamt.getText().toString();
                    String data2 = inputpax.getText().toString();

                    double inputamt = Double.parseDouble(data1);
                    int inputpax = Integer.parseInt(data2);
                    double newAmount = 0;
                    int pax = Integer.parseInt(data2);

                    if (gst.isChecked() == true && svs.isChecked() == true) {
                        newAmount = inputamt * 1.10 * 1.07;
                    } else if (gst.isChecked() == false && svs.isChecked() == true) {
                        newAmount = inputamt * 1.10 * 1.10;
                    } else if (gst.isChecked() == true && svs.isChecked() == false) {
                        newAmount = inputamt * 1.07;
                    } else {
                        newAmount = inputamt;

                    }
                    double eachPays = newAmount / inputpax;
                    if (paynow.isChecked() == true) {
                        tvTotalBill.setText("$" + newAmount + "" + " Paynow 88030256");
                        tvEachPays.setText("$" + (newAmount/inputpax) + "");
                    }else

                    tvTotalBill.setText("$" + newAmount + "");
                    tvEachPays.setText("$" + (newAmount/inputpax) + "");
                }




            }
        });
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v==reset) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }
        });


    }}