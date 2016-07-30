package bank.bank.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bank.bank.Beans.Add_Left_listviewBean;
import bank.bank.Beans.AreaList;
import bank.bank.ui.R;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Add_Left_Listview extends BaseAdapter {
    private Context context;
    private List<Add_Left_listviewBean> list;
    private LayoutInflater inflater;

    public Add_Left_Listview(Context context,List<Add_Left_listviewBean>list){
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return list!=null? list.size():0;
    }

    @Override
    public Object getItem(int i) {
        return list!=null ?list.get(i):0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        addLeftholder add=null;
        if(v==null){
            v =inflater.inflate(R.layout.add_left_listciew,null);
            add=new addLeftholder();
            add.tv= (TextView) v.findViewById(R.id.add_left_listview);
            add.img= (ImageView) v.findViewById(R.id.remen_img);
            v.setTag(add);
        }else{
            add= (addLeftholder) v.getTag();
        }
        Add_Left_listviewBean bean=list.get(i);
        add.tv.setText(bean.getTv());
        add.img.setImageResource(bean.getImg());
        //Picasso.with(context).load(bean.getImg()).into(add.img);
        return null;
    }
    class addLeftholder{
        TextView tv;
        ImageView img;
    }
}
