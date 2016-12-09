package com.epaylinks.myfirstframe.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/12/8.
 */

public class MyGridViewDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTR =new int[]{
            android.R.attr.listDivider
    };
    private Drawable mDrawable;
    private static final String TAG = "MyGridViewDecoration";

    public MyGridViewDecoration(Context context ) {
        final TypedArray arr=context.obtainStyledAttributes(ATTR);
        mDrawable=arr.getDrawable(0);
        Log.i(TAG, "MyRecyclerViewListViewDecoration: "+mDrawable);
        arr.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);//默认调用onDraw(c,parent);
        drawVertical(c, parent);
        drawHrizontal(c, parent);
    }

    private int getSpanCount(RecyclerView parent){
        int spanCount=-1;
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        }else if(layoutManager instanceof StaggeredGridLayoutManager){
            spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return spanCount;
    }

    /**
     * 画竖线
     * @param c
     * @param parent
     */
    private void drawVertical(Canvas c, RecyclerView parent) {//容器就是padding  view便是margin
       int count= parent.getChildCount();
        for (int i = 0; i <count; i++) {//为每个view画线
           View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int left=child.getRight()+params.rightMargin;
            int right=left+mDrawable.getIntrinsicHeight();
            int top=child.getTop()-params.topMargin;
            int bottom=child.getBottom()+params.bottomMargin;//是不是会出去，拭目以待
            mDrawable.setBounds(left,top,right,bottom);
            mDrawable.draw(c);
        }
    }

    /**
     * 画横线
     * @param c
     * @param parent
     */
    private void drawHrizontal(Canvas c, RecyclerView parent) {//容器就是padding  view便是margin
        int count= parent.getChildCount();
        for (int i = 0; i <count; i++) {//为每个view画线
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int left=child.getLeft()-params.leftMargin;
            int right=child.getRight()+params.rightMargin+mDrawable.getIntrinsicHeight();//需要添加竖向分割线的宽度
            int top=child.getBottom()+params.bottomMargin;
            int bottom=top+mDrawable.getIntrinsicHeight();
            mDrawable.setBounds(left,top,right,bottom);
            mDrawable.draw(c);
        }
    }

    /**
     * 判断是否为最后一行
     * @param parent
     * @param pos
     * @param childCount
     * @param spanCount
     * @return
     */
    private boolean  isLastRaw(RecyclerView parent,int pos,int childCount,int spanCount){
        RecyclerView.LayoutManager layoutManager =parent.getLayoutManager();
        if(layoutManager instanceof  GridLayoutManager){
            childCount=childCount-childCount%spanCount;
            if(pos>=childCount){//如果是最后一个行，则不需要绘制底部
                return true;
            }
        }else if(layoutManager instanceof StaggeredGridLayoutManager){//瀑布流 则需要根据相应的方向进行判断
            int oratation=((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if(oratation==StaggeredGridLayoutManager.VERTICAL){//纵向滚动
                childCount=childCount-childCount%spanCount;
                if(pos>=childCount){//到了最后一行，不需要绘制底部
                    return true;
                }
            }else if(oratation==StaggeredGridLayoutManager.HORIZONTAL){//横向滚动，如果是最后一行，则不需要绘制底部
                if((pos+1)%spanCount==0){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否为最后一列
     * @param parent
     * @param pos
     * @param chidleCount
     * @param spanCount
     * @return
     */
    private boolean isLastColume(RecyclerView parent,int pos,int chidleCount,int spanCount){
       RecyclerView.LayoutManager layoutManager= parent.getLayoutManager();
        if(layoutManager instanceof  GridLayoutManager){
            if((pos+1)%spanCount==0){
                return true;
            }
        }else if(layoutManager instanceof  StaggeredGridLayoutManager){
            int orientation=((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if(orientation==StaggeredGridLayoutManager.VERTICAL){
                if((pos+1)%spanCount==0){
                    return true;
                }
            }else{
                chidleCount=chidleCount-chidleCount%spanCount;
                if(pos>=chidleCount){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int childCount=parent.getAdapter().getItemCount();
        int spanCount=getSpanCount(parent);//直接能在decoration中拿到
        if(isLastRaw(parent,((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(),childCount,spanCount)){//最后一行,则不需要绘制底部
            outRect.set(0,0,mDrawable.getIntrinsicHeight(),0);
        }else if(isLastColume(parent,((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition(),childCount,spanCount)){//最后一列，不需要绘制右边
            outRect.set(0,0,0,mDrawable.getIntrinsicHeight());
        }else {
            outRect.set(0,0,mDrawable.getIntrinsicHeight(),mDrawable.getIntrinsicHeight());
        }
    }


}
