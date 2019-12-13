package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnMultiple, btnAverage;
    EditText edtNum1, edtNum2, edtNum3;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnMultiple = findViewById(R.id.btn_multiple);
        btnAverage = findViewById(R.id.btn_average);

        edtNum1 = findViewById(R.id.number1);
        edtNum2 = findViewById(R.id.number2);
        edtNum3 = findViewById(R.id.number3);

        result = findViewById(R.id.result);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = Sum();
                result.setText(sum+"");
            }
        });

        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int multiple = Multiple();
                result.setText(multiple+"");
            }
        });

        btnAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("#.00");
                double average = Average();
                result.setText(df.format(average)+"");
            }
        });
    }

    public int Sum(){
        return Integer.valueOf(edtNum1.getText().toString()) + Integer.valueOf(edtNum2.getText().toString()) + Integer.valueOf(edtNum3.getText().toString());
    }

    public int Multiple(){
        return Integer.valueOf(edtNum1.getText().toString()) * Integer.valueOf(edtNum2.getText().toString()) * Integer.valueOf(edtNum3.getText().toString());
    }

    public double Average(){
        return (Double.valueOf(edtNum1.getText().toString()) + Double.valueOf(edtNum2.getText().toString()) + Double.valueOf(edtNum3.getText().toString()))/3;
    }
}
