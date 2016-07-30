package bank.bank.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import bank.bank.ui.R;


/**
 * Created by Administrator on 2016/7/22.
 */
public class ForgetPassWorld extends AppCompatActivity implements View.OnClickListener{
    private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpassworld);
        initview();
        addListener();
    }

    private void addListener() {
        im.setOnClickListener(this);
    }

    private void initview() {
        im= (ImageView) findViewById(R.id.btn_video_play_back_pressed_register);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_video_play_back_pressed_register:
                //忘记密码页面返回登录住页面
                Intent intent=new Intent();
                setResult(1,intent);
                finish();
        }
    }
}
