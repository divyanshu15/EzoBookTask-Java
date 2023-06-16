package com.divyanshu.ezobooksjava.Api;

import com.divyanshu.ezobooksjava.ResponseDataClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("list")
    Call<ResponseDataClass> getData();
}
