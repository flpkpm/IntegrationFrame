package com.epaylinks.myfirstframe.ui;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;
import com.epaylinks.myfirstframe.recyclerview.MyGridViewDecoration;
import com.epaylinks.myfirstframe.recyclerview.RecyclerviewLinearLayoutAdapter;
import com.epaylinks.myfirstframe.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/8.
 */

public class RecyclerViewActivity extends BaseActivity{

    private RecyclerView ry_start;
    private RecyclerviewLinearLayoutAdapter mAdapter;

    @Override
    protected void setUpView() {
        ry_start = (RecyclerView) findViewById(R.id.ry_start);
        
    }

    @Override
    protected void setUpData() {
        List<String> str=new ArrayList<>();
        for (int i = 0; i <77 ; i++) {
            str.add(""+i);
        }
//        LinearLayoutManager lm=new LinearLayoutManager(this);
//        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
//        ry_start.setLayoutManager(lm);
//        //ItemDecoration为抽象类 需要自定义分割线 那么我也需要定义自己的几个默认下划线，以备后面使用
//        ry_start.addItemDecoration(new MyListViewDecoration(this,LinearLayoutManager.HORIZONTAL) );
        //GridView
//        GridLayoutManager gl=new GridLayoutManager(this,4);
//        gl.setOrientation(GridLayoutManager.VERTICAL);
//        ry_start.setLayoutManager(gl);
//        ry_start.addItemDecoration(new MyGridViewDecoration(this));
        //StaggeredGridView
        //参数为 几行 然后就是方向了
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        ry_start.setLayoutManager(layoutManager);
        ry_start.addItemDecoration(new MyGridViewDecoration(this));
        mAdapter=new RecyclerviewLinearLayoutAdapter(str);
        mAdapter.setOnClickListener(new RecyclerviewLinearLayoutAdapter.recyclerClickListener() {
            @Override
            public void onClickListener(int position) {
                ToastUtil.showLong("点击了："+position);
                mAdapter.removeItem(position);
            }

            @Override
            public void onLongClickListener(int position) {
                ToastUtil.showLong("长按了："+position);
                //TODO:添加
                mAdapter.addItem("添加的",position);
            }
        });
        ry_start.setItemAnimator(new DefaultItemAnimator());
        ry_start.setAdapter(mAdapter);

    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_recyclerview);
    }
}
