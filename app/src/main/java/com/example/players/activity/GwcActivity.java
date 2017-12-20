package com.example.players.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.players.Bean.CartBean;
import com.example.players.R;
import com.example.players.adapter.RecyAdapter;
import com.example.players.presenter.PresenterView_jr;
import com.example.players.utils.BaseActivity;
import com.example.players.view.IbeanView_jr;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 九号 on 2017/12/20.
 */

public class GwcActivity extends BaseActivity<PresenterView_jr> implements IbeanView_jr {
    PresenterView_jr presenterView_jr;
    @BindView(R.id.recycler_View)
    RecyclerView recyclerView;
    @BindView(R.id.quanxuan)
    CheckBox quanxuan;
    @BindView(R.id.total_price)
    TextView totalPrice;
    @BindView(R.id.total_num)
    TextView totalNum;
    private TextView total_price;
    private TextView total_num;
    private RecyAdapter recyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gwc);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        total_price = (TextView) findViewById(R.id.total_price);
        total_num = (TextView) findViewById(R.id.total_num);
        quanxuan = (CheckBox) findViewById(R.id.quanxuan);

        quanxuan.setTag(1);//1为不选中
        //new出适配器
        recyAdapter = new RecyAdapter(this);
        presenterView_jr=new PresenterView_jr(this);
        presenterView_jr.showjr2();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyAdapter);


        //调用recyAdapter里面的接口,设置 全选按钮 总价 总数量
        recyAdapter.setUpdateListener(new RecyAdapter.UpdateListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                //设置ui的改变
                total_num.setText("共"+num+"件商品");//总数量
                total_price.setText("总价 :¥"+total+"元");//总价
                if(allCheck){
                    quanxuan.setTag(2);
                    quanxuan.setBackgroundResource(R.drawable.shopcart_selected);
                }else{
                    quanxuan.setTag(1);
                    quanxuan.setBackgroundResource(R.drawable.shopcart_unselected);
                }
                quanxuan.setChecked(allCheck);
            }
        });
        //这里只做ui更改, 点击全选按钮,,调到adapter里面操作
        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用adapter里面的方法 ,,把当前quanxuan状态传递过去

                int tag = (int) quanxuan.getTag();
                if(tag==1){
                    quanxuan.setTag(2);
                    quanxuan.setBackgroundResource(R.drawable.shopcart_selected);
                }else{
                    quanxuan.setTag(1);
                    quanxuan.setBackgroundResource(R.drawable.shopcart_unselected);
                }

                recyAdapter.quanXuan(quanxuan.isChecked());
            }
        });
    }


    @Override
    public void showButtonjr(CartBean cartBean) {
        //拿到返回来的数据 ,, 传给适配器数据
        recyAdapter.add(cartBean);
    }

    @Override
    protected void createpresenter() {
        presenterView_jr = new PresenterView_jr(this);
    }


}