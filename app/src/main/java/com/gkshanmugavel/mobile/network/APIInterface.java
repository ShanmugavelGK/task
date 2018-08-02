package com.gkshanmugavel.mobile.network;


import com.gkshanmugavel.mobile.bean.ResponseBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIInterface {

    @Headers({"Content-Type: application/json"})
    @GET("alertmobile/getallpopularalerts")
    Call<ResponseBean> getPopular(@Header("Authorization") String token,
                                  @Query("userId") Integer userId,
                                  @Query("latitude") double latitude,
                                  @Query("longitude") double longitude);


/*    GET Method:
    URL: http://35.164.28.104:8080/alertmobile/getallpopularalerts?userId=623&latitude=13.0827&longitude=80.2707

    Query Params:
    userId=623
    latitude=13.0827
    longitude=80.2707

    Headers:
    Authorization - Bearer 044f910c-f202-482c-9119-72509e6f838a*/

}
