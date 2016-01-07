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

    @OnClick(R.id.btn)
    public void onWidgetClick(){
        getActivity().startActivity(new Intent(getActivity(), ItemListActivity.class));
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
