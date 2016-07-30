package bank.bank.Beans;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/7/28.
 */
public class UserTable extends BmobObject{
    private String phoneNum;
    private String password;

    public UserTable() {
    }

    public UserTable(String phoneNum, String password) {
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }



}
