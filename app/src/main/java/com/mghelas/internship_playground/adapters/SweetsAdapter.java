package com.mghelas.internship_playground.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.sweetsfactory.Chocolate;
import com.mghelas.internship_playground.sweetsfactory.Lollipop;

import java.util.ArrayList;
import java.util.List;

public class SweetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> items = new ArrayList<>();
    private static final int ITEM_TYPE_CHOCOLATE = 1;
    private static final int ITEM_TYPE_LOLLIPOP = 2;

    public SweetsAdapter(List<Object> items) {
        System.out.println("asdasd");
        this.items.addAll(items);
    }

    private static class ChocolateViewHolder extends RecyclerView.ViewHolder {

        public TextView title, price, weight, percentage;

        public ChocolateViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            weight = (TextView) itemView.findViewById(R.id.weight);
            percentage = (TextView) itemView.findViewById(R.id.percentage);

            // prepare your ViewHolder
        }

        public void bind(Chocolate chocolate) {
            title.setText(chocolate.getTitle());
            price.setText(chocolate.getPrice() + "");
            weight.setText(chocolate.getWeight() + "");
            percentage.setText(chocolate.getPercentage() + "");
        }
    }

    private static class LollipopViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price, weight, flavour;

        public LollipopViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            weight = (TextView) itemView.findViewById(R.id.weight);
            flavour = (TextView) itemView.findViewById(R.id.flavour);
            // prepare your ViewHolder
        }

        public void bind(Lollipop lollipop) {
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
        Object item = items.get(position);

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
