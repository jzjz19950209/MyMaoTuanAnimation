package com.qianfeng.maotuananimation.BaseInterface.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qianfeng.maotuananimation.BaseInterface.view.fragment.MengFragment;
import com.qianfeng.maotuananimation.R;

import java.util.ArrayList;
import java.util.List;

public class MengActivity extends AppCompatActivity {

    private RadioGroup rg;
    private List<Fragment> list;
    private Fragment fragment;
    private Fragment currentFragment;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meng);
        Intent intent = getIntent();
        String word = intent.getStringExtra("word");
        init(word);


    }

    private void init(String word) {
        tv = ((TextView) findViewById(R.id.meng_title));
        tv.setText(word);
        rg = ((RadioGroup) findViewById(R.id.meng_rgg));
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.meng_rb1:
                        fragment=list.get(0);
                        break;
                    case R.id.meng_rb2:
                        fragment=list.get(1);
                        break;
                }
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                if(fragment.isAdded())
                {
                    transaction.hide(currentFragment).show(fragment).commit();
                }
                else {
                    transaction.hide(currentFragment).add(R.id.meng_ll,fragment).commit();
                }

                currentFragment=fragment;
            }
        });
        list=new ArrayList<>();
        MengFragment hot = MengFragment.getInstance(word, "hot");
        MengFragment aNew = MengFragment.getInstance(word, "new");
        list.add(aNew);
        list.add(hot);
        fragment=aNew;
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.meng_ll,aNew).commit();
        currentFragment=fragment;

    }
}
