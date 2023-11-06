package com.example.test_captcha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> correctOrder = Arrays.asList(1, 2, 3);
    private List<Integer> selectedOrder = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleImageClick(1);
                v.setVisibility(View.INVISIBLE);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleImageClick(2);
                v.setVisibility(View.INVISIBLE);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleImageClick(3);
                v.setVisibility(View.INVISIBLE);
            }
        });

        Button submitButton = findViewById(R.id.btn_click);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOrder.equals(correctOrder)) {
                    Intent intent = new Intent(MainActivity.this, NewPageActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void handleImageClick(int order) {
        selectedOrder.add(order);
    }
}
