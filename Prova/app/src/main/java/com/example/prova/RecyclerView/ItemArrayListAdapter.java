package com.example.prova.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prova.R;

import java.util.ArrayList;

public class ItemArrayListAdapter extends RecyclerView.Adapter<ItemArrayListAdapter.ViewHolder> {

    private int itemLayout;
    private ArrayList<Item> itemList;

    public ItemArrayListAdapter(int layoutId, ArrayList<Item> itemList){
        this.itemLayout = layoutId;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView tv_titulo = holder.tv_titulo;
        TextView tv_descricao = holder.tv_descricao;
        tv_titulo.setText(itemList.get(position).getTitulo());
        tv_descricao.setText(itemList.get(position).getDescricao());
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_titulo;
        public TextView tv_descricao;

        public ViewHolder (View itemView){
            super(itemView);
            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_descricao = itemView.findViewById(R.id.tv_descricao);
        }
    }
}
