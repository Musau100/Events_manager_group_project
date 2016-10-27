package com.ryle_tech.materialdesign.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.ryle_tech.materialdesign.Activity.LoginActivity;
import com.ryle_tech.materialdesign.R;
import com.ryle_tech.materialdesign.Activity.RegisterActivity;

/**
 * Created by muus on 6/15/2016.
 */
public class YouFragment extends Fragment implements View.OnClickListener {


    private Button login, register;

    public YouFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_you, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialViewPagerHelper.registerScrollView(getActivity(), (ObservableScrollView) view.findViewById(R.id.You), null);

        login = (Button)view.findViewById(R.id.Login);
        register = (Button)view.findViewById(R.id.Register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.Login:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.Register:
                startActivity(new Intent(getContext(), RegisterActivity.class));
        }

    }
}
