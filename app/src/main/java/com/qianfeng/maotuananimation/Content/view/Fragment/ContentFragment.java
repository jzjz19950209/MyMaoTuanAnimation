package com.qianfeng.maotuananimation.Content.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.Content.view.Adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qf on 2016/11/8.
 */

public class ContentFragment extends Fragment {
    private View view;
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private List<Fragment> fragments=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view!=null){
            return view;
        }
        view=inflater.inflate(R.layout.content_fragment,container,false);
        initView(view);
        return view;
    }
    private void initView(View view){
        radioGroup= (RadioGroup) view.findViewById(R.id.radioGroup);
        viewPager= (ViewPager) view.findViewById(R.id.viewPager);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.recommend:
                        viewPager.setCurrentItem(0);
                        ((RadioButton) radioGroup.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorWhite));
                        ((RadioButton) radioGroup.getChildAt(1)).setTextColor(getResources().getColor(R.color.colorSortBtn));
                        break;
                    case R.id.sort:
                        viewPager.setCurrentItem(1);
                        ((RadioButton) radioGroup.getChildAt(1)).setTextColor(getResources().getColor(R.color.colorWhite));
                        ((RadioButton) radioGroup.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorSortBtn));
                        break;
                }
            }
        });
        viewPager.setCurrentItem(0);
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) radioGroup.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        fragments.add(new RecommendFragment());
        fragments.add(new Fragment());
        viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(),fragments));
    }
}
