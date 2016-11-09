package com.qianfeng.maotuananimation.BaseInterface.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qianfeng.maotuananimation.R;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class MengFragment extends Fragment{
    private View view;
    private ListView lv;

   

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view=inflater.inflate(R.layout.mengfragment,container,false);
            init(view);
        }
        return view;
    }

    private void init(View view) {
        lv = ((ListView) view.findViewById(R.id.meng_lv));
    }
}
