package com.example.dogroulettegame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(getApplicationContext(), Main_game.class);
                    startActivity(intent);
                }
            });
            return insets;
        });
        startService(new Intent(getApplicationContext(), MusicService.class));

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        stopService(new Intent(getApplicationContext(), MusicService.class));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        startService(new Intent(getApplicationContext(), MusicService.class));
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        stopService(new Intent(getApplicationContext(), MusicService.class));
    }

}