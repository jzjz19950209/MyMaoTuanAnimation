package com.qianfeng.maotuananimation.BaseInterface.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.ZuBean;
import com.qianfeng.maotuananimation.BaseInterface.presenter.ZuPresenter;
import com.qianfeng.maotuananimation.R;
import com.qianfeng.mylibrary.MyListView;
import com.squareup.picasso.Picasso;

public class ZuActivity extends AppCompatActivity implements IZuView{

    private MyListView lv;
    private ImageView iv;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    private ImageView item_iv;
    private TextView item_tv1,item_tv2,item_tv3;
    private ZuPresenter presenter;
    private ImageView toiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zu);
        init();
        String id = getIntent().getStringExtra("id");
        presenter=new ZuPresenter(this);
        presenter.start(id);
    }

    private void init() {
        lv = ((MyListView) findViewById(R.id.zu_lv));
        lv.setFocusable(false);
        toiv = ((ImageView) findViewById(R.id.zu_ivtotal));
        iv = ((ImageView) findViewById(R.id.zu_iv));
        tv1 = ((TextView) findViewById(R.id.zu_tv1));
        tv2 = ((TextView) findViewById(R.id.zu_tv2));
        tv3 = ((TextView) findViewById(R.id.zu_tv3));
        tv4 = ((TextView) findViewById(R.id.zu_tv4));
        tv5 = ((TextView) findViewById(R.id.zu_tv5));
        tv6 = ((TextView) findViewById(R.id.zu_tv6));
        tv7= ((TextView) findViewById(R.id.zu_tv7));
        tv8= ((TextView) findViewById(R.id.zu_tv8));
        item_iv = ((ImageView) findViewById(R.id.zu_item_iv));
        item_tv1 = ((TextView) findViewById(R.id.zu_item_tv1));
        item_tv2 = ((TextView) findViewById(R.id.zu_item_tv2));
        item_tv3 = ((TextView) findViewById(R.id.zu_item_tv3));
    }

    @Override
    public void updateZu(ZuBean bean) {
        Picasso.with(this).load(bean.getPic()).into(toiv);
        Picasso.with(this).load(bean.getIcon()).into(iv);
        tv1.setText(bean.getName());
        tv2.setText(bean.getLevel());
        tv3.setText(bean.getCur_num());
        tv4.setText(bean.getTotal());
        tv5.setText(bean.getDistance());
        tv6.setText(bean.getCity());
        tv7.setText(bean.getDesc());
        tv8.setText(bean.getId());
        Picasso.with(this).load(bean.getOwner().getHead_pic()).into(item_iv);
        item_tv1.setText(bean.getOwner().getUser_level_group_tip());
        item_tv2.setText(bean.getOwner().getNickname());
        item_tv3.setText(bean.getOwner().getSign());
        ZuLvAdapter adapter=new ZuLvAdapter(bean.getMember(),this);
        lv.setAdapter(adapter);
    }
}
