package bank.bank.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import bank.bank.ui.R;

/**
 * Created by Administrator on 2016/7/28.
 */
public class WeiXing extends AppCompatActivity implements View.OnClickListener{
    private ImageView weixingBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wei_xing_login);
        initview();
        addlistener();
    }

    private void addlistener() {
        weixingBack.setOnClickListener(this);
    }

    private void initview() {
        weixingBack= (ImageView) findViewById(R.id.weixing);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.weixing:
                //返回我的页面
                Intent intent=new Intent();
                setResult(1,intent);
                finish();
        }

    }
}
