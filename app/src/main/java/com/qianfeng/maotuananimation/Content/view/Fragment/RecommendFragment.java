package com.qianfeng.maotuananimation.Content.view.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    public  boolean isRunning=true;
    private ImageView hotImage1,hotImage2,hotImage3,hotImage4,hotImage5,hotImage6,hotImage7,hotImage8;
    private TextView hotText1, hotText2, hotText3, hotText4, hotText5, hotText6, hotText7, hotText8;
    private ImageView recommendImage1,recommendImage2,recommendImage3,recommendImage4,recommendImage5,recommendImage6;
    private TextView recommendText1,recommendText2,recommendText3,recommendText4,recommendText5,recommendText6;
    private ImageView gameImg1,gameImg2,gameImg3,gameImg4;
    private TextView gameText1,gameText2,gameText3,gameText4;
    private ImageView coserImg1,coserImg2,coserImg3,coserImg4;
    private TextView coserText1,coserText2,coserText3,coserText4;

    private RecommendPresenter rp=new RecommendPresenter(this);
    private MyViewPagerAdapter adapter;
    private ArrayAdapter<ImageView> imageViewArrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view!=null){
           return view;
        }
        view = inflater.inflate(R.layout.recommend_fragment,container,false);
        initView(view);
        initData();
        adapter = new MyViewPagerAdapter(getContext(),imageViews,4);
        head_viewPager.setAdapter(adapter);
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
        head_viewPager.setCurrentItem(Integer.MAX_VALUE / 2-4);
        autoupdateViewPager();
        drawSpot();
        rp.upDateData();




        return view;
    }

    private void initView(View view) {
        head_viewPager= (ViewPager) view.findViewById(R.id.head_viewPager);
        doLayout= (LinearLayout) view.findViewById(R.id.linearLayout);
        linearLayout_spot= (LinearLayout) view.findViewById(R.id.linearLayout_spot);
        hotImage1= (ImageView) view.findViewById(R.id.hot_img1);
        hotImage2= (ImageView) view.findViewById(R.id.hot_img2);
        hotImage3= (ImageView) view.findViewById(R.id.hot_img3);
        hotImage4= (ImageView) view.findViewById(R.id.hot_img4);
        hotImage5= (ImageView) view.findViewById(R.id.hot_img5);
        hotImage6= (ImageView) view.findViewById(R.id.hot_img6);
        hotImage7= (ImageView) view.findViewById(R.id.hot_img7);
        hotImage8= (ImageView) view.findViewById(R.id.hot_img8);
        hotText1= (TextView) view.findViewById(R.id.hot_text1);
        hotText2= (TextView) view.findViewById(R.id.hot_text2);
        hotText3= (TextView) view.findViewById(R.id.hot_text3);
        hotText4= (TextView) view.findViewById(R.id.hot_text4);
        hotText5= (TextView) view.findViewById(R.id.hot_text5);
        hotText6= (TextView) view.findViewById(R.id.hot_text6);
        hotText7= (TextView) view.findViewById(R.id.hot_text7);
        hotText8= (TextView) view.findViewById(R.id.hot_text8);
        recommendImage1= (ImageView) view.findViewById(R.id.recommend_img1);
        recommendImage2= (ImageView) view.findViewById(R.id.recommend_img2);
        recommendImage3= (ImageView) view.findViewById(R.id.recommend_img3);
        recommendImage4= (ImageView) view.findViewById(R.id.recommend_img4);
        recommendImage5= (ImageView) view.findViewById(R.id.recommend_img5);
        recommendImage6= (ImageView) view.findViewById(R.id.recommend_img6);
        recommendText1= (TextView) view.findViewById(R.id.recommend_tv1);
        recommendText2= (TextView) view.findViewById(R.id.recommend_tv2);
        recommendText3= (TextView) view.findViewById(R.id.recommend_tv3);
        recommendText4= (TextView) view.findViewById(R.id.recommend_tv4);
        recommendText5= (TextView) view.findViewById(R.id.recommend_tv5);
        recommendText6= (TextView) view.findViewById(R.id.recommend_tv6);
        gameImg1= (ImageView) view.findViewById(R.id.game_img1);
        gameImg2= (ImageView) view.findViewById(R.id.game_img2);
        gameImg3= (ImageView) view.findViewById(R.id.game_img3);
        gameImg4= (ImageView) view.findViewById(R.id.game_img4);
        gameText1= (TextView) view.findViewById(R.id.game_tv1);
        gameText2= (TextView) view.findViewById(R.id.game_tv2);
        gameText3= (TextView) view.findViewById(R.id.game_tv3);
        gameText4= (TextView) view.findViewById(R.id.game_tv4);
        coserImg1= (ImageView) view.findViewById(R.id.coser_img1);
        coserImg2= (ImageView) view.findViewById(R.id.coser_img2);
        coserImg3= (ImageView) view.findViewById(R.id.coser_img3);
        coserImg4= (ImageView) view.findViewById(R.id.coser_img4);
        coserText1= (TextView) view.findViewById(R.id.coser_tv1);
        coserText2= (TextView) view.findViewById(R.id.coser_tv2);
        coserText3= (TextView) view.findViewById(R.id.coser_tv3);
        coserText4= (TextView) view.findViewById(R.id.coser_tv4);
    }
    private void initData(){
        for (int i=0;i<4;i++) {
            ImageView imageView=new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.drawable.item_default);
            imageViews.add(imageView);
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
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            head_viewPager.setCurrentItem(head_viewPager.getCurrentItem()+1);
                        }
                    });
                    SystemClock.sleep(3000);
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
        imageViews.clear();
        for (int i = 0; i < 4; i++) {
            ImageView imageView=new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(getContext()).load(list.get(i).getPic()).into(imageView);
            imageViews.add(imageView);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initDayVideo(List<T_Bean> list) {

    }

    @Override
    public void initHotVideo(List<T_Bean> list) {
        Context context=getContext();
        if (list!=null) {
            Picasso.with(context).load(list.get(0).getPic()).into(hotImage1);
            hotText1.setText(list.get(0).getName());
            Picasso.with(context).load(list.get(1).getPic()).into(hotImage2);
            hotText2.setText(list.get(1).getName());
            Picasso.with(context).load(list.get(2).getPic()).into(hotImage3);
            hotText3.setText(list.get(2).getName());
            Picasso.with(context).load(list.get(3).getPic()).into(hotImage4);
            hotText4.setText(list.get(3).getName());
            Picasso.with(context).load(list.get(4).getPic()).into(hotImage5);
            hotText5.setText(list.get(4).getName());
            Picasso.with(context).load(list.get(5).getPic()).into(hotImage6);
            hotText6.setText(list.get(5).getName());
            Picasso.with(context).load(list.get(6).getPic()).into(hotImage7);
            hotText7.setText(list.get(6).getName());
            Picasso.with(context).load(list.get(7).getPic()).into(hotImage8);
            hotText8.setText(list.get(7).getName());
        }
    }

    @Override
    public void initCoser(List<T_Bean> list) {
        Context context=getContext();
        if (list!=null){
            Picasso.with(context).load(list.get(0).getPic()).into(coserImg1);
            coserText1.setText(list.get(0).getName());
            Picasso.with(context).load(list.get(1).getPic()).into(coserImg2);
            coserText2.setText(list.get(1).getName());
            Picasso.with(context).load(list.get(2).getPic()).into(coserImg3);
            coserText3.setText(list.get(2).getName());
            Picasso.with(context).load(list.get(3).getPic()).into(coserImg4);
            coserText4.setText(list.get(3).getName());
        }
    }

    @Override
    public void initGameCarousel(List<T_Bean> list) {

    }

    @Override
    public void initGameFourList(List<T_Bean> list) {
        Context context=getContext();
        if (list!=null){
            Picasso.with(context).load(list.get(0).getPic()).into(gameImg1);
            gameText1.setText(list.get(0).getName());
            Picasso.with(context).load(list.get(1).getPic()).into(gameImg2);
            gameText2.setText(list.get(1).getName());
            Picasso.with(context).load(list.get(2).getPic()).into(gameImg3);
            gameText3.setText(list.get(2).getName());
            Picasso.with(context).load(list.get(3).getPic()).into(gameImg4);
            gameText4.setText(list.get(3).getName());
        }

    }

    @Override
    public void initRec_content(List<Rec_contentBean> list) {
        Context context=getContext();
        if (list!=null){
            Picasso.with(context).load(list.get(0).getPic()).into(recommendImage1);
            recommendText1.setText(list.get(0).getName());
            Picasso.with(context).load(list.get(1).getPic()).into(recommendImage2);
            recommendText2.setText(list.get(1).getName());
            Picasso.with(context).load(list.get(2).getPic()).into(recommendImage3);
            recommendText3.setText(list.get(2).getName());
            Picasso.with(context).load(list.get(3).getPic()).into(recommendImage4);
            recommendText4.setText(list.get(3).getName());
            Picasso.with(context).load(list.get(4).getPic()).into(recommendImage5);
            recommendText5.setText(list.get(4).getName());
            Picasso.with(context).load(list.get(5).getPic()).into(recommendImage6);
            recommendText6.setText(list.get(5).getName());
        }
    }
}
