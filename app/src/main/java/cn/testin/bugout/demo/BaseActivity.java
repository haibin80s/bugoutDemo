package cn.testin.bugout.demo;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import cn.testin.analysis.bug.BugOutApi;

/**
 * 在app项目的 Activity基类（或所有的 Activity）中添加3个回调监听用户操作步骤：
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        //注：回调 1
        BugOutApi.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //注：回调 2
        BugOutApi.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //注：回调 3
        BugOutApi.onDispatchTouchEvent(this, event);
        return super.dispatchTouchEvent(event);
    }
}
