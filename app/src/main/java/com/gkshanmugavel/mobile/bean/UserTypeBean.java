package com.gkshanmugavel.mobile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserTypeBean {
    @SerializedName("userTypeId")
    @Expose
    public Integer userTypeId;
    @SerializedName("userTypeName")
    @Expose
    public String userTypeName;
}
