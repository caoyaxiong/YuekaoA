package com.bwie.test;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;



/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/30 19:31
 */

public class HttpHelp {
    public static <T> void getHttp(String url, final Class<T> clazz, final CallBackToData callBackToData){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String json=response.body().string();
                Gson gson=new Gson();
                T data=gson.fromJson(json,clazz);
                Log.e("zzz",data.toString());
                callBackToData.jsonData(data);
            }

           
        });
    }
}
