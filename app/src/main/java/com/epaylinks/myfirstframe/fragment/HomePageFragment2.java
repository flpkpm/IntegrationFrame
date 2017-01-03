package com.epaylinks.myfirstframe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseFragment;


/**
 * Created by Administrator on 2016/12/20.
 */
public class HomePageFragment2 extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_content2,container,false);
        return view;
    }
}
