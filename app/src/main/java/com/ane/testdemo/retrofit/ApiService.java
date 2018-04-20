package com.ane.testdemo.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lenovo on 2018/4/10.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("pdaLoginServiceImpl")
    Call<ResponseBody> pdaLoginServiceImpl(@Field("siteCode") String siteCode,
                                           @Field("employeeNo") String employeeNo,
                                           @Field("pdaPwd") String pdaPwd);

    @POST(".")
    Call<ResponseBody> pdaLoginServiceImpl(@Body HttpParams httpParams);
}
