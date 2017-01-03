package com.epaylinks.myfirstframe.wedigitview;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;

/**
 * Created by Auser on 2016/12/15.
 */

public class Android23NavigationMenuActivity extends BaseActivity {

    private NavigationView nva_view;
    private DrawerLayout dl;
    private View fl_content;

    @Override
    protected void setUpView() {
        dl = (DrawerLayout) findViewById(R.id.dl);
        fl_content = findViewById(R.id.fl_content);
        nva_view = (NavigationView) findViewById(R.id.nva_view);

        nva_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Snackbar.make(fl_content,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                item.setChecked(true);
                dl.closeDrawers();
                return true;
            }
        });
    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_android23_navigationmenu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        
    }
    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(toolbar);
/*        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.a);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }*/
    }
}
