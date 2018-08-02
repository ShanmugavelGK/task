package com.gkshanmugavel.mobile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserBean {
    @SerializedName("panicId")
    @Expose
    public Integer panicId;
    @SerializedName("notes")
    @Expose
    public String notes;
    @SerializedName("created_On")
    @Expose
    public String createdOn;
    @SerializedName("latitude")
    @Expose
    public String latitude;
    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("active")
    @Expose
    public Boolean active;
    @SerializedName("watchlist")
    @Expose
    public Boolean watchlist;
    @SerializedName("read")
    @Expose
    public Boolean read;
    @SerializedName("fileType")
    @Expose
    public String fileType;
    @SerializedName("fileUrl")
    @Expose
    public String fileUrl;
    @SerializedName("deleted")
    @Expose
    public Boolean deleted;
    @SerializedName("ratio")
    @Expose
    public String ratio;
    @SerializedName("thumbnailUrl")
    @Expose
    public String thumbnailUrl;
    @SerializedName("mywatchlist")
    @Expose
    public Boolean mywatchlist;
    @SerializedName("commentCount")
    @Expose
    public Integer commentCount;
    @SerializedName("smallUrl")
    @Expose
    public String smallUrl;
    @SerializedName("largeUrl")
    @Expose
    public String largeUrl;

    @SerializedName("userId")
    @Expose
    public UserIdBean userIdBean;

    public boolean isClicked = false;
    public int month = 0;
}
