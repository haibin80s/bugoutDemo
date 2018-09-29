package cn.testin.bugout.demo;

import android.app.Application;

import cn.testin.analysis.data.TestinDataApi;
import cn.testin.analysis.data.TestinDataConfig;

/**
 * Created by zhaohaibin on 2018/9/6.
 */

public class MyApplication extends Application {
    /**
     * 用户在Bugout平台创建应用时分配的应用标识
     */
    private final String APPKEY = "422b3752afb24835340b9ad2558206fc";

    @Override
    public void onCreate() {
        super.onCreate();
        TestinDataConfig testinDataConfig = new TestinDataConfig()
                .collectCrash(true)//设置收集crash异常
                .collectANR(true)//设置收集ANR异常
                .collectNDKCrash(true)//收集NDK异常，需集成bugout-ndk
                .collectUserSteps(true)//设置收集用户操作步骤，需在activity添加相关回调，详见baseActivity
                .collectLogCat(true)//设置收集logCat日志
                .setScreenshot(true)
                .setShakeSpeed(1500)//设置摇一摇触发阈值，默认1500，数值越低越灵敏
                .openShake(true);//打开摇一摇反馈bug功能
        TestinDataApi.init(this, APPKEY, testinDataConfig);
        loadCrashTest();
    }

    private void loadCrashTest() {
        try {
            System.loadLibrary("crashtest");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
