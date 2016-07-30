package bank.bank.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import bank.bank.ui.R;

/**
 * Created by Administrator on 2016/7/26.
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView settingback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wangluosetting);
        initview();
        addListener();
    }

    private void addListener() {
        settingback.setOnClickListener(this);
    }

    private void initview() {
        settingback= (ImageView) findViewById(R.id.setting_wangluo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_wangluo:
                //返回我的主页面
                Intent inteng=new Intent();
                setResult(1,inteng);
                finish();
        }

    }
}
