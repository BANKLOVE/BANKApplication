package bank.bank.fragment;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import bank.bank.ui.R;
/**
 * Created by Administrator on 2016/7/27.
 */
public class Covertitle extends AppCompatActivity{
    private ImageView cloud,earth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covertitle_page);
        initview();

        Animation anim1= AnimationUtils.loadAnimation(this, R.anim.ctivity_picture);
        earth.startAnimation(anim1);

        Animation anim2= AnimationUtils.loadAnimation(this, R.anim.cloud_picture);
        cloud.startAnimation(anim2);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent=new Intent(Covertitle.this, BottomTabActivity.class);
                startActivity(intent);
                finish();
            }
        },5*1000);

    }

    private void initview() {
        //控件实例化
        earth= (ImageView) findViewById(R.id.earth);
        cloud= (ImageView) findViewById(R.id.cloud);
    }

}

