package com.example.jetpackexample.databinding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpackexample.BR;
import com.example.jetpackexample.databinding.ItemRowsBinding;
import com.example.jetpackexample.databinding.listener.CustomClickListener;
import com.example.jetpackexample.databinding.model.DataModel;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements CustomClickListener {
    private List<DataModel> dataModelList;
    private Context context;
    public MyRecyclerViewAdapter(List<DataModel> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        this.context = ctx;
    }
    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRowsBinding itemRowsBinding = ItemRowsBinding.inflate(inflater, parent, false);
        return new MyViewHolder(itemRowsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);
        holder.binding.setVariable(BR.model, dataModel);
        holder.binding.setVariable(BR.itemClickListener, this);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return this.dataModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void cardClicked(DataModel f) {
        Toast.makeText(this.context, "You clicked " + ""+f.getAndroidName(),
                Toast.LENGTH_LONG).show();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemRowsBinding binding;
        public MyViewHolder(ItemRowsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
