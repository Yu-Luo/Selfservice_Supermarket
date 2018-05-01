package com.luo.selfservice_supermarket3.Connect;

/**
 * Created by Administrator on 2018/3/14.
 */

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
