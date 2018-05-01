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

/**
 * Created by Administrator on 2018/3/17.
 */

public class Fragment_mian02 extends Fragment {
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
        //initEvent();
    }
    private void initView() {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.SupermarketRecycle);
        initSupermarkets();
        //StaggeredGridLayoutManager layoutManager = new
           //     StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

    }
    /*Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result = "";
            if ("OK".equals(msg.obj.toString())){
                result = msg.obj.toString();
            }else if ("Wrong".equals(msg.obj.toString())){
                Toast.makeText(getActivity(), "没有找到超市", Toast.LENGTH_SHORT).show();
            }else {
                result = msg.obj.toString();
                Log.d(TAG, "handleMessage:@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+result);
                try {
                    JSONObject  bigObj = new JSONObject(result);
                    JSONArray jsonArray = bigObj.getJSONArray("Supermarkets");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        if (jsonObject != null) {
                            String account = jsonObject.optString("account");
                            String name_s = jsonObject.optString("name_s");
                            double mark = jsonObject.optDouble("mark");
                            String address = jsonObject.optString("addres");
                            // 封装Java对象
                            Supermarket supermarket = new Supermarket(account,name_s,address,mark);
                            supermarketList.add(supermarket);
                        }
                    }

                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    SupermarketAdapter adapter = new SupermarketAdapter(supermarketList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    };*/
    private void initSupermarkets() {
            /*Supermarket apple = new Supermarket("大润发泰安店","东岳大街82号", (float) 9.2);
            supermarketList.add(apple);
            Supermarket banana = new Supermarket("好朋友超市","山东农业大学北校区", (float) 9.5);
            supermarketList.add(banana);
            Supermarket orange = new Supermarket("农大商贸中心","山东农业大学北校区", (float) 8.9);
            supermarketList.add(orange);*/
        String city ="山东省-泰安市-泰山区";
        request();
        /*HashMap<String, String> params = new HashMap<String, String>();
        params.put("city", city);
        try {
            //构造完整URL
            String path  = getResources().getString(R.string.path)+"GetSupermarketbyCity_Servlet";
            String compeletedURL = HttpUtil.getURLWithParams(path, params);
            //发送请求
            HttpUtil.sendHttpRequest(compeletedURL, new HttpCallbackListener() {
                @Override
                public void onFinish(String response) {
                    Message message = new Message();
                    message.obj = response;
                    mHandler.sendMessage(message);
                }

                @Override
                public void onError(Exception e) {
                    Message message = new Message();
                    message.obj = e.toString();
                    mHandler.sendMessage(message);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }*/
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