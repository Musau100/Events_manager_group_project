package com.ryle_tech.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryle_tech.materialdesign.R;
import com.ryle_tech.materialdesign.data.Series;
import com.ryle_tech.materialdesign.Activity.SeriesActivity;

import java.util.ArrayList;

/**
 * Created by muus on 7/13/2016.
 */
public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder> {

    ArrayList<Series> seriesData = new ArrayList<>();
    Context context;

    public SeriesAdapter(SeriesActivity context, ArrayList<Series> seriesData) {
        this.seriesData = seriesData;
        this.context = context;
    }

    @Override
    public SeriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_designer, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
 Series series = seriesData.get(position);
        System.out.println("Adapter series = "+series.toString());

        holder.seriesName.setText(series.getSeriesName());
        holder.seriesDescription.setText(series.getSeriesDescription());
    }

    @Override
    public int getItemCount() {
        return seriesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView seriesName, seriesDescription;

        public ViewHolder(View view) {
            super(view);
            seriesName = (TextView) view.findViewById(R.id.designerName);
            seriesDescription = (TextView) view.findViewById(R.id.description);
        }
    }


//    public SeriesAdapter(SeriesActivity seriesActivity, ArrayList<Series> seriesArrayList) {
//    }
}
