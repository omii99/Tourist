package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class city extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
    }
    public void BackDashboard(View view)
    {
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
    public void Backcountry(View view)
    {
        Intent intent = new Intent(this, country.class);
        startActivity(intent);
    }
}
