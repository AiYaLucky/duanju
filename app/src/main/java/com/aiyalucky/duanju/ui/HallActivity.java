package com.aiyalucky.duanju.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    GridLayout gridTuiJian;
    GridLayout gridSuiJi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        refresh = findViewById(R.id.swipeRefresh);
        banner = findViewById(R.id.banner);
        indicator = findViewById(R.id.indicator);
        gridTuiJian = findViewById(R.id.tuijian);
        gridSuiJi = findViewById(R.id.suiji);
        initBanner();
//        initItemList();
    }

    /**
     * 初始化视频展示内容列表【直接使用布局即可，这个弃用】
     */
    public void initItemList() {
        RelativeLayout relative = new RelativeLayout(this);
        RelativeLayout.LayoutParams relativeParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 90);
        relativeParam.topMargin = 60;
        relativeParam.addRule(RelativeLayout.BELOW, 1);
        int relativeId = 11;
        relative.setId(relativeId);
        relative.setLayoutParams(relativeParam);

        //增加类别文本
        TextView title = new TextView(this);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        titleParams.rightMargin = 40;
        title.setTextSize(16);
        title.setText("推 荐");
        title.setBackgroundColor(getResources().getColor(R.color.blue_slow));
        title.setGravity(Gravity.CENTER);
        relative.addView(title);

        //增加相应的刷新按钮
        TextView flash = new TextView(this);
        RelativeLayout.LayoutParams flashParams = new RelativeLayout.LayoutParams(200, RelativeLayout.LayoutParams.MATCH_PARENT);
        flash.setText("刷 新");
        flashParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        flashParams.rightMargin = 40;
        flash.setGravity(Gravity.CENTER);
        flash.setBackgroundColor(getResources().getColor(R.color.blue_slow));
        flash.setTextSize(16);
        flash.setLayoutParams(flashParams);
        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里是按钮点击之后要处理的操作
            }
        });
        relative.addView(flash);

        //最后在布局上增加这个创建的布局内容
        refresh.addView(relative);
    }

    /**
     * banner轮播图
     */
    private void initBanner() {
//        if (banner == null) {
//            banner = new Banner(this);
//        }
//        int bannerid = 1;
//        banner.setId(bannerid);
//        Banner.LayoutParams bannerParams = new Banner.LayoutParams(Banner.LayoutParams.MATCH_PARENT, 600);
//        bannerParams.topMargin = 60;
//        banner.setLayoutParams(bannerParams);
//        refresh.addView(banner);

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