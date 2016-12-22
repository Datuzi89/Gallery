package com.example.xuezhu.gallery;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Gallery extends AppCompatActivity implements View.OnClickListener {

    List<String> listSource = new ArrayList<>();
    ViewPager pager;
    Button btnPre, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.DarkTheme);
        setContentView(R.layout.activity_gallery);

        loadImageSource();

        pager = (ViewPager)findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, listSource);
        pager.setAdapter(adapter);

        btnPre = (Button)findViewById(R.id.btnPre);
        btnNext = (Button)findViewById(R.id.btnNext);

        btnPre.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    private void loadImageSource() {
        for (int i = 1; i <= 19; i++) {
            String str = String.format("i%d", i);
            listSource.add(str);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPre) {
            if (pager.getCurrentItem() == 0)
                pager.setCurrentItem(listSource.size(), true);
            else
                pager.setCurrentItem(getItem(-1), true);
        }
        else if (v.getId() == R.id.btnNext) {
            if (pager.getCurrentItem() == listSource.size() - 1)
                pager.setCurrentItem(0, true);
            else
                pager.setCurrentItem(getItem(1), true);
        }
    }

    private int getItem(int i) {
        return pager.getCurrentItem() + i;
    }
}
