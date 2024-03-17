package com.example.wss2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.net.Inet4Address;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class Onboarding extends AppCompatActivity {
    //Класс-контейнер для фрагментов
    //17.03.2024
    //Нуркаев А.Х
    List<OnboardingFragment> fragments;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.onboarding);
        vp = (ViewPager) findViewById(R.id.onboarding_vp);
        fillList();
        Adapter adapter = new Adapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.onboarding_rl);
        LinearLayout ll = (LinearLayout) findViewById(R.id.onboarding_ll);
        //Прослушивание переключения страниц
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Если страница 3 - показываем кнопку sign up и текст, иначе показываем кнопки skip и next
                if (position == fragments.size() - 1) {
                    rl.setVisibility(View.GONE);
                    ll.setVisibility(View.VISIBLE);
                } else {
                    rl.setVisibility(View.VISIBLE);
                    ll.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //Заполнения list'a
    public void fillList() {
        fragments = new ArrayList<>();
        fragments.add(new OnboardingFragment(0, "Quick Delivery At Your Doorstep", "Enjoy quick pick-up and delivery to your destination", R.drawable.on_img1));
        fragments.add(new OnboardingFragment(1, "Flexible Payment", "Different modes of payment either before and after delivery without stress", R.drawable.on_img2));
        fragments.add(new OnboardingFragment(2, "Real-time Tracking", "Track your packages/items from the comfort of your home till final destination", R.drawable.on_img3));
    }

    //Класс-адаптер для ViewPager
    class Adapter extends FragmentPagerAdapter {

        public Adapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    public void skip(View view) {
        Intent i = new Intent(this, Holder.class);
        startActivity(i);
        finish();
        writeFirst();
    }

    public void next(View view) {
        vp.setCurrentItem(vp.getCurrentItem() + 1);
    }

    public void sign_up(View view) {
        Intent i = new Intent(Onboarding.this, Holder.class);
        startActivity(i);
        finish();
    }

    public void sign_in(View view) {
        Intent i = new Intent(Onboarding.this, Holder.class);
        startActivity(i);
        finish();
    }

    //Запись в локальную память информацию о том, что уже нажимали на кнопку skip
    public void writeFirst() {
        SharedPreferences sp = getSharedPreferences("users", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isFirst", true);
        editor.apply();
    }
}
