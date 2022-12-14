package com.aiyalucky.duanju;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aiyalucky.duanju.ui.HallActivity;
import com.aiyalucky.duanju.ui.LoginActivity;
import com.aiyalucky.duanju.utils.DelayUtils;
import com.blankj.utilcode.util.ActivityUtils;

import me.goldze.mvvmhabit.base.BaseApplication;
import me.goldze.mvvmhabit.crash.CaocConfig;
import me.goldze.mvvmhabit.utils.KLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseApplication.setApplication(getApplication());

        //是否开启日志打印
        KLog.init(true);
        //配置全局异常崩溃操作
        CaocConfig.Builder.create().backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(true) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .errorDrawable(R.mipmap.ic_launcher) //错误图标
                .restartActivity(MainActivity.class) //重新启动后的activity
                //.errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
                //.eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();

        //3s之后跳转到登录界面
        DelayUtils.delayStartActivity(this, LoginActivity.class, 3000);
    }
}