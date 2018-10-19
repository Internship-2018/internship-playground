package com.mghelas.internship_playground.ui.sweetscreen.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Sweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SweetAdapter extends RecyclerView.Adapter<SweetAdapter.MyViewHolder> {


    private List<Sweet> items;
    private ItemClickHandler itemClickHandler;

    private List<Sweet> getItems() {
        return items;
    }

    public SweetAdapter(List<Sweet> items, ItemClickHandler itemClickHandler) {
        this.items = items;
        this.itemClickHandler = itemClickHandler;
    }

    public void updateData(List<Sweet> sweets){
        this.items = sweets;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sweet_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView type;
        TextView expiryDate;
        TextView confectionerName;

        MyViewHolder(View view) {
            super(view);
            name = itemView.findViewById(R.id.nameDetailed);
            type = itemView.findViewById(R.id.typeDetailed);
            expiryDate = itemView.findViewById(R.id.expiryDateDetailed);
            confectionerName = itemView.findViewById(R.id.confectionerNameDetailed);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickHandler.onItemClicked(getItems().get(getLayoutPosition()).getId());
                }
            });
        }

        void bindData(Sweet sweet) {
            String formattedDate = "";
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                Date date = sdf.parse(sweet.getExpiryDate());
                SimpleDateFormat readable = new SimpleDateFormat("dd-MM-yyyy, HH:mm");
                formattedDate = readable.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            name.setText(sweet.getName());
            type.setText(sweet.getType());
            expiryDate.setText(formattedDate);
            confectionerName.setText(sweet.getConfectionerName());
        }
    }
}
