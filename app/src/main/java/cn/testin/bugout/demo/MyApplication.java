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
    private final String APPKEY = "b24efd3883acc5254cb5b175918d6f57";

    @Override
    public void onCreate() {
        super.onCreate();
        TestinDataConfig testinDataConfig = new TestinDataConfig()
                .collectCrash(true)//设置收集crash异常
                .collectANR(true)//设置收集ANR异常
                .collectUserSteps(true)//设置收集用户操作步骤，需在activity添加相关回调，详见baseActivity
                .collectLogCat(true)//设置收集logCat日志
                .setShakeSpeed(1500)//设置摇一摇触发阈值，默认1500，数值越低越灵敏
                .openShake(true);//打开摇一摇反馈bug功能
        TestinDataApi.init(this, APPKEY, testinDataConfig);
    }
}
