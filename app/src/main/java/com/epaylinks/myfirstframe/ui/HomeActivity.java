package com.epaylinks.myfirstframe.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.adapter.HomePageViewAdapter;
import com.epaylinks.myfirstframe.base.BaseActivity;
import com.epaylinks.myfirstframe.fragment.HomePageFragment1;
import com.epaylinks.myfirstframe.fragment.HomePageFragment2;


/**
 * Created by Administrator on 2016/12/20.
 */

public class HomeActivity extends BaseActivity  {

    private ViewPager vp_content;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private NavigationView nv_view;

    @Override
    protected void setUpView() {
        vp_content = (ViewPager) findViewById(R.id.vp_content);
        toolbar = (Toolbar) findViewById(R.id.tb_title);
        toolbar.setTitle("新闻头条");
//        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));

        nv_view = (NavigationView) findViewById(R.id.nv_view);

        nv_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return false;
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tl_content);
        tabLayout.addTab(tabLayout.newTab().setText("朝闻天下"));
        tabLayout.addTab(tabLayout.newTab().setText("喜怒哀乐"));

        HomePageViewAdapter adapter=new HomePageViewAdapter(getSupportFragmentManager());
        adapter.add(new HomePageFragment1(),"呵呵哒");
        adapter.add(new HomePageFragment2(),"萌萌哒");

        vp_content.setAdapter(adapter);

        tabLayout.setupWithViewPager(vp_content);


    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_home);
    }
}
