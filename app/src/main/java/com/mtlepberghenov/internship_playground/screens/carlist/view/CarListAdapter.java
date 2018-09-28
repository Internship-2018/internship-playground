package com.mtlepberghenov.internship_playground.screens.carlist.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.model.entity.Car;

import java.util.ArrayList;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.MyViewHolder>{

    private ArrayList<Car> carList = new ArrayList<>();

    @NonNull
    @Override
    public CarListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false);

        return new CarListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarListAdapter.MyViewHolder holder, int i) {
        holder.textViewCarName.setText(carList.get(i).getCarMake());
        holder.textViewCarModel.setText(carList.get(i).getModel());
        holder.textViewCarColor.setText(carList.get(i).getColor());
        holder.textViewCarYear.setText(carList.get(i).getYear());
        holder.textViewCarKitAirCon.setText(carList.get(i).getCarKitting().getAirConditioner());
        holder.textViewCarKitGps.setText(carList.get(i).getCarKitting().getGps());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public void setData(ArrayList<Car> carList) {
        this.carList.clear();
        this.carList.addAll(carList);
        notifyDataSetChanged();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewCarName;
        private TextView textViewCarModel;
        private TextView textViewCarColor;
        private TextView textViewCarYear;
        private TextView textViewCarKitGps;
        private TextView textViewCarKitAirCon;

        public MyViewHolder(@NonNull View v) {
            super(v);

            textViewCarName = v.findViewById(R.id.item_view_car_name);
            textViewCarModel = v.findViewById(R.id.item_view_car_model);
            textViewCarColor = v.findViewById(R.id.item_view_car_color);
            textViewCarYear = v.findViewById(R.id.item_view_car_year);
            textViewCarKitGps = v.findViewById(R.id.item_view_gps);
            textViewCarKitAirCon = v.findViewById(R.id.item_view_air_con);

        }
    }
}
