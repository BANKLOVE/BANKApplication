package bank.bank.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import bank.bank.Beans.UserTable;
import bank.bank.ui.R;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Administrator on 2016/7/21.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageregister;//返回箭头图片
    private EditText phoneRegister;//输入手机号码
    private EditText phoneIdenty;//输入验证码
    private TextView send;//发送验证码
    private EditText pwd;//输入登录密码
    private TextView register;//注册
    private boolean over=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_register);
        //第一：默认初始化
        Bmob.initialize(this, "dcd1b09351037209f2eba5ffa037bf33");
        initview();
        addListener();
    }

    private void addListener() {
        imageregister.setOnClickListener(this);
        register.setOnClickListener(this);
        send.setOnClickListener(this);
    }

    private void initview() {
        imageregister= (ImageView) findViewById(R.id.btn_video_play_back_pressed_register);
        phoneRegister= (EditText) findViewById(R.id.register_phone);
        phoneIdenty= (EditText) findViewById(R.id.send_identifying);
        send= (TextView) findViewById(R.id.identy);
        register= (TextView) findViewById(R.id.myRegister);
        pwd= (EditText) findViewById(R.id.register_pwd);

    }

    @Override
    public void onClick(View v) {
        final String str=phoneRegister.getText().toString();//手机号码
        final String ident=phoneIdenty.getText().toString();//验证码
        final String pass=pwd.getText().toString();//密码
        switch (v.getId()){
            case R.id.btn_video_play_back_pressed_register:
                //返回个人住页面
                Intent intent=new Intent();
                setResult(1,intent);
                finish();
                break;
            case R.id.identy:
                //发送短信并验证
                BmobSMS.requestSMSCode(str, "短信模板", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer integer, BmobException e) {
                        if(e==null){
                            //验证码发送成功
                            Toast.makeText(RegisterActivity.this,"发送成功",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(RegisterActivity.this,"发送失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                final CountDownTimer cd=new CountDownTimer(60*1000,1000) {
                    @Override
                    public void onTick(long l) {
                        send.setText(l / 1000+"s");
                    }
                    @Override
                    public void onFinish() {
                        over=true;
                        send.setText("重新获取");
                    }
                };
                cd.start();
                if(over){
                    cd.start();
                    BmobSMS.requestSMSCode(str, "短信模板", new QueryListener<Integer>() {
                        @Override
                        public void done(Integer integer, BmobException e) {
                            if(e==null){//验证码发送成功
                                Toast.makeText(RegisterActivity.this,"发送成功",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    over=false;
                }
                break;
            case R.id.myRegister:
                BmobSMS.verifySmsCode(str, ident, new UpdateListener() {
                    @Override
                    public void done(BmobException ex) {
                        if(ex==null){//短信验证码已验证成功
                            UserTable u=new UserTable();
                            u.setPhoneNum(str);
                            u.setPassword(pass);
                            //注意：不能用save方法进行注册
                            u.save(new SaveListener<String>() {
                                @Override
                                public void done(String s, BmobException e) {
                                    if(e==null){
                                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                        builder.setTitle("注册成功");
                                        builder.setMessage("是否进行登录");
                                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                                                startActivity(intent);
                                            }
                                        });
                                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });
                                        AlertDialog dialog=builder.create();
                                        dialog.show();

                                    }else {
                                        Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(RegisterActivity.this,"验证错误",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
        }

    }
}
