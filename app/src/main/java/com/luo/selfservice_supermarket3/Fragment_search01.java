package com.luo.selfservice_supermarket3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luo.selfservice_supermarket3.Adapter.SupermarketAdapter;
import com.luo.selfservice_supermarket3.Class.Supermarket;
import com.luo.selfservice_supermarket3.Class.Supermarket1;
import com.luo.selfservice_supermarket3.Connect.PostRequest_Interface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


public class Fragment_search01 extends Fragment {
    private List<Supermarket> supermarketList = new ArrayList<Supermarket>();
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //引用创建好的xml布局
        View view = inflater.inflate(R.layout.fragment_main02,container,false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }
    private void initView() {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.SupermarketRecycle);
        initSupermarkets();

    }
    private void initSupermarkets() {
        request();
    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.path)) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<Supermarket1> call = request.getCall("山东省-泰安市-泰山区");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Supermarket1>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<Supermarket1> call, Response<Supermarket1> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                Log.d(TAG, "onResponse: "+response.body().getSupermarkets().get(0).getAddres()+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                for(Supermarket supermarket0:response.body().getSupermarkets()){
                    supermarketList.add(supermarket0);
                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                SupermarketAdapter adapter = new SupermarketAdapter(supermarketList);
                recyclerView.setAdapter(adapter);
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Supermarket1> call, Throwable throwable) {
                System.out.println("请求失败");
                System.out.println(throwable.getMessage());
            }
        });
    }
}
