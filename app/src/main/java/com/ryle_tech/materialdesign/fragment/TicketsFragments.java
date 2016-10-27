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
import com.ryle_tech.materialdesign.Activity.Feeds;
import com.ryle_tech.materialdesign.R;

//import android.support.annotation.Nullable;

/**
 * Created by muus on 6/15/2016.
 */
public class TicketsFragments extends Fragment implements View.OnClickListener{

    private Button alltickets, movies, series, sports;

    public TicketsFragments(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_ticket, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialViewPagerHelper.registerScrollView(getActivity(), (ObservableScrollView) view.findViewById(R.id.ticketView), null);

        alltickets = (Button)view.findViewById(R.id.all);
        movies = (Button)view.findViewById(R.id.movies);
       series = (Button)view.findViewById(R.id.events);
        sports = (Button)view.findViewById(R.id.sports);


        alltickets.setOnClickListener(this);
        movies.setOnClickListener(this);
        series.setOnClickListener(this);
        sports.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.all:
                  startActivity(new Intent(getActivity(), Feeds.class));
//                Toast.makeText( getActivity(), "Shows All series list", Toast.LENGTH_SHORT).show();
                break;
            case R.id.movies:
                startActivity(new Intent(getActivity(), Feeds.class));
//                Toast.makeText(getActivity(), "Shows All Movies list", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.events:
                startActivity(new Intent(getActivity(), Feeds.class));

//                Toast.makeText( getActivity(), "Shows Events List",  Toast.LENGTH_SHORT).show();
            break;
            case R.id.sports:
                startActivity(new Intent(getActivity(), Feeds.class));
//                Toast.makeText( getActivity(), "Shows Sports List",  Toast.LENGTH_SHORT).show();

        }
    }


}
