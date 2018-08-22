package com.sbschoolcode.xyzreader.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.sbschoolcode.xyzreader.R;
import com.sbschoolcode.xyzreader.data.ItemsContract;

public class DetailActivity extends AppCompatActivity {

    private long mItemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        //Clear system bar hack
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        if (savedInstanceState == null) {
            if (getIntent() != null && getIntent().getData() != null) {
                mItemId = ItemsContract.Items.getItemId(getIntent().getData());
                updateFragmentData(mItemId);
            }
        }
    }

    private void updateFragmentData(long itemId) {
        DetailActivityFragment detailFragment = (DetailActivityFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        detailFragment.refreshData(itemId);
    }
}
