package com.qianfeng.maotuananimation.BaseInterface.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;
import com.qianfeng.maotuananimation.BaseInterface.presenter.FacePresenter;
import com.qianfeng.maotuananimation.BaseInterface.view.adapter.TuiLvAdapter;
import com.qianfeng.maotuananimation.R;

public class TuiActivity extends AppCompatActivity implements IFaceView{

    private TextView tv_title;
    private ListView lv;
    private FacePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tui);
        String title = getIntent().getStringExtra("title");
        String id = getIntent().getStringExtra("id");
        init();
        tv_title.setText(title);
        presenter=new FacePresenter(this);
        presenter.start(id);
    }

    private void init() {
        tv_title = ((TextView) findViewById(R.id.tui_title));
        lv = ((ListView) findViewById(R.id.tui_lv));
    }

    @Override
    public void upDateFace(FaceBean bean) {
        TuiLvAdapter adapter=new TuiLvAdapter(bean.getList(),this);
        lv.setAdapter(adapter);
    }
}
