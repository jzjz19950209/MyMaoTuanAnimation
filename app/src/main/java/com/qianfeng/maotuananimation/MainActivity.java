package com.qianfeng.maotuananimation;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.maotuananimation.BaseInterface.view.fragment.TuanFragment;
import com.qianfeng.maotuananimation.Content.view.Fragment.ContentFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout line1, line2, line3, line4;
    private ImageView image1, image2, image3, image4;
    private TextView text1, text2, text3, text4;
    private Fragment currentFragment;
    private List<Fragment> fragmentList;
    private Fragment fragment;
    private int exit=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getSupportFragmentManager().beginTransaction().add(R.id.content_fragment, fragmentList.get(0)).commit();
    }
    private void initView() {
        line1 = (LinearLayout) findViewById(R.id.line1);
        line2 = (LinearLayout) findViewById(R.id.line2);
        line3 = (LinearLayout) findViewById(R.id.line3);
        line4 = (LinearLayout) findViewById(R.id.line4);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        initBottomView();
        line1.setOnClickListener(this);
        line2.setOnClickListener(this);
        line3.setOnClickListener(this);
        line4.setOnClickListener(this);
        fragmentList=new ArrayList<>();
        fragmentList.add(new ContentFragment());
        fragmentList.add(new TuanFragment());
        fragmentList.add(new Fragment());
        fragmentList.add(new Fragment());
        currentFragment=fragmentList.get(0);
    }

    @Override
    public void onClick(View v) {
        initBottomView();
        switch (v.getId()) {
            case R.id.line1:
                image1.setImageDrawable(getResources().getDrawable(R.drawable.anime_on));
                text1.setTextColor(getResources().getColor(R.color.colorWhite));
                fragment =fragmentList.get(0);
                break;
            case R.id.line2:
                image2.setImageDrawable(getResources().getDrawable(R.drawable.groups_on));
                text2.setTextColor(getResources().getColor(R.color.colorWhite));
                fragment =fragmentList.get(1);
                break;
            case R.id.line3:
                image3.setImageDrawable(getResources().getDrawable(R.drawable.sign_display_on));
                text3.setTextColor(getResources().getColor(R.color.colorWhite));
                fragment =fragmentList.get(2);
                break;
            case R.id.line4:
                fragment = fragmentList.get(3);
                image4.setImageDrawable(getResources().getDrawable(R.drawable.image_icon_fan));
                text4.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()) {
            transaction.hide(currentFragment).show(fragment).commit();
        } else {
            transaction.hide(currentFragment).add(R.id.content_fragment, fragment).commit();
        }
        currentFragment = fragment;
    }

    private void initBottomView() {
        text1.setTextColor(getResources().getColor(R.color.colorTextNormal));
        text2.setTextColor(getResources().getColor(R.color.colorTextNormal));
        text3.setTextColor(getResources().getColor(R.color.colorTextNormal));
        text4.setTextColor(getResources().getColor(R.color.colorTextNormal));
        image1.setImageDrawable(getResources().getDrawable(R.drawable.anime_off));
        image2.setImageDrawable(getResources().getDrawable(R.drawable.groups_off));
        image3.setImageDrawable(getResources().getDrawable(R.drawable.sign_display_off));
        image4.setImageDrawable(getResources().getDrawable(R.drawable.image_icon_attention));
    }

    @Override
    public void onBackPressed() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                exit=0;
            }
        }).start();
        exit++;
        if (exit==2){
            super.onBackPressed();
        }
        Toast.makeText(this, "再按一次退出应用！", Toast.LENGTH_SHORT).show();

    }
}
