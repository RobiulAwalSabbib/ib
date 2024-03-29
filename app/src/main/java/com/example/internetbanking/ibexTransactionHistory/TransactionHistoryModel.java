package com.example.internetbanking.ibexTransactionHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionHistoryModel {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("hasMore")
    @Expose
    private Boolean hasMore;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;

    public TransactionHistoryModel(List<Item> items, Boolean hasMore, Integer limit, Integer offset, Integer count, List<Link> links) {
        this.items = items;
        this.hasMore = hasMore;
        this.limit = limit;
        this.offset = offset;
        this.count = count;
        this.links = links;
    }

    public TransactionHistoryModel(String s, String s1, String s2, String s3, String s4, String s5, String s6) {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
