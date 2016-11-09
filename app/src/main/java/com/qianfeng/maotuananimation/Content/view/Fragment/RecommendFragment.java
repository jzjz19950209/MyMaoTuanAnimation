package com.qianfeng.maotuananimation.Content.view.Fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qianfeng.maotuananimation.Content.model.bean.Rec_contentBean;
import com.qianfeng.maotuananimation.Content.model.bean.ScollBean;
import com.qianfeng.maotuananimation.Content.model.bean.T_Bean;
import com.qianfeng.maotuananimation.Content.presenter.RecommendPresenter;
import com.qianfeng.maotuananimation.Content.view.Adapter.MyViewPagerAdapter;
import com.qianfeng.maotuananimation.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qf on 2016/11/8.
 */

public class RecommendFragment extends Fragment implements IRecommendView{
    private View view;
    private ViewPager head_viewPager;
    private List<ImageView> imageViews=new ArrayList<>();
    private LinearLayout doLayout,linearLayout_spot;
    private int prePosition=0;
    private boolean isRunning=true;
    private int viewPager_length;
    private RecommendPresenter rp=new RecommendPresenter(this);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view!=null){
           return view;
        }
        rp.upDateData();
        view = inflater.inflate(R.layout.recommend_fragment,container,false);
        initView(view);
        return view;
    }

    private void initView(final View view) {
        head_viewPager= (ViewPager) view.findViewById(R.id.head_viewPager);
        doLayout= (LinearLayout) view.findViewById(R.id.linearLayout);
        linearLayout_spot= (LinearLayout) view.findViewById(R.id.linearLayout_spot);
        initData();
        Log.d("jzjz", "initView: ");
        head_viewPager.setAdapter(new MyViewPagerAdapter(imageViews,4));
        head_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                doLayout.getChildAt(prePosition).setEnabled(false);
                doLayout.getChildAt(position%4).setEnabled(true);
                prePosition=position%4;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        head_viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - 3);
        autoupdateViewPager();
        drawSpot();

    }
    private void initData(){
        for (int i=0;i<4;i++) {
//            ImageView imageView=new ImageView(getContext());
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setImageResource(R.drawable.item_default);
//            imageViews.add(imageView);
            View view=new View(getContext());
            LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics())),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
            lp.leftMargin=20;
            view.setLayoutParams(lp);
            view.setEnabled(false);
            view.setBackgroundResource(R.drawable.spot);
            doLayout.addView(view);
        }
        doLayout.getChildAt(0).setEnabled(true);
    }
    //自动更新ViewPager
    private void autoupdateViewPager(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning){
                    SystemClock.sleep(5000);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            head_viewPager.setCurrentItem(head_viewPager.getCurrentItem()+1);
                        }
                    });
                }
            }
        }).start();
    }
    private void drawSpot(){
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7, getResources().getDisplayMetrics())), ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7, getResources().getDisplayMetrics())));
        for (int i=0;i<20;i++){
            View view=new View(getContext());
            lp.leftMargin=20;
            view.setEnabled(false);
            view.setLayoutParams(lp);
            view.setBackgroundResource(R.drawable.spot_normal);
            linearLayout_spot.addView(view);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning=false;
    }

    @Override
    public void initScoll(List<ScollBean> list) {
        viewPager_length=list.size();
        for (int i = 0; i < viewPager_length; i++) {
            ImageView imageView=new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(getContext()).load(list.get(i).getPic()).into(imageView);
            imageViews.add(imageView);
        }

    }

    @Override
    public void initDayVideo(List<T_Bean> list) {

    }

    @Override
    public void initHotVideo(List<T_Bean> list) {

    }

    @Override
    public void initCoser(List<T_Bean> list) {

    }

    @Override
    public void initGameCarousel(List<T_Bean> list) {

    }

    @Override
    public void initGameFourList(List<T_Bean> list) {

    }

    @Override
    public void initRec_content(List<Rec_contentBean> list) {

    }
}
