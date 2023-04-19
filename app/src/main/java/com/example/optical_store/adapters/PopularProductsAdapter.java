package com.example.optical_store.adapters;


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
import com.example.optical_store.models.NewProductsModel;
import com.example.optical_store.models.PopularProductsModel;

import java.util.List;

public abstract class PopularProductsAdapter extends RecyclerView.Adapter<PopularProductsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    private Context context;
    private List<PopularProductsModel> popularProductsModelList;

    public PopularProductsAdapter(Context context, List<NewProductsModel> list) {
        this.context = context;
        this.popularProductsModelList = popularProductsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewProductsAdapter.viewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(popularProductsModelList.get(position).getImg_url()).into(holder.newImg);
        holder.newName.setText(popularProductsModelList.get(position).getName());
        holder.newPrice.setText(String.valueOf(popularProductsModelList.get(position).getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detailed",List.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return popularProductsModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView Name,Price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.all_img);
            Name = itemView.findViewById(R.id.all_product_name);
            Price = itemView.findViewById(R.id.all_price);
        }
    }

}
