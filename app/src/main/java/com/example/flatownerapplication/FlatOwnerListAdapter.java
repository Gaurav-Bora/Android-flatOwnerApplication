package com.example.flatownerapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FlatOwnerListAdapter extends RecyclerView.Adapter<FlatOwnerListAdapter.MyViewHolder> {
    Context context;
    List<FlatOwner> flatOwnerList;

    public FlatOwnerListAdapter(Context context, List<FlatOwner> flatOwnerList) {
        this.context = context;
        this.flatOwnerList = flatOwnerList;
    }

    @NonNull
    @Override
    public FlatOwnerListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.flatowner_list,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlatOwnerListAdapter.MyViewHolder holder, int position) {
        FlatOwner flatOwner = flatOwnerList.get(position);
        holder.textFlatno.setText(flatOwner.getFlatno());
        holder.textName.setText(flatOwner.getName());

    }

    @Override
    public int getItemCount() {
        return flatOwnerList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textName,textFlatno;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textFlatno = itemView.findViewById(R.id.textFlatno);
            textName = itemView.findViewById(R.id.textName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("flat", flatOwnerList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
