package com.aiyalucky.duanju.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.aiyalucky.duanju.CustomJzvd.JzvdStdVideo;
import com.aiyalucky.duanju.R;
import com.bumptech.glide.Glide;


import cn.jzvd.JZDataSource;
import cn.jzvd.Jzvd;

public class TikTokRecyclerViewAdapter extends RecyclerView.Adapter<TikTokRecyclerViewAdapter.MyViewHolder> {

    public static final String TAG = "AdapterTikTokRecyclerView";
    int[] videoIndexs = {0, 1, 2, 3, 4, 5};
    private Context context;

    public TikTokRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_video, parent,
                false));
        return holder;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder [" + holder.jzvdStd.hashCode() + "] position=" + position);

        //设置播放数据
        String url = "http://www.aiyalucky.com/tjjq.mp4";
        String title = "替嫁娇妻";
        JZDataSource jzDataSource = new JZDataSource(url,title);
        //是否循环播放
        jzDataSource.looping = true;
        holder.jzvdStd.setUp(jzDataSource, Jzvd.SCREEN_NORMAL);
        String image = "https://pics3.baidu.com/feed/cf1b9d16fdfaaf51055aeb850e4a2de7f01f7a73.jpeg";
        Glide.with(holder.jzvdStd.getContext()).load(image).into(holder.jzvdStd.posterImageView);
    }

    @Override
    public int getItemCount() {
        return videoIndexs.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        JzvdStdVideo jzvdStd;

        public MyViewHolder(View itemView) {
            super(itemView);
            jzvdStd = itemView.findViewById(R.id.videoplayer);
        }
    }

}
