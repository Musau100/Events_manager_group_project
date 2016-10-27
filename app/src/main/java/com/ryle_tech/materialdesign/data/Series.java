package com.ryle_tech.materialdesign.data;

/**
 * Created by muus on 7/13/2016.
 */
public class Series {

    String seriesName,seriesDescription;

    public Series() {
        this.seriesName = seriesName;
        this.seriesDescription = seriesDescription;

    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }

    public void setSeriesDescription(String seriesDescription) {
        this.seriesDescription = seriesDescription;
    }
    @Override
    public String toString() {
        return "Series = "+getSeriesName()+" and Desc= "+getSeriesDescription();
    }
}
