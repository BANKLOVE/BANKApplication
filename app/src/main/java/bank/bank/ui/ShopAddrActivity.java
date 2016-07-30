package bank.bank.ui;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import bank.bank.Activity.ShoppingCar;
import bank.bank.ui.R;
/**
 * Created by Administrator on 2016/7/21.
 */
public class ShopAddrActivity extends Fragment {

    private ImageView car;//购物车

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.shop_fragment,container,false);




        return view;
    }



}
