package com.qianfeng.maotuananimation.VideoDetails.modle.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.qianfeng.maotuananimation.R;

public class WebVideoPlayActivity extends AppCompatActivity {

    private WebView webView;
    private TextView web_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_video_play);
        webView = ((WebView) findViewById(R.id.play_webview));
        web_title = ((TextView) findViewById(R.id.webview_title));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        Bundle extras = getIntent().getExtras();
        String url = extras.getString("videoUrl");
        Log.d("zhenjie", "onCreate: "+url);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
                return true;
            }

            //开始加载网页时回调
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            //网页加载结束时回调
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            //获取网页标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                web_title.setText(title);
            }

        });
    }
    @Override
    public void onBackPressed() {
        //如果网页可以后退，则网页后退
        if (webView.canGoBack()) {
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }

    public void back_btn3(View view) {
        this.finish();
    }
}
