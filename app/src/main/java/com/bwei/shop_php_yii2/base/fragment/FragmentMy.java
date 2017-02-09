package com.bwei.shop_php_yii2.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.shop_php_yii2.R;

/**
 * 作    者 ： 文欢
 * 时    间 ： 2017/2/9.
 * 描    述 ：
 * 修改时间 ：
 */

public class FragmentMy extends BaseFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHeader();
        initWidget();
        setWidgetState();
    }

    @Override
    public void initHeader() {

    }

    @Override
    public void initWidget() {

    }

    @Override
    public void setWidgetState() {

    }
}
