package com.ane.testdemo.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/3/21.
 */

public class WrapRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final RecyclerView.Adapter mRealAdapter;
    ArrayList<View> mHeaderViews;
    ArrayList<View> mFooterViews;

    public WrapRecyclerViewAdapter(RecyclerView.Adapter adapter) {
        mRealAdapter = adapter;
        mHeaderViews = new ArrayList<>();
        mFooterViews = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        int numHeads = getHeaderCount();
        if(position < numHeads) {
            return onCreateViewHolder(mHeaderViews.get(position));
        }
        final int data = position - numHeads;
        int adapterCount = 0;
        if(mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if(data < adapterCount) {
                return mRealAdapter.onCreateViewHolder(parent, mRealAdapter.getItemViewType(position));
            }
        }
        return onCreateViewHolder(mFooterViews.get(data - adapterCount));
    }

    @Override
    public int getItemViewType(int position) {
        // 把位置作为 viewType
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int numHeads = getHeaderCount();
        if(position < numHeads) {
            return;
        }
        final int data = position - numHeads;
        int adapterCount = 0;
        if(mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if(data < adapterCount) {
                mRealAdapter.onBindViewHolder(holder, position);
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(View view) {
        return new RecyclerView.ViewHolder(view){};
    }

    @Override
    public int getItemCount() {
        return getFooterCount()+getHeaderCount()+mRealAdapter.getItemCount();
    }

    public int getHeaderCount() {
        return mHeaderViews.size();
    }

    public int getFooterCount() {
        return mFooterViews.size();
    }

    public void addHeaderView(View view) {
        if(!mHeaderViews.contains(view)) {
            mHeaderViews.add(view);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        if(!mFooterViews.contains(view)) {
            mFooterViews.add(view);
            notifyDataSetChanged();
        }
    }

    public void removeHeaderView(View view) {
        if(mHeaderViews.contains(view)) {
            mHeaderViews.remove(view);
            notifyDataSetChanged();
        }
    }

    public void removeFooterView(View view) {
        if(mFooterViews.contains(view)) {
            mFooterViews.remove(view);
            notifyDataSetChanged();
        }
    }
}
