package com.aiyalucky.duanju.ui;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.aiyalucky.duanju.R;
import com.aiyalucky.duanju.bean.DataBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.util.BannerUtils;

public class HallActivity extends AppCompatActivity {
    Banner banner;
    RoundLinesIndicator indicator;
    RelativeLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        banner = findViewById(R.id.banner);
        indicator = findViewById(R.id.indicator);
        refresh = findViewById(R.id.swipeRefresh);

        initBanner();
    }

    private void initBanner() {
        banner.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getPictureData()) {
            @Override
            public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
                //图片加载自己实现
                Glide.with(holder.itemView).load(data.imageUrl).thumbnail(Glide.with(holder.itemView).load(R.drawable.ic_password_eye)).apply(RequestOptions.bitmapTransform(new RoundedCorners(30))).into(holder.imageView);
            }
        });
        banner.setIndicator(new RoundLinesIndicator(this));
        //设置指示器圆角
        banner.setIndicator(new CircleIndicator(this));
        //指示器宽度
        banner.setIndicatorSelectedWidth(BannerUtils.dp2px(12));
        //指示器居中
        banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);
        //设置指示器颜色
        banner.setIndicatorSelectedColorRes(R.color.blue);
        //设置banner圆角
        banner.setBannerRound2(20);
        refresh.setEnabled(true);


    }

}