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
public class QQActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView qqBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_login);
        initview();
        addListener();
    }

    private void addListener() {
        qqBack.setOnClickListener(this);
    }

    private void initview() {
        qqBack= (ImageView) findViewById(R.id.qq_login_back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qq_login_back:
                Intent intent=new Intent();
                setResult(1,intent);
                finish();
        }

    }
}
