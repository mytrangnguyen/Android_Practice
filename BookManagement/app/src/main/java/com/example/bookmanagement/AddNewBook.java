package com.example.bookmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewBook extends AppCompatActivity {

    Button btnAdd;
    EditText name, year;
    BookDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);

        db = Room.databaseBuilder(getApplicationContext(),
                BookDatabase.class, "database-name").build();


        btnAdd = findViewById(R.id.btn_add);
        name = findViewById(R.id.edtName);
        year = findViewById(R.id.edtYear);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addNewBook();
                        finish();
                    }
                });
            }
        });

    }

    @SuppressLint("StaticFieldLeak")
    private void addNewBook(){
        final String nameB = name.getText().toString();

        final String yearB = year.getText().toString();
        if (nameB.isEmpty()) {
            Toast.makeText(this, "You must enter data in this field", Toast.LENGTH_SHORT).show();
            return;
        }

        if (yearB.isEmpty()) {
            Toast.makeText(this, "You must enter data in this field", Toast.LENGTH_SHORT).show();
            return;
        }

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Book newBook = new Book(nameB, yearB);
                db.BookDao().insert(newBook);
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(AddNewBook.this, "Add Successfully", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }



}
