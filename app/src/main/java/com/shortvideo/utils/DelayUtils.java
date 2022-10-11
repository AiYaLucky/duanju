package com.shortvideo.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/11 23:03
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class DelayUtils {

    /**
     * 延迟执行Activity跳转
     * @param context 当前页面上下文
     * @param cls   跳转目标页面
     * @param delayTime 延迟时间
     */
    public static void delayStartActivity(Context context, Class<?> cls, long delayTime) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(context, cls);
                context.startActivity(intent);
            }
        }, delayTime);
    }
}
