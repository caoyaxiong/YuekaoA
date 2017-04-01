package com.bwie.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/30 20:05
 */

public class SecondActivity extends Activity implements CallBackToData{
    private RecyclerView recyclerView;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            RequsetBean requsetBean= (RequsetBean) msg.obj;
            MyAdapter adapter = new MyAdapter(SecondActivity.this,requsetBean);
            recyclerView.setAdapter(adapter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        HttpHelp.getHttp(Constants.S,RequsetBean.class,this);
        recyclerView = (RecyclerView) findViewById(R.id.recy);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

    }

   

    @Override
    public void listener(int type) {
        
    }

    @Override
    public void jsonData(Object json) {
        Message message=Message.obtain(handler,0,json);
        handler.sendMessage(message);
    }
}
