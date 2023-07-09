package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;

        edtWeight = findViewById(R.id.edWeight);
        edtHeightIn = findViewById(R.id.edHeightIn);
        edtHeightFt = findViewById(R.id.edHeightFt);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtResult  = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt = Integer.parseInt(edtWeight.getText().toString());
               int ft = Integer.parseInt(edtHeightFt.getText().toString());
               int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm= totalIn*2.53;
                double totalm = totalCm/100;
                double bmi = wt/(totalm*totalm);

                if(bmi>25){
                    txtResult.setText("you are Over Weight");
                } else if (bmi<18) {
                    txtResult.setText("you are under weight");
                }else
                    txtResult.setText("you are healthy");

            }
        });

    }
}