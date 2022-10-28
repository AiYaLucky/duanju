package com.aiyalucky.duanju;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aiyalucky.duanju.ui.HallActivity;
import com.aiyalucky.duanju.ui.VideoActivity;
import com.aiyalucky.duanju.utils.DelayUtils;
import com.blankj.utilcode.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityUtils.startActivity(HallActivity.class);
    }
}