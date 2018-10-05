package com.mghelas.internship_playground.sweet_screen.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.Entity.Chocolate;
import com.mghelas.internship_playground.Entity.Lollipop;
import com.mghelas.internship_playground.Entity.Sweet;

import java.util.ArrayList;
import java.util.List;

public class SweetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public interface OnItemClickListener {
        void onItemClick(int id);
    }

    private List<Sweet> items = new ArrayList<>();
    private final OnItemClickListener listener;
    private static final int ITEM_TYPE_CHOCOLATE = 1;
    private static final int ITEM_TYPE_LOLLIPOP = 2;

    public SweetAdapter(List<Sweet> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    public List<Sweet> getItems() {
        return items;
    }



    private class ChocolateViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView price;
        private TextView weight;
        private TextView percentage;

        ChocolateViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titleDetailed);
            price = (TextView) itemView.findViewById(R.id.priceDetailed);
            weight = (TextView) itemView.findViewById(R.id.weightDetailed);
            percentage = (TextView) itemView.findViewById(R.id.percentage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }

        void bind(final Chocolate chocolate) {
            title.setText(chocolate.getTitle());
            price.setText(chocolate.getPrice() + "");
            weight.setText(chocolate.getWeight() + "");
            percentage.setText(chocolate.getPercentage() + "");
        }
    }

    private class LollipopViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price, weight, flavour;

        LollipopViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titleDetailed);
            price = (TextView) itemView.findViewById(R.id.priceDetailed);
            weight = (TextView) itemView.findViewById(R.id.weightDetailed);
            flavour = (TextView) itemView.findViewById(R.id.flavourDetailed);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }

        void bind(final Lollipop lollipop) {
            title.setText(lollipop.getTitle());
            price.setText(lollipop.getPrice() + "");
            weight.setText(lollipop.getWeight() + "");
            flavour.setText(lollipop.getFlavour() + "");
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_TYPE_CHOCOLATE) {
            View v = layoutInflater.inflate(R.layout.chocolate_list_row, parent, false);

            return new ChocolateViewHolder(v);
        } else {
            View v = layoutInflater.inflate(R.layout.lollipop_list_row, parent, false);

            return new LollipopViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Sweet item = items.get(position);

        if (viewHolder instanceof ChocolateViewHolder) {
            ((ChocolateViewHolder) viewHolder).bind((Chocolate) item);
        } else {
            ((LollipopViewHolder) viewHolder).bind((Lollipop) item);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Chocolate) {
            return ITEM_TYPE_CHOCOLATE;
        } else {
            return ITEM_TYPE_LOLLIPOP;
        }
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


}
