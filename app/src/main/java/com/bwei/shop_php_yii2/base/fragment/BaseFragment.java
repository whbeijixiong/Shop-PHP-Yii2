package com.bwei.shop_php_yii2.base.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 作    者 ： 文欢
 * 时    间 ： 2017/2/9.
 * 描    述 ：
 * 修改时间 ：
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    //初始化头部
    public abstract void initHeader();

    //初始化控件
    public abstract void initWidget();

    //设置监听
    public abstract void setWidgetState();
    @Override
    public void onClick(View view) {

    }
}
