package com.example.administrator.fuckgank.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class SearchBean {
    private int count;
    private boolean error;
    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean extends BaseBean{
    }

    public List<BaseBean> getGankList(){
        List<BaseBean> result = new ArrayList<>();
        result.addAll(results);
        return result;
    }
}
