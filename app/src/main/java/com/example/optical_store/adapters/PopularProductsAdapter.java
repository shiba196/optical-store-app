package com.example.optical_store.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.optical_store.R;
import com.example.optical_store.activities.DetailedActivity;
import com.example.optical_store.models.PopularProductsModel;

import java.text.BreakIterator;
import java.util.List;

public abstract class PopularProductsAdapter extends RecyclerView.Adapter<PopularProductsAdapter.ViewHolder> {


    private viewHolder holder;
    private int position;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private Context context;
    private List<PopularProductsModel> popularProductsModelList;

    public PopularProductsAdapter(Context context, List<PopularProductsModel> list) {
        this.context = context;
        this.popularProductsModelList = popularProductsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_product, parent, false));
    }

    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(popularProductsModelList.get(position).getImg_url()).into(holder.imageView);
        holder.Name.setText(popularProductsModelList.get(position).getName());
        holder.Price.setText(String.valueOf(popularProductsModelList.get(position).getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detailed",popularProductsModelList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return popularProductsModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        public BreakIterator name;
        ImageView imageView;
        TextView Name, Price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.all_img);
            Name = itemView.findViewById(R.id.all_product_name);
            Price = itemView.findViewById(R.id.all_price);
        }
    }

}
