package com.example.manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.manager.ParkingLot;
import com.example.manager.R;

import java.util.ArrayList;
import java.util.List;

public class MasterActivity extends AppCompatActivity {

    private List<ParkingLot> parkingLots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        // 初始化停车场数据
        parkingLots = new ArrayList<>();

        // 初始化 20 条停车场数据
        for (int i = 1; i <= 20; i++) {
            ParkingLot parkingLot = new ParkingLot("停车场 " + i);
            parkingLots.add(parkingLot);
        }

        // 初始化适配器
        ParkingLotAdapter adapter = new ParkingLotAdapter(this, parkingLots);

        // 将适配器连接到 ListView（或 RecyclerView）
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // 添加点击监听器来进行审计操作
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ParkingLot selectedParking = parkingLots.get(position);

                // 创建 Intent 并传递选中的停车场名称到详细信息页面
                Intent intent = new Intent(MasterActivity.this, ParkingDetailsActivity.class);
                startActivity(intent);
            }
        });

    }
}

