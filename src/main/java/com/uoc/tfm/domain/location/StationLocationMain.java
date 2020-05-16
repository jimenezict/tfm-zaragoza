package com.uoc.tfm.domain.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class StationLocationMain {

    private long totalCount;
    private List<StationLocation> result;

    public StationLocationMain() {

    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<StationLocation> getResult() {
        return result;
    }

    public void setResult(List<StationLocation> result) {
        this.result = result;
    }
}