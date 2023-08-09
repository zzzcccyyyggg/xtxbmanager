package com.example.manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class ReservationDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_DRIVER_NAME = "driver_name";
    public static final String EXTRA_DRIVER_PhoneNumber = "driver_phone_number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_details);

        TextView textViewReservationDetails = findViewById(R.id.textViewReservationDetails);
        TextView phone= findViewById(R.id.name);
        TextView name = findViewById(R.id.phoneNumber);

        // 获取从上一个 Activity 传递过来的车主名称
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_DRIVER_NAME)) {
            String driverName = intent.getStringExtra(EXTRA_DRIVER_NAME);
            String driverPhoneNumber = intent.getStringExtra(EXTRA_DRIVER_PhoneNumber);
            // 在这里生成并设置显示密文或多项式
            LinearLayout parentLayout = findViewById(R.id.parentLayout);
            textViewReservationDetails.setText("历史记录：");
            name.setText("姓名："+driverName);
            phone.setText("电话："+driverPhoneNumber);
            for (int i = 0; i < 10; i++) {
                String encryptedData = generateEncryptedData(driverName);
                // 创建 TextView 实例
                TextView textView = new TextView(this);
                textView.setText(encryptedData);


                // 添加 TextView 到父布局
                parentLayout.addView(textView);
            }
        }
    }

    // 在这里生成密文或多项式数据（示例）
    private String generateEncryptedData(String driverName) {
        StringBuilder polynomial = new StringBuilder();

        // 生成随机的多项式，以 x 为变量
        Random random = new Random();
        int degree = random.nextInt(5) + 3; // 随机生成多项式的次数，至少为3次
        for (int i = degree; i >= 0; i--) {
            int coefficient = random.nextInt(1000); // 随机生成系数
            polynomial.append(coefficient);
            if (i > 0) {
                polynomial.append("x^").append(i).append(" + ");
            }
        }

        return polynomial.toString();
    }

}
