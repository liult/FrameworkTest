package com.liult.com.myframework.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.liult.com.myframework.R;
import com.liult.com.myframework.base.BaseFragment;
import com.liult.com.myframework.base.ItemListActivity;
import com.liult.com.myframework.base.Main2Activity;
import com.liult.com.myframework.base.ScrollingActivity;
import com.liult.com.myframework.base.SettingsActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhilian-2 on 2016/1/7.
 */
public class HomeFragment extends BaseFragment {



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.btn, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onWidgetClick(View view){
        switch (view.getId()){
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
//    @OnClick(R.id.btn)
//    public void onWidgetClick(View view) {
//        Toast.makeText(getActivity(), "hah ", Toast.LENGTH_SHORT).show();
//        getActivity().startActivity(new Intent(getActivity(), ItemListActivity.class));
//    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
