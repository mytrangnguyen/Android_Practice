package com.example.bookmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    BookDatabase db;
    Button btnAdd;
    BookAdapter adapter;
    RecyclerView rvBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);

        db = Room.databaseBuilder(getApplicationContext(),
                BookDatabase.class, "database-name").build();

        rvBook = findViewById(R.id.recyclerViewBook);
        rvBook.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvBook.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BookAdapter();
        adapter.listener = new BookAdapter.OnItemClickListener(){
            @Override
            public void onClickUpdate(int position) {

            }

            @Override
            public void onClickDelete(int position) {
                onDelete(position);
            }
        };
        rvBook.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewBook.class);
                startActivity(intent);            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayBook();
    }


    @SuppressLint("StaticFieldLeak")
    private void displayBook(){
        new AsyncTask<Void, Void, List<Book>>(){

            @Override
            protected List<Book> doInBackground(Void... voids) {
                return db.BookDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Book> books) {
                super.onPostExecute(books);
                adapter.bookList = books;
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }

    private void onDelete(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        final Book todoDelete = adapter.bookList.get(position);

                        new AsyncTask<Void, Void, Void>() {
                            @Override
                            protected Void doInBackground(Void... voids) { // xóa trong db
                                db.BookDao().delete(todoDelete);
                                return null;
                            }

                            @Override
                            protected void onPostExecute(Void aVoid) { // xóa trong recycleView
                                super.onPostExecute(aVoid);
                                adapter.bookList.remove(todoDelete);
                                adapter.notifyDataSetChanged();
                            }
                        }.execute();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
