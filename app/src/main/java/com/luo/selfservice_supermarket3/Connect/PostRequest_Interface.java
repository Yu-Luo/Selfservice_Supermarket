package com.luo.selfservice_supermarket3.Connect;

import com.luo.selfservice_supermarket3.Class.Supermarket1;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostRequest_Interface {
    @POST("GetSupermarketbyCity_Servlet?")
    @FormUrlEncoded
    //按城市查找超市
    Call<Supermarket1> getCall(@Field("city") String targetSentence);
    //采用@Post表示Post方法进行请求（传入部分url地址）
    // 采用@FormUrlEncoded注解的原因:API规定采用请求格式x-www-form-urlencoded,即表单形式
    // 需要配合@Field 向服务器提交需要的字段
}
