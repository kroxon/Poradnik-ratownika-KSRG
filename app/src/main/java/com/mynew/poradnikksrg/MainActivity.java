package com.mynew.poradnikksrg;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.mynew.poradnikksrg.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;
    FragmentAdapt adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String pos = intent.getStringExtra("POSITION");
        int posiotonGet = Integer.parseInt(pos);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        if (posiotonGet == 1) {
            adapter2 = new FragmentAdapt(fm, getLifecycle());
            viewPager2.setAdapter(adapter2);
//            tabLayout.addTab(tabLayout.newTab().setText("Kwalifikowana Pierwsza Pomoc"));
//            tabLayout.addTab(tabLayout.newTab().setText("Substancje niebezpieczne"));
        } else {
            adapter = new FragmentAdapter(fm, getLifecycle());
            viewPager2.setAdapter(adapter);
//            tabLayout.addTab(tabLayout.newTab().setText("Substancje niebezpieczne"));
//            tabLayout.addTab(tabLayout.newTab().setText("Kwalifikowana Pierwsza Pomoc"));
        }


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}