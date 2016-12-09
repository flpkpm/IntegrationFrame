package com.epaylinks.myfirstframe.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/12/8.
 */

public class MyListViewDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTR =new int[]{
            android.R.attr.listDivider
    };
    private static final int VERTIVAL_DECORATION= LinearLayoutManager.VERTICAL;
    private static final int HORIZONTAL_DECORATION= LinearLayoutManager.HORIZONTAL;
    private int oritation;
    private Drawable mDrawable;
    private static final String TAG = "MyRecyclerViewListViewD";

    public MyListViewDecoration(Context context , int oritation) {
        final TypedArray arr=context.obtainStyledAttributes(ATTR);
        mDrawable=arr.getDrawable(0);
        Log.i(TAG, "MyRecyclerViewListViewDecoration: "+mDrawable);
        arr.recycle();
        setOritation(oritation);
    }

    private void setOritation(int oritation){
        if(oritation==VERTIVAL_DECORATION||oritation==HORIZONTAL_DECORATION){
            this.oritation=oritation;
        }else{
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);//默认调用onDraw(c,parent);
        if(oritation==VERTIVAL_DECORATION){
            drawVertical(c, parent);
        }else {
            drawHrizontal(c, parent);
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent) {//容器就是padding  view便是margin
        final int left=parent.getPaddingLeft();
        final int right=parent.getWidth()-parent.getPaddingRight();
       int count= parent.getChildCount();
        for (int i = 0; i <count; i++) {//为每个view画线
           View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int top=child.getBottom()+params.bottomMargin;
            int bottom=top+mDrawable.getIntrinsicHeight();
            mDrawable.setBounds(left,top,right,bottom);
            mDrawable.draw(c);

        }
    }

    private void drawHrizontal(Canvas c, RecyclerView parent) {//容器就是padding  view便是margin
        final int top=parent.getPaddingTop();
        final int bottom=parent.getHeight()-parent.getPaddingBottom();
        int count= parent.getChildCount();
        for (int i = 0; i <count; i++) {//为每个view画线
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int left=child.getRight()+params.rightMargin;
            int right=left+mDrawable.getIntrinsicHeight();
            mDrawable.setBounds(left,top,right,bottom);
            mDrawable.draw(c);

        }
    }
}
