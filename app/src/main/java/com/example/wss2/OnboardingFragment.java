package com.example.wss2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OnboardingFragment extends Fragment {
    //Класс-фрагмент для ViewPager
    //17.03.2024
    //Нуркаев А.Х
    int page;
    String text;
    String text2;
    int img;

    //Конструктор
    public OnboardingFragment(int page, String text, String text2, int img) {
        this.page = page;
        this.text = text;
        this.text2 = text2;
        this.img = img;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.onboarding_fragment, container, false);
        //Изменение данных для каждой страницы
        ImageView iv = (ImageView) view.findViewById(R.id.onb_fr_iv);
        iv.setImageResource(img);
        TextView tv1 = (TextView) view.findViewById(R.id.onb_fr_tv1);
        tv1.setText(text);
        TextView tv2 = (TextView) view.findViewById(R.id.onb_fr_tv2);
        tv2.setText(text2);
        return view;
    }
}
