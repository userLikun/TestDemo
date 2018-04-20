package com.ane.testdemo.recyclerView;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ane.testdemo.R;
import com.ane.testdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewActivity extends BaseActivity {
    @BindView(R.id.wrap_recycleview)
    WrapRecyclerView mView;
    private List<String> mParames;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        mParames = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            mParames.add("mParames" + i);
        }
        mAdapter = new RecyclerViewAdapter();
        mView.setAdapter(mAdapter);
        mView.setLayoutManager(new LinearLayoutManager(this));
        View headerView = LayoutInflater.from(this).inflate(R.layout.item_header_layout, mView, false);
        mView.addHeaderView(headerView);
        View footerView = LayoutInflater.from(this).inflate(R.layout.item_footer_layout, mView, false);
        mView.addFooterView(footerView);
    }

    @Override
    public void initView() {

    }

    @Override
    public int getContentViewId() {
        return 0;
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(RecycleViewActivity.this).
                    inflate(R.layout.item_recycleview_layout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(mParames.get(position));
        }

        @Override
        public int getItemCount() {
            return mParames == null ? 0 : mParames.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.textview);
            }
        }
    }
}
