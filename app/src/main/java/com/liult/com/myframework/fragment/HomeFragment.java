package com.liult.com.myframework.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liult.com.myframework.R;
import com.liult.com.myframework.base.BaseFragment;
import com.liult.com.myframework.base.ItemListActivity;
import com.liult.com.myframework.base.Main2Activity;
import com.liult.com.myframework.base.ScrollingActivity;
import com.liult.com.myframework.base.SettingsActivity;
import com.liult.com.myframework.moudle.AppConfigs;
import com.liult.com.myframework.rest.RetrofitDataService;
import com.liult.com.myframework.utils.UiUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by zhilian-2 on 2016/1/7.
 */
public class HomeFragment extends BaseFragment{

    private String token = "a14ff3d45d7b21ede0917d3d91cbbd5c";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initTitle(view, R.drawable.icon_arrow_back, "FragmentHome", "FragmentHome", 0, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.btn, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn_service})
    public void onWidgetClick(View view){
        switch (view.getId()){
            case R.id.btn_service:
                showMaterialProgress("加载中...");
                Call<AppConfigs> response = RetrofitDataService.getInstance().mResetService.getAppConfig("test", token);
                response.enqueue(this);
                break;
            case R.id.btn:
                getActivity().startActivity(new Intent(getActivity(), ItemListActivity.class));
                break;
            case R.id.btn2:
                getActivity().startActivity(new Intent(getActivity(), Main2Activity.class));
                break;
            case R.id.btn3:
                getActivity().startActivity(new Intent(getActivity(), SettingsActivity.class));
                break;
            case R.id.btn4:
                getActivity().startActivity(new Intent(getActivity(), ScrollingActivity.class));
                break;
            default:
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onResponse(Response response) {
        super.onResponse(response);
        hideMaterialProgress();
        if (response.body() instanceof AppConfigs){
            Toast.makeText(getActivity(), "response:"+((AppConfigs)response.body()).app_config.getCustomer_service_tel(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure(Throwable t) {
        super.onFailure(t);
        hideMaterialProgress();
        UiUtil.showToast(getActivity(), "失败：" + t.getMessage());
    }
}
