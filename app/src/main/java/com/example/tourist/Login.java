package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void Movesignup(View view)
    {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
    public void Movedashboard(View view)
    {
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
}
