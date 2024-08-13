package com.example.dogroulettegame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Main_game extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);

        ImageButton open1 = findViewById(R.id.open1);
        ImageButton open2 = findViewById(R.id.open2);
        ImageButton open3 = findViewById(R.id.open3);
        ImageButton open4 = findViewById(R.id.open4);
        ImageButton open5 = findViewById(R.id.open5);
        ImageButton open6 = findViewById(R.id.open6);
        ImageButton open7 = findViewById(R.id.open7);

        ImageView close1 = findViewById(R.id.close1);
        ImageView close2 = findViewById(R.id.close2);
        ImageView close3 = findViewById(R.id.close3);
        ImageView close4 = findViewById(R.id.close4);
        ImageView close5 = findViewById(R.id.close5);
        ImageView close6 = findViewById(R.id.close6);
        ImageView close7 = findViewById(R.id.close7);

        // 랜덤 숫자 생성 (1부터 7까지)
        Random random = new Random();
        final int randomNumber = random.nextInt(7) + 1;

        // 각 버튼에 클릭 리스너를 설정
        open1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(1, randomNumber, open1, close1);
            }
        });

        open2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(2, randomNumber, open2, close2);
            }
        });

        open3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(3, randomNumber, open3, close3);
            }
        });

        open4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(4, randomNumber, open4, close4);
            }
        });

        open5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(5, randomNumber, open5, close5);
            }
        });

        open6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(6, randomNumber, open6, close6);
            }
        });

        open7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(7, randomNumber, open7, close7);
            }
        });
    }

    // 버튼이 클릭되었을 때 호출되는 메서드
    private void handleButtonClick(int buttonNumber, int randomNumber, ImageButton openButton, ImageView closeImage) {
        // 클릭된 버튼과 연관된 이미지뷰를 보여주고 버튼을 숨김
        closeImage.setVisibility(View.VISIBLE);
        openButton.setVisibility(View.INVISIBLE);

        // 버튼 번호가 랜덤으로 생성된 숫자와 일치하는지 확인
        if (buttonNumber == randomNumber) {
            // 맞다면 Selected.class로 이동
            Intent intent = new Intent(getApplicationContext(), Selected.class);
            startActivity(intent);
        }
    }
}
