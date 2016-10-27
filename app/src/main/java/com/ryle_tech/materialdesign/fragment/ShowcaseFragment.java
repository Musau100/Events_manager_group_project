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
import com.ryle_tech.materialdesign.Activity.FullscreenActivity;
import com.ryle_tech.materialdesign.R;

/**
 * Created by muus on 6/16/2016.
 */
public class ShowcaseFragment extends Fragment implements View.OnClickListener {


   private Button trailer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_showcase, container, false);
    }
    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        MaterialViewPagerHelper.registerScrollView(getActivity(), (ObservableScrollView) view.findViewById(R.id.showcase), null);

        trailer = (Button) view.findViewById(R.id.trailer);
        trailer.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(),FullscreenActivity.class));
    }
}
