package com.wangj.smartion.smartion;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragemnt extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = initView(inflater,container);
        return view;
    }

    /**
     * 找到视图和控件的方法
     * @param inflater
     * @param container
     * @return
     */
    protected abstract View initView(LayoutInflater inflater, ViewGroup container);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        //初始化数据
        initData();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
