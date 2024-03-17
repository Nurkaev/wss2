package com.example.wss2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Holder extends AppCompatActivity {
    //Класс-заглушка
    //17.03.2024
    //Нуркаев А.Х

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.holder);
    }
}
