package com.gkshanmugavel.mobile.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserIdBean {
    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("streetName")
    @Expose
    public String streetName;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("active")
    @Expose
    public Boolean active;
    @SerializedName("mobileNumber")
    @Expose
    public String mobileNumber;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("kinName")
    @Expose
    public String kinName;
    @SerializedName("kinPrimaryNumber")
    @Expose
    public String kinPrimaryNumber;
    @SerializedName("kinSecondaryNumber")
    @Expose
    public String kinSecondaryNumber;
    @SerializedName("securityPin")
    @Expose
    public String securityPin;
    @SerializedName("createdOn")
    @Expose
    public String createdOn;
    @SerializedName("userType")
    @Expose
    public UserTypeBean userType;
    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("userImage")
    @Expose
    public String userImage;
    @SerializedName("notificationStatus")
    @Expose
    public Boolean notificationStatus;
    @SerializedName("locationStatus")
    @Expose
    public Boolean locationStatus;
    @SerializedName("hideName")
    @Expose
    public Boolean hideName;
    @SerializedName("inviteFlag")
    @Expose
    public Boolean inviteFlag;
    @SerializedName("alertDistance")
    @Expose
    public String alertDistance;
    @SerializedName("countryCode")
    @Expose
    public String countryCode;
    @SerializedName("country")
    @Expose
    public Object country;
    @SerializedName("kinCountryCode")
    @Expose
    public Object kinCountryCode;
    @SerializedName("kinCountry")
    @Expose
    public Object kinCountry;
    @SerializedName("blocked")
    @Expose
    public Boolean blocked;
    @SerializedName("activation_link")
    @Expose
    public Object activationLink;
    @SerializedName("latitude")
    @Expose
    public Object latitude;
    @SerializedName("longitude")
    @Expose
    public Object longitude;
    @SerializedName("newPin")
    @Expose
    public Object newPin;
    @SerializedName("language")
    @Expose
    public Object language;
    @SerializedName("retypePin")
    @Expose
    public Object retypePin;
    @SerializedName("usercount")
    @Expose
    public Integer usercount;
    @SerializedName("alertpendingcount")
    @Expose
    public Integer alertpendingcount;
    @SerializedName("alertresolvecount")
    @Expose
    public Integer alertresolvecount;
    @SerializedName("confPassword")
    @Expose
    public Object confPassword;
    @SerializedName("deleted")
    @Expose
    public Boolean deleted;
}
