package com.luo.selfservice_supermarket3.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luo.selfservice_supermarket3.Class.Supermarket;
import com.luo.selfservice_supermarket3.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.luo.selfservice_supermarket3.MainActivity.mContext;

public class SupermarketAdapter extends RecyclerView.Adapter<SupermarketAdapter.ViewHolder>{

    private List<Supermarket> mSupermarketList;
    ViewHolder holder;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View SupermarketView;
        ImageView SupermarketImage;
        TextView SupermarketName;
        TextView SupermarketAddres;
        TextView SupermarketMark;


        public ViewHolder(View view) {
            super(view);
            SupermarketView = view;
            SupermarketImage = (ImageView) view.findViewById(R.id.smimage);
            SupermarketName = (TextView) view.findViewById(R.id.smname);
            SupermarketAddres = (TextView) view.findViewById(R.id.smaddres);
            SupermarketMark = (TextView) view.findViewById(R.id.smmark);
        }
    }

    public SupermarketAdapter(List<Supermarket> SupermarketList) {
        mSupermarketList = SupermarketList;
    }


   /* Handler handler = new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            //更新UI
            holder.SupermarketImage.setImageBitmap((Bitmap) msg.obj);
        };
    };*/
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.supermarket_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.SupermarketView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Supermarket Supermarket = mSupermarketList.get(position);
                //Toast.makeText(v.getContext(), "you clicked view " + Supermarket.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.SupermarketImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Supermarket Supermarket = mSupermarketList.get(position);
                //Toast.makeText(v.getContext(), "you clicked image " + Supermarket.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder0, int position) {
        Supermarket Supermarket = mSupermarketList.get(position);
        holder = holder0;
        holder.SupermarketName.setText(Supermarket.getName_s());
        holder.SupermarketAddres.setText(Supermarket.getAddres());
        holder.SupermarketMark.setText(String.valueOf(Supermarket.getMark()));
        String strURL = mContext.getResources().getString(R.string.path)+"smhead/"+Supermarket.getAccount()+".jpg";
        Log.d(TAG, "onBindViewHolder: "+strURL+"((((((((((((((((((((((((((((((((((((((((((((((((");
        Picasso.with(mContext).load(strURL).into((holder).SupermarketImage);
/*        try {
            Bitmap bitmap = getBitmap(strURL);
            Message msg = handler.obtainMessage();
            msg.obj = bitmap;
            handler.sendMessage(msg);
            //headimg.setImageBitmap(bitmap);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

    @Override
    public int getItemCount() {
        return mSupermarketList.size();
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