package com.gkshanmugavel.mobile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusBean {
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("msg")
    @Expose
    public String msg;
}
