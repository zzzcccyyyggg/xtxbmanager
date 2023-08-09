package com.example.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.manager.ParkingLot;

import java.util.List;

public class DriverAdapter extends ArrayAdapter<Driver> {

    public DriverAdapter(Context context, List<Driver> parkingLots) {
        super(context, 0, parkingLots);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_driver, parent, false);
        }

        Driver currentParking = getItem(position);

        TextView nameTextView = itemView.findViewById(R.id.textViewName);
        TextView PhoneTextView = itemView.findViewById(R.id.textViewPhone);

        nameTextView.setText(currentParking.getName());
        PhoneTextView.setText(currentParking.getPhoneNumber());


        return itemView;
    }
}
