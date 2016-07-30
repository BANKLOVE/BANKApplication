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
public class ShoppingCar extends AppCompatActivity implements View.OnClickListener {
    private ImageView carback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcar);
        initview();
        addListener();
    }

    private void addListener() {
        carback.setOnClickListener(this);
    }

    private void initview() {
        carback= (ImageView) findViewById(R.id.shoping_back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shoping_back:
                //返回商城主页面
                Intent intent=new Intent();
                setResult(1,intent);
                finish();
        }


    }
}
