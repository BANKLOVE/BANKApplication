package bank.bank.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import bank.bank.Activity.LoginActivity;
import bank.bank.Activity.QQActivity;
import bank.bank.Activity.RegisterActivity;
import bank.bank.Activity.SettingActivity;
import bank.bank.Activity.WeiXing;

/**
 * Created by Administrator on 2016/7/21.
 */
public class MineActivity extends Fragment implements View.OnClickListener{
    private Button login;//登录
    private Button register;//注册
    private ImageView setting;//设置
    private ImageView weixing;//微信
    private ImageView QQ;//QQ

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.mine_fragment,container,false);
        //初始化
        InitView(view);
        //添加监听
        addListener();
        return view;
    }

    private void addListener() {
        //实现监听
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        setting.setOnClickListener(this);
        weixing.setOnClickListener(this);
       QQ.setOnClickListener(this);
    }

    private void InitView(View view) {
        //控件实例化
        login= (Button) view.findViewById(R.id.login);
        register= (Button) view.findViewById(R.id.register);
        setting= (ImageView) view.findViewById(R.id.shezhi);
        weixing= (ImageView) view.findViewById(R.id.weixing_login);
        QQ= (ImageView) view.findViewById(R.id.QQ_login);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                //跳转登录页面
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.register:
                //跳转注册页面
                Intent intent1=new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.shezhi:
                //跳转设置页面
                Intent intent2=new Intent(getActivity(), SettingActivity.class);
                startActivity(intent2);
                break;
            case R.id.weixing_login:
                //跳转微信登录页面
                Intent intent3=new Intent(getActivity(), WeiXing.class);
                startActivity(intent3);
                break;
            case R.id.QQ_login:
                //跳转QQ登录页面
                Intent intent4=new Intent(getActivity(), QQActivity.class);
                startActivity(intent4);
                break;

        }

    }
}

