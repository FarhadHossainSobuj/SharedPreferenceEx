package com.example.sharedpreferenceex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button log_out;
    private static final String SHARED_PRE = "login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log_out=findViewById(R.id.log_out);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PRE,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                sharedPreferences.edit().clear().commit();

                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }
}
