package com.tools.payhelper.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tools.payhelper.CustomApplcation;
import com.tools.payhelper.R;
import com.tools.payhelper.utils.DBManager;
import com.tools.payhelper.utils.OrderBean;

import java.util.ArrayList;

public class BillListActivity extends Activity {
    ArrayList<OrderBean> orderBeans;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);
        DBManager dbManager=new DBManager(CustomApplcation.getInstance().getApplicationContext());
        orderBeans= dbManager.FindPayOrderAll();
        ListView mlist= (ListView) findViewById(R.id.mlist);
        mlist.setAdapter(new MyAdapter());

    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return orderBeans.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = getLayoutInflater().inflate(R.layout.bill_item, null);
            TextView tv_type= (TextView) inflate.findViewById(R.id.tv_type);
            TextView tv_money= (TextView) inflate.findViewById(R.id.tv_money);
            TextView tv_mark= (TextView) inflate.findViewById(R.id.tv_mark);



            return inflate;
        }
    }
}
