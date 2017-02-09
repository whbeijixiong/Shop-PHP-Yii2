package com.bwei.shop_php_yii2.base.activity;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.shop_php_yii2.R;

/**
 * 作    者 ： 文欢
 * 时    间 ： 2017/2/9.
 * 描    述 ：
 * 修改时间 ：
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{

    private TextView main_title_tv;

    private ImageView main_title_img;

    //初始化头部
    public abstract void initHeader();

    //初始化控件
    public abstract void initWidget();

    //设置监听
    public abstract void setWidgetState();
    public void inittHeaderWidget(){
        main_title_img = (ImageView) findViewById(R.id.main_title_img);
        main_title_tv = (TextView) findViewById(R.id.main_title_tv);


    }
    public void setTitle(String title) {//设置中间文字的内容
        main_title_img.setVisibility(View.GONE);
        main_title_tv.setText(title);
    }

}

