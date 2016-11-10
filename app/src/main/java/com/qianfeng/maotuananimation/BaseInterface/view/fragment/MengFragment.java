package com.qianfeng.maotuananimation.BaseInterface.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;
import com.qianfeng.maotuananimation.BaseInterface.presenter.MengPresenter;
import com.qianfeng.maotuananimation.BaseInterface.view.adapter.TuiLvAdapter;
import com.qianfeng.maotuananimation.R;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class MengFragment extends Fragment implements IMengView{
    private View view;
    private ListView lv;
    private MengPresenter presenter;


    public static MengFragment getInstance(String word,String order)
   {
       MengFragment mengFragment=new MengFragment();
       Bundle bundle=new Bundle();
       bundle.putString("word",word);
       bundle.putString("order",order);

       mengFragment.setArguments(bundle);
       return mengFragment;
   }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view=inflater.inflate(R.layout.mengfragment,container,false);
            init(view);
            Bundle bundle=getArguments();
            String word = bundle.getString("word");
            String order = bundle.getString("order");
            presenter=new MengPresenter(this);
            presenter.start(word,order);
        }
        return view;
    }

    private void init(View view) {
        lv = ((ListView) view.findViewById(R.id.meng_lv));

    }

    @Override
    public void upDateMeng(FaceBean bean) {
        TuiLvAdapter adapter=new TuiLvAdapter(bean.getList(),getActivity());
        lv.setAdapter(adapter);
    }
}
