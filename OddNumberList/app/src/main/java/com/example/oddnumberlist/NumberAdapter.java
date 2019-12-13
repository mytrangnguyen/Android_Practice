package com.example.oddnumberlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {

    List<String> number = new ArrayList<>();

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_layout, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.countNum.setText(""+number.get(position));
    }

    @Override
    public int getItemCount() {
        return number.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView countNum;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            countNum = itemView.findViewById(R.id.txtCount);
        }
    }
}

