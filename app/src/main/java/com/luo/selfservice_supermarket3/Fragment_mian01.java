package com.luo.selfservice_supermarket3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.luo.selfservice_supermarket3.MainActivity.user;

/**
 * Created by Administrator on 2018/3/17.
 */

public class Fragment_mian01 extends Fragment {
    Button button_t3;
    TextView textView_t;
    ImageView headimg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //引用创建好的xml布局
        View view = inflater.inflate(R.layout.fragment_main01,container,false);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StrictMode.setThreadPolicy(new
                StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(
                new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        initView();
        initEvent();
    }

    private void initView() {
        button_t3 = (Button) getActivity().findViewById(R.id.test3);
        textView_t = (TextView) getActivity().findViewById(R.id.test_t2);
        headimg = (ImageView) getActivity().findViewById(R.id.headimage2);
    }
    private void initEvent() {
        button_t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_t.setText(user.getUserName());
                String strURL = "http://192.168.1.105:8080/Selfservice_Supermarket/head/yuluo123.jpg";
                try {
                    Bitmap bitmap = getBitmap(strURL);
                    headimg.setImageBitmap(bitmap);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    public Bitmap getBitmap(String path) throws IOException {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}



