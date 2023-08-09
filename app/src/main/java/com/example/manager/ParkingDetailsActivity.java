package com.example.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingDetailsActivity extends AppCompatActivity {

    private List<Driver> Drivers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details);

        // 初始化停车场数据
        Drivers = new ArrayList<>();

        // 初始化 20 条停车场数据
        for (int i = 1; i <= 20; i++) {
            Driver driver = new Driver("车主" + i,generateRandomPhoneNumber());
            Drivers.add(driver);
        }

        // 初始化适配器
        DriverAdapter adapter = new DriverAdapter(this,Drivers);

        // 将适配器连接到 ListView（或 RecyclerView）
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // 添加点击监听器来进行审计操作
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Driver selectedDriver = Drivers.get(position);
                Toast.makeText(ParkingDetailsActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                // 创建 Intent 并传递选中的车主名称到预约停车场信息页面
                Intent intent = new Intent(ParkingDetailsActivity.this, ReservationDetailsActivity.class);
                intent.putExtra(ReservationDetailsActivity.EXTRA_DRIVER_NAME, selectedDriver.getName());
                intent.putExtra(ReservationDetailsActivity.EXTRA_DRIVER_PhoneNumber, selectedDriver.getPhoneNumber());
                startActivity(intent);

            }
        });

    }
    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("1"); // 以 "1" 开头，符合一些国家的手机号码规定

        for (int i = 0; i < 10; i++) { // 生成剩余的10个数字
            int digit = random.nextInt(10);
            phoneNumber.append(digit);
        }

        return phoneNumber.toString();
    }
}
