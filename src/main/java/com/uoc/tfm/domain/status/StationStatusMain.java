package com.uoc.tfm.domain.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationStatusMain {

    private long totalCount;
    private List<StationStatus> result;

    public StationStatusMain(){

    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<StationStatus> getResult() {
        return result;
    }

    public void setResult(List<StationStatus> result) {
        this.result = result;
    }
}