package com.example.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.manager.ParkingLot;

import java.util.List;

public class ParkingLotAdapter extends ArrayAdapter<ParkingLot> {

    public ParkingLotAdapter(Context context, List<ParkingLot> parkingLots) {
        super(context, 0, parkingLots);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_parking_lot, parent, false);
        }

        ParkingLot currentParking = getItem(position);
        Button auditButton = itemView.findViewById(R.id.auditButton);
        TextView nameTextView = itemView.findViewById(R.id.textViewName);
        TextView statusTextView = itemView.findViewById(R.id.textViewStatus);

        nameTextView.setText(currentParking.getName());

        if (!currentParking.isApproved()) {
            // 如果停车场未审核，显示审核按钮
            auditButton.setVisibility(View.VISIBLE);

            // 设置按钮点击监听器
            auditButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 处理审核按钮点击事件
                    currentParking.approve(); // 更新停车场状态
                    statusTextView.setText("已审核"); // 更新UI显示
                    notifyDataSetChanged(); // 通知适配器数据已更改
                }
            });
        } else {
            // 如果停车场已审核，隐藏审核按钮
            auditButton.setVisibility(View.GONE);
        }

        return itemView;
    }

}
