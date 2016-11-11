package com.qianfeng.maotuananimation.VideoDetails.modle.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.VideoDetails.modle.CommentPresenter;
import com.qianfeng.maotuananimation.VideoDetails.modle.bean.CommentBean;
import com.qianfeng.maotuananimation.useractivity.view.UserActivity;

import java.util.List;

public class CommentActivity extends AppCompatActivity implements ICommentView{

    private CommentPresenter commentPresenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
        commentPresenter = new CommentPresenter(this);
        commentPresenter.start();
    }

    private void initView() {
        listView = ((ListView) findViewById(R.id.comment_lv));
    }

    @Override
    public void updataComment(final List<CommentBean> list) {
        CommentAdapter adapter=new CommentAdapter(list,this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CommentBean bean = list.get(i);
                Intent intent = new Intent(CommentActivity.this, UserActivity.class);
                intent.putExtra("uid", bean.getUserUid());
                intent.putExtra("name", bean.getUsername());
                startActivity(intent);
            }
        });
        listView.setAdapter(adapter);
    }

    public void back_btn2(View view) {
        this.finish();
    }
}
