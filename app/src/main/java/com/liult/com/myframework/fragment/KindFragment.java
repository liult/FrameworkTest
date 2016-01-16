package com.liult.com.myframework.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.extras.com.alertview.AlertView;
import com.extras.com.alertview.OnDismissListener;
import com.extras.com.alertview.OnItemClickListener;
import com.liult.com.myframework.R;
import com.liult.com.myframework.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Notification;

/**
 * Created by zhilian-2 on 2016/1/7.
 */
public class KindFragment extends BaseFragment implements View.OnClickListener, OnItemClickListener, OnDismissListener {


    Button btn1;
    private AlertView mAlertView;//避免创建重复View，先创建View，然后需要的时候show出来，推荐这个做法
    private AlertView mAlertViewExt;//窗口拓展例子
    private EditText etName;//拓展View内容
    private InputMethodManager imm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kind, container, false);
        ButterKnife.bind(this, view);
        imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mAlertView = new AlertView("标题", "内容", "取消", new String[]{"确定"},
                null, getActivity(), AlertView.Style.Alert, this)
                .setCancelable(false)
                .setOnDismissListener(this);
        //拓展窗口
        mAlertViewExt = new AlertView("提示", "请完善你的个人资料！", "取消",
                null, new String[]{"完成"}, getActivity(),
                AlertView.Style.Alert, this);
        ViewGroup extView = (ViewGroup) LayoutInflater.from(getActivity()).inflate(R.layout.alertext_form,null);
        etName = (EditText) extView.findViewById(R.id.etName);
        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                //输入框出来则往上移动
                boolean isOpen = imm.isActive();
                mAlertViewExt.setMarginBottom(isOpen && focus ? 120 : 0);
                System.out.println(isOpen);
            }
        });
        mAlertViewExt.addExtView(extView);
        btn1 = (Button) view.findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertView.show();
            }
        });
        return view;
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7})
    public void onWidgetClick(View view){
        switch (view.getId()){
            case R.id.btn_1:
                mAlertView.show();
                break;
            case R.id.btn_2:
                new AlertView("标题", "内容", null, new String[]{"确定"},
                        null, getActivity(), AlertView.Style.Alert, this).show();
                break;
            case R.id.btn_3:
                new AlertView(null, null, null, new String[]{"高亮按钮1", "高亮按钮2", "高亮按钮3"},
                        new String[]{"其他按钮1", "其他按钮2", "其他按钮3", "其他按钮4", "其他按钮5", "其他按钮6",
                                "其他按钮7", "其他按钮8", "其他按钮9", "其他按钮10", "其他按钮11", "其他按钮12"},
                        getActivity(), AlertView.Style.Alert, this).show();
                break;
            case R.id.btn_4:
                new AlertView("标题", null, "取消", new String[]{"高亮按钮1"},
                        new String[]{"其他按钮1", "其他按钮2", "其他按钮3"}, getActivity(),
                        AlertView.Style.ActionSheet, this).show();
                break;
            case R.id.btn_5:
                new AlertView("标题", "内容", "取消", null, null, getActivity(),
                        AlertView.Style.ActionSheet, this).setCancelable(true).show();
                break;
            case R.id.btn_6:
                new AlertView("上传头像", null, "取消", null,
                        new String[]{"拍照", "从相册中选择"},
                        getActivity(), AlertView.Style.ActionSheet, this).show();
                break;
            case R.id.btn_7:
                mAlertViewExt.show();
                break;
            default:
                break;
        }
    }

    private void closeKeyboard() {
        //关闭软键盘
        imm.hideSoftInputFromWindow(etName.getWindowToken(),0);
        //恢复位置
        mAlertViewExt.setMarginBottom(0);
    }
    @Override
    public void onItemClick(Object o,int position) {
        closeKeyboard();
        //判断是否是拓展窗口View，而且点击的是非取消按钮
        if(o == mAlertViewExt && position != AlertView.CANCELPOSITION){
            String name = etName.getText().toString();
            if(name.isEmpty()){
                Toast.makeText(getActivity(), "啥都没填呢", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getActivity(), "hello,"+name, Toast.LENGTH_SHORT).show();
            }

            return;
        }
        Toast.makeText(getActivity(), "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDismiss(Object o) {
        closeKeyboard();
        Toast.makeText(getActivity(), "消失了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }
}
