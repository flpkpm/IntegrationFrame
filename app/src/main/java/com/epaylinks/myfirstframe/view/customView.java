package com.epaylinks.myfirstframe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/22.
 */

public class customView extends View {

    public customView(Context context) {
        super(context);
    }

    public customView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public customView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        MeasureSpec.getMode(widthMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //对于view来说onLayout()方法只是一个空实现

    }
}
