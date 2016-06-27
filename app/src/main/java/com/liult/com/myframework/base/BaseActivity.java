package com.liult.com.myframework.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.extras.com.utils.DataUtil;
import com.liult.com.myframework.R;
import com.liult.com.myframework.appInterface.AppBaseInterface;
import com.liult.com.myframework.utils.UiUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import retrofit2.Call;
import retrofit2.Response;


public class BaseActivity extends AppCompatActivity implements AppBaseInterface{

    private TextView leftTv, titleTv, rightTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSystemBarColor();
    }


    public void setSystemBarColor() {
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        // 创建状态栏的管理实例
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // 激活状态栏设置
        tintManager.setStatusBarTintEnabled(true);
        // 激活导航栏设置
        tintManager.setNavigationBarTintEnabled(true);
        // 设置一个颜色给系统栏
        tintManager.setStatusBarTintColor(Color.parseColor("#ff5a1e"));
    }

    @Override
    public void initTitle(View view, int leftImageResourceId, String leftText, String title, int rightImageResourceId, String rightText) {
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
                UiUtil.showToast(BaseActivity.this, "click");
            }
        });
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
    public void showMaterialProgress(String text) {

    }

    @Override
    public void hideMaterialProgress() {

    }

    @Override
    public void onResponse(Call call, Response response) {

    }

    @Override
    public void onFailure(Call call, Throwable t) {

    }
}
