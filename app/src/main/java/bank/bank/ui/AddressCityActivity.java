package bank.bank.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import bank.bank.Adapter.Add_Left_Listview;
import bank.bank.Beans.AreaList;
import bank.bank.Utils.AddrUtils;


/**
 * Created by Administrator on 2016/7/21.
 */
public class AddressCityActivity extends Fragment{
    //private ListView lv;
    //private List<AreaList> list;
    //private Context context;
    private View view;
    //private Add_Left_Listview adapter;
    //private static final int ADDRESS=1000;

//    private Handler handler=new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case ADDRESS:
//                    String response= (String) msg.obj;
//                    List<AreaList> data= AddrUtils.getaddrlist(response);
//                    if(data!=null){
//                        list.clear();
//                        list.addAll(data);
//                        adapter.notifyDataSetChanged();
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//    };
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        //获得当前页面的内容
//        context=getActivity();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.addr_activity,container,false);

//        adapter = new Add_Left_Listview(context, list);
//        lv = (ListView) view.findViewById(R.id.left_listview);
//        lv.setAdapter(adapter);
//        getADDress();
//        addListener();
        return view;
    }

//    private void addListener() {
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });
//
//    }
//
//    public void getADDress() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    URL url=new URL("http://www.ut2o.com/annualleave/destination.json");
//                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
//                    conn.setRequestMethod("POST");
//                    conn.setConnectTimeout(8*1000);
//                    conn.setReadTimeout(8*1000);
//                    //添加请求头
//                    conn.addRequestProperty("version","4.0");
//                    conn.addRequestProperty("Content-Length","219");
//                    conn.addRequestProperty("Host","www.ut2o.com");
//                    conn.addRequestProperty("Connection","Keep-Alive");
//                    conn.setDoInput(true);
//                    conn.setDoOutput(true);
//                    OutputStream os=conn.getOutputStream();
//                    os.write("bparam=%7B%22cp%22%3A0%2C%22imei%22%3A%22864394010220855%22%2C%22lang%22%3A%22cn%22%2C%22re%22%3A0%2C%22requesttype%22%3A0%2C%22sys%22%3A%22android%22%2C%22uri%22%3A%22%22%2C%22userId%22%3A0%2C%22vid%22%3A%221_0_0%22%7D".getBytes());
//                    os.flush();
//
//                    InputStream is=conn.getInputStream();
//                    BufferedReader br=new BufferedReader(new InputStreamReader(is));
//                    StringBuffer sb=new StringBuffer();
//                    String line="";
//                    while ((line=br.readLine())!=null){
//                        sb.append(line);
//                    }
//                    Message msg=new Message();
//                    msg.what=ADDRESS;
//                    msg.obj=sb.toString();
//                    //发送消息
//                    handler.sendMessage(msg);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
//
//    }
}
