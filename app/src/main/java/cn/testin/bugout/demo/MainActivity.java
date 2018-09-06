package cn.testin.bugout.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.testin.analysis.bug.BugOutApi;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btnNullPointExp;
    private Button btnZeroExp;
    private Button btnIndexExp;
    private Button btnCustomExp;
    private Button btnANRExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNullPointExp = findViewById(R.id.btn_null_exp);
        btnZeroExp = findViewById(R.id.btn_zero_exp);
        btnIndexExp = findViewById(R.id.btn_index_exp);
        btnCustomExp = findViewById(R.id.btn_custom_exp);
        btnANRExp = findViewById(R.id.btn_anr_exp);

        btnNullPointExp.setOnClickListener(this);
        btnZeroExp.setOnClickListener(this);
        btnIndexExp.setOnClickListener(this);
        btnCustomExp.setOnClickListener(this);
        btnANRExp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_null_exp:
                testNullPointException();
                break;
            case R.id.btn_zero_exp:
                testArithmeticException();
                break;
            case R.id.btn_index_exp:
                testArrayIndexOutOfBoundsException();
                break;
            case R.id.btn_custom_exp:
                testCustomExp();
                break;
            case R.id.btn_anr_exp:
                testANRExp();
                break;
        }
    }

    private void testNullPointException() {
        String a = null;
        Log.e("bugout", a);
    }

    private void testArithmeticException() {
        int a = 5 / 0;
    }

    private void testArrayIndexOutOfBoundsException() {
        int[] a = new int[2];
        int b = a[2];
    }

    private void testCustomExp() {
        BugOutApi.reportException(new Exception("this is a custom exception"));
    }

    private void testANRExp() {
        while (true) {

        }
    }
}
