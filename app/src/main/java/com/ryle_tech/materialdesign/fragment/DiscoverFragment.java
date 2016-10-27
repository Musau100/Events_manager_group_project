package com.ryle_tech.materialdesign.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.ryle_tech.materialdesign.Activity.Feeds;
import com.ryle_tech.materialdesign.R;

/**
 * Created by muus on 6/16/2016.
 */
public class DiscoverFragment extends Fragment implements View.OnClickListener {

    private Button comingsoon, recommended, feeds;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_discover, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialViewPagerHelper.registerScrollView(getActivity(), (ObservableScrollView) view.findViewById(R.id.discover), null);


        feeds = (Button)view.findViewById(R.id.feeds);
        comingsoon = (Button)view.findViewById(R.id.comingsoon);
        recommended = (Button)view.findViewById(R.id.recommended);

        feeds.setOnClickListener(this);
        recommended.setOnClickListener(this);
        comingsoon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.feeds:
//                  startActivity(new Intent(getContext(), Feeds.class));
                startActivity(new Intent(getActivity(), Feeds.class));

                Toast.makeText( getActivity(), "Shows Feeds List",  Toast.LENGTH_SHORT).show();
                break;
            case R.id.comingsoon:
                startActivity(new Intent(getActivity(), Feeds.class));

                Toast.makeText( getActivity(), "Shows ComingSoon List",  Toast.LENGTH_SHORT).show();
// startActivity(new Intent(getContext(), MoviesActivity.class));
                break;
            case  R.id.recommended:
                startActivity(new Intent(getActivity(), Feeds.class));

                Toast.makeText( getActivity(), "Shows Recommended List",  Toast.LENGTH_SHORT).show();

        }

    }
}
