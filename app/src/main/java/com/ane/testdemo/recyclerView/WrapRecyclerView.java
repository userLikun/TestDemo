package com.ane.testdemo.recyclerView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lenovo on 2018/3/21.
 */

public class WrapRecyclerView extends RecyclerView {
    private WrapRecyclerViewAdapter mAdapter;

    public WrapRecyclerView(Context context) {
        super(context);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
//        super.setAdapter(adapter);
        mAdapter = new WrapRecyclerViewAdapter(adapter);
        super.setAdapter(mAdapter);
    }

    public void addHeaderView(View view) {
        if(mAdapter != null) {
            mAdapter.addHeaderView(view);
        }
    }

    public void addFooterView(View view) {
        if(mAdapter != null) {
            mAdapter.addFooterView(view);
        }
    }

    public void removeHeaderView(View view) {
        if(mAdapter != null) {
            mAdapter.removeHeaderView(view);
        }
    }

    public void removeFooterView(View view) {
        if(mAdapter != null) {
            mAdapter.removeFooterView(view);
        }
    }
}
