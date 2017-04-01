package com.bwie.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SelfView selfView = (SelfView) findViewById(R.id.self);
        selfView.setMyCallBack(new CallBackToData() {
            @Override
            public void listener(int type) {
                switch (type)
                {
                    case SelfView.donw:
                        Toast.makeText(MainActivity.this,"点击了圆环上上上",Toast.LENGTH_SHORT).show();break;
                    case SelfView.in:
                        startActivity(new Intent(MainActivity.this,SecondActivity.class));
                        Toast.makeText(MainActivity.this,"点击了圆环内内内",Toast.LENGTH_SHORT).show();break;
                    case SelfView.out:
                        Toast.makeText(MainActivity.this,"点击了圆环外外外",Toast.LENGTH_SHORT).show();break;
                }

            }

            @Override
            public void jsonData(Object json) {

            }
        });
    }
}
