package com.nuc.myapp.activity;

import android.os.Bundle;
import com.nuc.myapp.R;

public class HomeActivity extends BaseActivity {

    private String[] mTtiles = {"首页","收藏","我的"};
    private int[] mIconSelectIds = {R.mipmap.collect_select,
            R.mipmap.collect_unselect,
            R.mipmap.home_selected,
            R.mipmap.home_unselect,
            R.mipmap.my_selected,
            R.mipmap.my_unselect
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
