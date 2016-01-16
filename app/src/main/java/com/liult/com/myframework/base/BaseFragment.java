package com.liult.com.myframework.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.extras.com.progress.SVProgressHUD;
import com.liult.com.myframework.R;
import com.liult.com.myframework.appInterface.AppBaseInterface;
import com.liult.com.myframework.utils.DataUtil;

import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * fragment 基类
 * Created by zhilian-2 on 2016/1/7.
 */
public class BaseFragment extends Fragment implements AppBaseInterface {

    private SVProgressHUD mSVProgressHUD;
    private TextView leftTv, titleTv, rightTv;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initTitle(View view, int leftImageResourceId, String leftText,
                          String title, int rightImageResourceId, String rightText){
        leftTv = (TextView) view.findViewById(R.id.left_tv);
        titleTv = (TextView) view.findViewById(R.id.title_tv);
        rightTv = (TextView) view.findViewById(R.id.right_tv);
        if (leftTv == null || titleTv == null || rightTv == null) return;
        //中间文字设置
        if (!DataUtil.isEmpty(title)) {
            titleTv.setVisibility(View.VISIBLE);
            titleTv.setText(title);
        }else{
            titleTv.setVisibility(View.GONE);
        }
        //左部分图片文字设置
        if (leftImageResourceId <= 0 && DataUtil.isEmpty(leftText)){
            leftTv.setVisibility(View.GONE);
        }else {
            leftTv.setVisibility(View.VISIBLE);
            if (leftImageResourceId > 0){
                leftTv.setCompoundDrawablesWithIntrinsicBounds(leftImageResourceId, 0, 0, 0);
            }
            if (!DataUtil.isEmpty(leftText)){
                leftTv.setText(leftText);
            }
        }
        //右部分图片文字设置
        if (rightImageResourceId <= 0 && DataUtil.isEmpty(rightText)){
            rightTv.setVisibility(View.GONE);
        }else {
            rightTv.setVisibility(View.VISIBLE);
            if (rightImageResourceId > 0){
                rightTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, rightImageResourceId);
            }
            if (!DataUtil.isEmpty(rightText)){
                rightTv.setText(rightText);
            }
        }
        leftTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showMaterialProgress(String text) {
        if (!isAdded()) return;
        if (mSVProgressHUD == null)
            mSVProgressHUD= new SVProgressHUD(getActivity());
        mSVProgressHUD.showMaterialishProgress(text);
    }

    @Override
    public void hideMaterialProgress() {
        if (mSVProgressHUD == null) return;
        mSVProgressHUD.dismissImmediately();
    }

    @Override
    public View getDivTitleLeftView() {
        return leftTv;
    }

    @Override
    public View getDivTitleRightView() {
        return rightTv;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
    @Override
    public void onResponse(Response response, Retrofit retrofit) {

    }

    @Override
    public void onFailure(Throwable t) {

    }

}
