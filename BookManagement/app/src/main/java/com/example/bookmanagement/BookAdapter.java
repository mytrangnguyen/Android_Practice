package com.example.bookmanagement;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.userViewHolder> {
    List<Book> bookList = new ArrayList<>();
    OnItemClickListener listener;

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);

        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        holder.nameBook.setText(bookList.get(position).getName());
        holder.yearBook.setText(bookList.get(position).getYear());

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class userViewHolder extends RecyclerView.ViewHolder{
        TextView nameBook;
        TextView yearBook;
        ImageView btnUpdate;
        ImageView btnDelete;

        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            nameBook = itemView.findViewById(R.id.nameBook);
            yearBook = itemView.findViewById(R.id.yearBook);
            btnUpdate = itemView.findViewById(R.id.btn_update);
            btnDelete = itemView.findViewById(R.id.btn_delete);

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickUpdate(getAdapterPosition());
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickDelete(getAdapterPosition());
                }
            });
        }
    }

    interface OnItemClickListener {
        void onClickUpdate(int position);

        void onClickDelete(int position);
    }

}
