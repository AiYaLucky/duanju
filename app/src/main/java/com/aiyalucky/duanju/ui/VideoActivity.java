package com.aiyalucky.duanju.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.aiyalucky.duanju.CustomJzvd.JzvdStdVideo;
import com.aiyalucky.duanju.R;
import com.aiyalucky.duanju.video.OnViewPagerListener;
import com.aiyalucky.duanju.video.TikTokRecyclerViewAdapter;
import com.aiyalucky.duanju.video.ViewPagerLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;

public class VideoActivity extends AppCompatActivity {
    private RecyclerView rvTiktok;
    private TikTokRecyclerViewAdapter mAdapter;
    private ViewPagerLayoutManager mViewPagerLayoutManager;
    private int mCurrentPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video);
        rvTiktok = findViewById(R.id.rev_video);

        mAdapter = new TikTokRecyclerViewAdapter(this);
        mViewPagerLayoutManager = new ViewPagerLayoutManager(this, OrientationHelper.VERTICAL);
        rvTiktok.setLayoutManager(mViewPagerLayoutManager);
        rvTiktok.setAdapter(mAdapter);

        //滑动监听器
        mViewPagerLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {
                //自动播放第一条
                autoPlayVideo(0);
            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                if (mCurrentPosition == position) {
//                    Jzvd.releaseAllVideos();
                }
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {
                if (mCurrentPosition == position) {
                    return;
                }
                autoPlayVideo(position);
                mCurrentPosition = position;
            }
        });

        rvTiktok.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                Jzvd jzvd = view.findViewById(R.id.videoplayer);
                if (jzvd != null && Jzvd.CURRENT_JZVD != null && jzvd.jzDataSource != null &&
                        jzvd.jzDataSource.containsTheUrl(Jzvd.CURRENT_JZVD.jzDataSource.getCurrentUrl())) {
                    if (Jzvd.CURRENT_JZVD != null && Jzvd.CURRENT_JZVD.screen != Jzvd.SCREEN_FULLSCREEN) {
//                        Jzvd.releaseAllVideos();
                    }
                }
            }
        });
    }

    private void autoPlayVideo(int postion) {
        if (rvTiktok == null || rvTiktok.getChildAt(0) == null) {
            return;
        }
        JzvdStdVideo player = rvTiktok.getChildAt(0).findViewById(R.id.videoplayer);
        if (player != null) {
            player.startVideoAfterPreloading();
        }
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * 剧集选择界面
     * @param view textview
     */
    public void onVideoList(View view){
        List<String> itmes = new ArrayList<>();
        itmes.add("替嫁娇妻 1");
        itmes.add("替嫁娇妻 2");
        itmes.add("替嫁娇妻 3");
        itmes.add("替嫁娇妻 4");
        itmes.add("替嫁娇妻 5");
        itmes.add("替嫁娇妻 6");
        itmes.add("替嫁娇妻 7");
        itmes.add("替嫁娇妻 8");
        itmes.add("替嫁娇妻 9");
        itmes.add("替嫁娇妻 10");
        String[] array = new String[0];
        AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
        alBuilder.setItems(itmes.toArray(array), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println(dialog);
                System.out.println(which);
            }
        });
        AlertDialog dialog = alBuilder.create();
        dialog.setTitle("替嫁娇妻title");
        dialog.show();
    }
}