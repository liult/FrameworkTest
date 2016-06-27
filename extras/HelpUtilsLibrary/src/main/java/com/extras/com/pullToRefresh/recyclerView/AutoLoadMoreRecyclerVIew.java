package com.extras.com.pullToRefresh.recyclerView;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.extras.com.R;
import com.extras.com.utils.DensityUtils;

/**
 * Created by zhilian-2 on 2016/1/18.
 */
public class AutoLoadMoreRecyclerView extends RecyclerView {
    /**
     * Listener that will receive notifications every time the list scrolls.
     */

    private LayoutInflater mInflater;
    private Boolean isEnable = true;
    private Context mContext;

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean enable) {
        isEnable = enable;
    }

    private View mFooterView;

    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean mIsLoadingMore = false;
    private int mCurrentScrollState;
    private RecyclerView.OnScrollListener mOnScrollListener = new OnScrollListener() {
        /**
         * 禁止滑动 ，view重绘，否则导致闪烁
         */
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
            if (isEnable) {// 是否开启滑动
                mCurrentScrollState = scrollState;
            }
            super.onScrollStateChanged(recyclerView, scrollState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            Log.e("@@@@@@@@@@@", "onScrolled");
            int totalItemCount = getLayoutManager().getItemCount();
            int firstVisibleItem = ((LinearLayoutManager) getLayoutManager())
                    .findFirstVisibleItemPosition();
            int visibleItemCount = getLayoutManager().getChildCount();
            if (isEnable) {// 是否开启滑动
                showLoadMoreFooter();
                if (mOnScrollListener != null) {
                    super.onScrolled(recyclerView, dx, dy);
                }
                if (mOnLoadMoreListener != null) {
                    if (visibleItemCount == totalItemCount) {// 刚好铺满一个屏幕，
                        Log.e("@@@@@@@@@@@", "刚好铺满一个屏幕");
                        hideLoadMoreFooter();
                        return;
                    }
                    boolean loadMore = firstVisibleItem + visibleItemCount >= totalItemCount;// 滑动到底部
                    /**
                     * <code>(dy > 0)</code> check for scroll down
                     */
                    Log.e("@@@@@@@@@@@", "dy:" + dy + " !mIsLoadingMore:" + !mIsLoadingMore
                    + " last:" + (mCurrentScrollState != SCROLL_STATE_IDLE));
                    if (dy > 0 && !mIsLoadingMore && loadMore
                            && mCurrentScrollState != SCROLL_STATE_IDLE) { // 判断如果滚动到底部，并且已经停止滚动的时候，我们就显示底部加载更多。
                        showLoadMoreFooter();
                        mIsLoadingMore = true;
                        // 回调监听
                        onLoadMore();
                    }
                }
            }
        }
    };

    public AutoLoadMoreRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public AutoLoadMoreRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AutoLoadMoreRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

        mContext = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mFooterView = mInflater.inflate(
                R.layout.recyclerview_load_more_footer, null, false);// 加载底部view
        this.addOnScrollListener(mOnScrollListener);// 设置滚动监听
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        mOnLoadMoreListener = onLoadMoreListener;
    }

    public void onLoadMore() {
        if (mOnLoadMoreListener != null) {
            mOnLoadMoreListener.onLoadMore();
        }
    }
    public void onLoadMoreComplete() {
        mIsLoadingMore = false;
        hideLoadMoreFooter();
    }

    /**
     * Interface definition for a callback to be invoked when list reaches the
     * last item (the user load more items in the list)
     */
    public interface OnLoadMoreListener {
        /**
         * Called when the list reaches the last item (the last item is visible
         * to the user)
         */
        void onLoadMore();
    }

    private void hideLoadMoreFooter() {
        mFooterView.setVisibility(View.GONE);
        mFooterView.setPadding(0, -mFooterView.getHeight(), 0, 0);
    }

    private void showLoadMoreFooter() {
        mFooterView.setVisibility(View.VISIBLE);
        mFooterView.setPadding(0, DensityUtils.dp2px(mContext, 10), 0,
                DensityUtils.dp2px(mContext, 10));
    }

}
