package com.example.oddnumberlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNumber = findViewById(R.id.recyclerUser);
        recyclerViewNumber.setLayoutManager(new LinearLayoutManager(this));

        List<String> number = new ArrayList<>();
        int count = 0;
        int i = 3;
        while(count <1000){
            if(i%2!=0){
                number.add(String.valueOf(i));
                Log.d("lu", ""+i);
                count++;
            }
            i++;
        }

        NumberAdapter numberAdapter = new NumberAdapter();
        numberAdapter.number = number;

        recyclerViewNumber.setAdapter(numberAdapter);

    }
}
