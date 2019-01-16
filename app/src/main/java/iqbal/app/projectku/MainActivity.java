package iqbal.app.projectku;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imgBtnFutsal = (ImageButton) findViewById(R.id.img_btn_futsal);
        ImageButton imgBtnBadminton = (ImageButton) findViewById(R.id.img_btn_bultang);
        ImageButton imgBtnAbout = (ImageButton) findViewById(R.id.img_btn_about_apps);
        ImageButton imgBtnProfile = (ImageButton) findViewById(R.id.img_btn_profile);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);

        imgBtnFutsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent futsal = new Intent(MainActivity.this, FutsalActivity.class);
                startActivity(futsal);
            }
        });

        imgBtnBadminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bultang = new Intent(MainActivity.this, BadmintonActivity.class);
                startActivity(bultang);
            }
        });

        imgBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profile);
            }
        });

        imgBtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about);
            }
        });
    }
}
