package com.liult.com.myframework.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liult.com.myframework.R;
import com.liult.com.myframework.base.BaseFragment;

/**
 * Created by zhilian-2 on 2016/1/7.
 */
public class KindFragment extends BaseFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kind, container, false);
       view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getActivity(), "lind", Toast.LENGTH_SHORT).show();
           }
       });
        getActivity();
        return view;
    }
}
