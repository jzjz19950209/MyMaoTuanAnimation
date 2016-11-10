package com.qianfeng.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class MyFlexBox extends ViewGroup{
    private List<List<View>> allViews=new ArrayList<>();
    private List<Integer> lineMaxHeight=new ArrayList<>();


    public MyFlexBox(Context context) {
        this(context,null);
    }

    public MyFlexBox(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyFlexBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        allViews.clear();
        lineMaxHeight.clear();
        List<View> views=new ArrayList<>();
        int childCount = getChildCount();
        int totalWidth=0;
        int perLineMaxHeight=0;
        //int widthSize=getMeasuredWidth();
        for (int i = 0; i < childCount; i++) {
            View v=getChildAt(i);
            MarginLayoutParams lp= (MarginLayoutParams) v.getLayoutParams();
            int childWidth=v.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
            int childHeigth=v.getMeasuredHeight()+lp.bottomMargin+lp.topMargin;
            if(totalWidth+childWidth>getMeasuredWidth())
            {
                allViews.add(views);
                lineMaxHeight.add(perLineMaxHeight);
                views=new ArrayList<>();
                totalWidth=0;
                perLineMaxHeight=0;
            }

            totalWidth+=childWidth;
            perLineMaxHeight=Math.max(perLineMaxHeight,childHeigth);
            views.add(v);
        }
        allViews.add(views);
        lineMaxHeight.add(perLineMaxHeight);


        int mLeft=0;
        int mTop=0;
        for (int i = 0; i <allViews.size() ; i++) {
            List<View> lineviews=allViews.get(i);
            for (int j = 0; j <lineviews.size() ; j++) {
                View view=lineviews.get(j);
                MarginLayoutParams lp= (MarginLayoutParams) view.getLayoutParams();
                int left=mLeft+lp.leftMargin;
                int right=left+view.getMeasuredWidth();
                int top=mTop+lp.topMargin;
                int bottom=top+view.getMeasuredHeight();
                view.layout(left,top,right,bottom);
                mLeft+=view.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
            }
            mLeft=0;
            mTop+=lineMaxHeight.get(i);
        }
    }




    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(MarginLayoutParams.MATCH_PARENT,MarginLayoutParams.MATCH_PARENT);

    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        int widthmode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int childCount = getChildCount();
        int totalWidth=0;
        int totalHeight=0;
        int perlineMax=0;
        for (int i = 0; i <childCount ; i++) {
            View v=getChildAt(i);
            measureChild(v,widthMeasureSpec,heightMeasureSpec);
            MarginLayoutParams lp= (MarginLayoutParams) v.getLayoutParams();
            int childWidth=lp.leftMargin+v.getMeasuredWidth()+lp.rightMargin;
            int childHeight=lp.topMargin+v.getMeasuredHeight()+lp.bottomMargin;
            if (totalWidth+childWidth>widthSize)
            {
                totalWidth=childWidth;
                totalHeight+=perlineMax;
                perlineMax=childHeight;
            }
            else {
                totalWidth+=childWidth;
                perlineMax=Math.max(perlineMax,childHeight);
            }
            if(i==childCount-1)
            {
                totalHeight+=perlineMax;
            }
        }
        heightSize=heightmode==MeasureSpec.EXACTLY?heightSize:totalHeight;
        setMeasuredDimension(widthSize,heightSize);

    }
}
