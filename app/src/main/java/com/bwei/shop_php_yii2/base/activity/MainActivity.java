package com.bwei.shop_php_yii2.base.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bwei.shop_php_yii2.R;
import com.bwei.shop_php_yii2.base.entity.ShowFragment;
import com.bwei.shop_php_yii2.base.fragment.FragmentFavorable;
import com.bwei.shop_php_yii2.base.fragment.FragmentMy;
import com.bwei.shop_php_yii2.base.fragment.FragmentShop;
import com.bwei.shop_php_yii2.base.fragment.FragmentTea;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private Button btn_main_buttom_tea;
    private Button btn_main_buttom_favorable;
    private Button btn_main_buttom_my;
    private Button btn_main_buttom_shop;

    //获得管理者
    FragmentManager manager;
    //开启事务
    FragmentTransaction transaction;
    //用来添加fragment  的list
    List<ShowFragment> fragmentList = new ArrayList<ShowFragment>();

    //当前应该加载的fragment
    int current;
    private FragmentTea fragmentTea;
    private FragmentFavorable fragmentFavorable;
    private FragmentShop fragmentShop;
    private FragmentMy fragmentMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHeader();
        initWidget();
        setWidgetState();
    }

    @Override
    public void initHeader() {

        inittHeaderWidget();
        setTitle("月光茶人");
    }

    @Override
    public void initWidget() {

        btn_main_buttom_tea = (Button) findViewById(R.id.btn_main_buttom_tea);
        btn_main_buttom_favorable = (Button) findViewById(R.id.btn_main_buttom_favorable);
        btn_main_buttom_my = (Button)findViewById(R.id.btn_main_buttom_my);
        btn_main_buttom_shop = (Button) findViewById(R.id.btn_main_buttom_shop);

        //获得管理者
        manager = getSupportFragmentManager();
        //实例化fragment
        fragmentTea = new FragmentTea();
        fragmentFavorable = new FragmentFavorable();
        fragmentShop = new FragmentShop();
        fragmentMy = new FragmentMy();
        addlist();
        //三木运算
        addFragment(current == 0? 0 : current);
    }

    private void addlist() {
        for (int i = 0 ;i<4;i++){
            ShowFragment fragment = new ShowFragment();
            switch (i){
                case 0:
                    fragment.fragment = fragmentTea;
                    break;
                case 1:
                    fragment.fragment = fragmentFavorable;
                    break;
                case 2:
                    fragment.fragment = fragmentShop;
                    break;
                case 3:
                    fragment.fragment = fragmentMy;
                    break;
            }
            fragmentList.add(fragment);
        }
    }
    //将 fragment 加载进来
    public void addFragment(int position) {

        transaction = manager.beginTransaction();
        //将fragment 加载进来
        for (int i = 0; i < fragmentList.size(); i++) {

            if (i != position) {
                transaction.hide(fragmentList.get(i).fragment);
            }
        }

        if (fragmentList.get(position).statue == 0) {
            transaction.add(R.id.fram_main_content, fragmentList.get(position).fragment, position + "");
            fragmentList.get(position).statue = 1;
            transaction.show(fragmentList.get(position).fragment);
        } else {
            transaction.show(fragmentList.get(position).fragment);
        }

        transaction.commit();

    }

    @Override
    public void setWidgetState() {
        btn_main_buttom_tea.setOnClickListener(this);
        btn_main_buttom_favorable.setOnClickListener(this);
        btn_main_buttom_shop.setOnClickListener(this);
        btn_main_buttom_my.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
