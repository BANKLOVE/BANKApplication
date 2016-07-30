package bank.bank.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import bank.bank.Beans.UserTable;
import bank.bank.fragment.BottomTabActivity;
import bank.bank.ui.MineActivity;
import bank.bank.ui.R;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by Administrator on 2016/7/21.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imagelogin;
    private TextView textlogin;
    private EditText phone_login;
    private EditText phone_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_login);
        //第一：默认初始化
        Bmob.initialize(this, "dcd1b09351037209f2eba5ffa037bf33");
        initview();
        addListener();
    }

    private void addListener() {
        imagelogin.setOnClickListener(this);
        textlogin.setOnClickListener(this);
    }

    private void initview() {
        imagelogin= (ImageView) findViewById(R.id.btn_video_play_back_pressed_login);
        textlogin= (TextView) findViewById(R.id.loginText);
        phone_login= (EditText) findViewById(R.id.phoneNumber);
        phone_pwd= (EditText) findViewById(R.id.phonepwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_video_play_back_pressed_login:
                //登录页面返回个人主页面
                Intent intent=new Intent();
                setResult(1,intent);
                finish();
                break;
            case R.id.loginText:
                if(TextUtils.isEmpty(phone_login.getText().toString())){
                    Toast.makeText(LoginActivity.this,"请输入手机号码",Toast.LENGTH_SHORT).show();
                }else if(phone_login.getText().length()!=11){
                    Toast.makeText(LoginActivity.this,"手机号码格式错误",Toast.LENGTH_SHORT).show();
                }else {
                    //查找Person表里面id为AT5SFFFP的数据
                    BmobQuery<UserTable> bmobQuery = new BmobQuery<UserTable>();
                    bmobQuery.addWhereEqualTo("phoneNum",phone_login.getText().toString());
                    bmobQuery.findObjects(new FindListener<UserTable>() {
                        @Override
                        public void done(List<UserTable> list, BmobException e) {
                            if (e==null){
                                if (list.size()==0){
                                  Toast.makeText(LoginActivity.this,"手机号不存在",Toast.LENGTH_SHORT).show();
                                }else{
                                    for (UserTable usertable:list){
                                        //获得phone的信息
                                        usertable.getPhoneNum();
                                        //获得password的信息
                                        usertable.getPassword();
                                        if((phone_login.getText().toString()).equals(usertable.getPhoneNum())){
                                             if (phone_pwd.getText().toString().equals("")){
                                                 Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                                             }else if((phone_pwd.getText().toString()).equals(usertable.getPassword())){
                                                 Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                                 Intent intent=new Intent(LoginActivity.this, BottomTabActivity.class);
                                                 startActivity(intent);

                                                     }else{
                                                 Toast.makeText(LoginActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                                    }
                                }
                                    }
                                }

                            }
                        }
                    });
                    break;

                }
        }
    }
}
