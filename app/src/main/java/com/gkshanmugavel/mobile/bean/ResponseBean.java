package com.gkshanmugavel.mobile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBean {
    @SerializedName("status")
    @Expose
    public StatusBean status;
    @SerializedName("_entity")
    @Expose
    public List<UserBean> entity = null;
}
