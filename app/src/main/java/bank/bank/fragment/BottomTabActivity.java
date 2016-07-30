package bank.bank.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import android.widget.RadioButton;
import android.widget.RadioGroup;

import bank.bank.ui.AddressCityActivity;
import bank.bank.ui.MainActivity;
import bank.bank.ui.MineActivity;

import bank.bank.ui.ShopAddrActivity;
import android.widget.RadioGroup.OnCheckedChangeListener;
import bank.bank.ui.R;
/**
 * Created by Administrator on 2016/7/21.
 * 碎片
 */
public class BottomTabActivity extends AppCompatActivity{
    private RadioGroup rg;
    MainActivity first;
    MineActivity mine;
    ShopAddrActivity shop;
    AddressCityActivity address;
    private RadioButton rb;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_activity);
        //添加初始化
        initview();
        //添加监听
        addListener();

        first=new MainActivity();
        mine=new MineActivity();
        shop=new ShopAddrActivity();
        address=new AddressCityActivity();
        addFragment(first);
        rb.setChecked(true);

    }

    private void  addFragment(Fragment f){
        // 碎片管理者
        FragmentManager fm = getFragmentManager();
        // 获取碎片事务
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_wrapper, f);
        // 提交事务
        ft.commit();

    }

    private void addListener() {
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.FirstPage:
                        if(first.isAdded())
                            break;
                        replaceFragment(first);
                        break;
                    case R.id.Shopping:
                        if(shop.isAdded())
                            break;
                        replaceFragment(shop);
                        break;
                    case R.id.Finding:
                        if(address.isAdded())
                            break;
                        replaceFragment(address);
                        break;
                    case R.id.Mine:
                        if(mine.isAdded())
                            break;
                        replaceFragment(mine);
                        break;
                }
            }

            private void replaceFragment(Fragment f) {
                // 碎片管理者
                FragmentManager fm = getFragmentManager();
                // 获取碎片事务
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_wrapper, f);
                // 提交事务
                ft.commit();
            }
        });
    }


    private void initview() {
        rg= (RadioGroup) findViewById(R.id.rg_container);
        rb= (RadioButton) findViewById(R.id.FirstPage);
    }
}
