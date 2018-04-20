package com.ane.testdemo.retrofit;

import android.os.Bundle;
import android.widget.TextView;

import com.ane.testdemo.R;
import com.ane.testdemo.base.BaseActivity;
import com.ane.testdemo.base.utils.TLog;
import com.google.gson.Gson;
import com.pda.common.util.Base64;
import com.pda.common.util.MD5Util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends BaseActivity {
    @BindView(R.id.textview)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_retrofit;
    }

    @Override
    public void initData() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这里可以选择拦截级别
        client.addInterceptor(loggingInterceptor);
        client.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json;charset=UTF-8")
                        .build();
                return chain.proceed(request);
            }
        });

        Retrofit retrofit1 = new Retrofit.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://58.215.167.5:60216/webservice/pdaServerRest/operate/")
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

//        Call<ResponseBody> call = service.pdaLoginServiceImpl("9506002", "9505002", "123456");

        Map<String, Object> map = new HashMap<>();
        map.put("siteCode", "9506002");
        map.put("employeeNo", "9505002");
        map.put("pdaPwd", "123456");

        Call<ResponseBody> call = service.pdaLoginServiceImpl(getRequest("pdaLoginServiceImpl", new Gson().toJson(map)));

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                TLog.log("onResponse call  " + call.toString());
                try {
                    textView.setText(response.body().string());
                    TLog.log("onResponse response   " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                TLog.log("onFailure call  " + call.toString());
                TLog.log("onFailure t " + t.getMessage());

            }
        });
    }

    public HttpParams getRequest(String urlType, String postParam) {
        HttpParams entity = new HttpParams();
        entity.setParams(postParam);
        String digest = null;
        try {
            digest = Base64.encode(MD5Util.encryption(postParam
                    + "ane123456").getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        entity.setDigest(digest);
        entity.setType(urlType);
        entity.setTimestamp(new Date().getTime());
        return entity;
    }

    @Override
    public void initView() {

    }


}
