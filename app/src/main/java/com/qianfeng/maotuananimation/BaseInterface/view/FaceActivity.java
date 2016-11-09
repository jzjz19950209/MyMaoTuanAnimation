package com.qianfeng.maotuananimation.BaseInterface.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;
import com.qianfeng.maotuananimation.BaseInterface.presenter.FacePresenter;
import com.qianfeng.maotuananimation.BaseInterface.view.adapter.FaceLvAdapter;
import com.qianfeng.maotuananimation.R;

public class FaceActivity extends AppCompatActivity implements IFaceView{

    private FacePresenter presenter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);
        init();
        String x = getIntent().getStringExtra("x");
        String y=getIntent().getStringExtra("y");
        presenter=new FacePresenter(this);
        presenter.start(x,y);
    }

    private void init() {
        lv = ((ListView) findViewById(R.id.face_lv));
    }

    @Override
    public void upDateFace(FaceBean bean) {
        FaceLvAdapter adapter=new FaceLvAdapter(bean.getList(),this);
        lv.setAdapter(adapter);
    }
}
