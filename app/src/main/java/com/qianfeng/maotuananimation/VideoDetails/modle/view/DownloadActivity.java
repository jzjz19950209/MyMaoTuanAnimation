package com.qianfeng.maotuananimation.VideoDetails.modle.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;
import com.qianfeng.maotuananimation.R;

import java.util.ArrayList;
import java.util.List;

public class DownloadActivity extends AppCompatActivity {

    private FlexboxLayout flexboxLayout;
    private List<String> num_list;
    private boolean isSelect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        flexboxLayout = ((FlexboxLayout) findViewById(R.id.download_flebox));
        Bundle bundle = getIntent().getExtras();
        String total_num = bundle.getString("total_num");
        initList(Integer.parseInt(total_num));
        for (String s : num_list) {
            initBtn(s);
        }
    }

    private void initBtn(final String s) {
        final Button button = new Button(this);
        button.setText(s);
        button.setBackgroundResource(R.drawable.textview_bg);
        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(14, 8, 14, 8);
        button.setLayoutParams(lp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSelect) {
                    button.setBackgroundResource(R.drawable.btn_bg);
                    Toast.makeText(DownloadActivity.this, s, Toast.LENGTH_SHORT).show();
                    isSelect = true;
                } else {
                    button.setBackgroundResource(R.drawable.textview_bg);
                    isSelect=false;
                }
            }
        });
        flexboxLayout.addView(button);
        ViewGroup.LayoutParams params = button.getLayoutParams();
        params.width = 150;
        params.height = 120;
        button.setLayoutParams(params);
    }

    private void initList(int i) {
        num_list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            num_list.add(j + 1 + "");
        }
    }

    public void back_btn4(View view) {
        this.finish();
    }
}
