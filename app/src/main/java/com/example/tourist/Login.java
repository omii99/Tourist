package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Login extends AppCompatActivity {
    ImageView bgapp, clover;
    LinearLayout textsplash, texthome;
    ConstraintLayout menus;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        bgapp = findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover);
        menus = findViewById(R.id.menus);
        textsplash = findViewById(R.id.textsplash);
        texthome = findViewById(R.id.texthome);
        bgapp.animate().translationY(-1900).setDuration(1200).setStartDelay(800);
        clover.animate().alpha(0).setDuration(1500).setStartDelay(1000);
        textsplash.animate().translationY(140).alpha(0).setDuration(1000).setStartDelay(1000);
        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);
    }
    public void Movesignup(View view)
    {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void Movedashboard(View view)
    {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}
