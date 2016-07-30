package bank.bank.Utils;

import com.alibaba.fastjson.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import bank.bank.Beans.AreaList;
/**
 * Created by Administrator on 2016/7/28.
 */
public class AddrUtils {
    public  static List<AreaList>getaddrlist(String json){
        JSONObject obj;
        List<AreaList> list=null;
        try {
            obj=new JSONObject(json);
            if(obj.getInt("code")==0){
                JSONArray array=obj.getJSONArray("data");
                list= JSON.parseArray(array.toString(),AreaList.class);
            }else{
                list=null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
