package com.example.coursematchdaddy;// OutputAdapter.java

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OutputAdapter extends RecyclerView.Adapter<OutputAdapter.OutputViewHolder> {

    private final ArrayList<String> names;
    private final RecycleViewInterface recycleViewInterface;

    public OutputAdapter(ArrayList<String> names, RecycleViewInterface recycleViewInterface) {
        this.names = names;
        this.recycleViewInterface = recycleViewInterface;
    }

    @NonNull
    @Override
    public OutputViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new OutputViewHolder(itemView, recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull OutputViewHolder holder, int position) {
        String name = names.get(position);
        holder.tvName.setText(name);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class OutputViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvName;

        public OutputViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(view -> {
                if (recycleViewInterface != null) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        recycleViewInterface.onItemClick(position);
                    }
                }
            });
        }
    }
}