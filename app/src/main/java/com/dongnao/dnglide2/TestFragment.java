package com.dongnao.dnglide2;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by Administrator on 2018/5/11.
 */

public class TestFragment extends Fragment {

    private static final String TAG = "TestFragment";

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
