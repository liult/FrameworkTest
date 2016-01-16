package com.liult.com.myframework.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.extras.com.pullToRefresh.PtrClassicFrameLayout;
import com.extras.com.pullToRefresh.PtrDefaultHandler;
import com.extras.com.pullToRefresh.PtrFrameLayout;
import com.extras.com.pullToRefresh.PtrHandler;
import com.extras.com.pullToRefresh.header.MaterialHeader;
import com.liult.com.myframework.R;
import com.liult.com.myframework.adapter.MineRecyclerAdapter;
import com.liult.com.myframework.base.BaseFragment;
import com.liult.com.myframework.utils.DataUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhilian-2 on 2016/1/7.
 */
public class MineFragment extends BaseFragment {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.material_style_ptr_frame)
    PtrFrameLayout mPtrFrameLayout;

    MineRecyclerAdapter mMineRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, view);
        mMineRecyclerAdapter = new MineRecyclerAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mMineRecyclerAdapter);

        // header
        final MaterialHeader header = new MaterialHeader(getContext());
        int[] colors = getResources().getIntArray(R.array.google_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, DataUtil.dp2px(15), 0, DataUtil.dp2px(10));
        header.setPtrFrameLayout(mPtrFrameLayout);

        mPtrFrameLayout.setLoadingMinTime(1000);
        mPtrFrameLayout.setDurationToCloseHeader(1500);
        mPtrFrameLayout.setHeaderView(header);
        mPtrFrameLayout.addPtrUIHandler(header);
        mPtrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrameLayout.autoRefresh(false);
            }
        }, 100);

        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return true;
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                    long delay = (long) (1000 + Math.random() * 2000);
                    delay = Math.max(0, delay);
                    delay = 0;
                    frame.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            frame.refreshComplete();
                        }
                    }, delay);
            }
        });
        return view;
    }

}
