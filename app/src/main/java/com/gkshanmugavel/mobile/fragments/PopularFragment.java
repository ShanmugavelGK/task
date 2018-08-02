package com.gkshanmugavel.mobile.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gkshanmugavel.mobile.R;
import com.gkshanmugavel.mobile.adapters.PopularAdapter;
import com.gkshanmugavel.mobile.bean.ResponseBean;
import com.gkshanmugavel.mobile.bean.UserBean;
import com.gkshanmugavel.mobile.network.APIInterface;
import com.gkshanmugavel.mobile.network.RetrofitFactory;
import com.gkshanmugavel.mobile.onClickListener;
import com.gkshanmugavel.mobile.utils.Constants;
import com.gkshanmugavel.mobile.utils.MyProgressDialog;
import com.gkshanmugavel.mobile.utils.Utility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment
        extends Fragment
        implements onClickListener {


    private RecyclerView recyclerView;
    List<UserBean> userBeanList;
    private PopularAdapter mAdapter;

    Activity mActivity;
    private MyProgressDialog progressDialog;
    private APIInterface mAPIInterface;

    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mActivity = getActivity();
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);

        userBeanList = new ArrayList<>();


        callUserDetail();
    }

    private void callUserDetail() {
        if (!Utility.isInternetConnected(mActivity)) {
            Utility.showSnackBar(mActivity, mActivity.getString(R.string.no_internet_connection));
            return;
        }
       /* userId=623
        latitude=13.0827
        longitude=80.2707

        Headers:
        Authorization - Bearer 044f910c-f202-482c-9119-72509e6f838a*/

        progressDialog = new MyProgressDialog();
        progressDialog.showDialog(mActivity);
        mAPIInterface = RetrofitFactory.createService(APIInterface.class);
        Call<ResponseBean> call = mAPIInterface.getPopular(
                Constants.TOTKEN,
                Constants.USER_ID,
                Constants.LATITUDE,
                Constants.LONGITUDE
        );

        call.enqueue(new Callback<ResponseBean>() {
            @Override
            public void onResponse(Call<ResponseBean> call, Response<ResponseBean> response) {
                try {
                    progressDialog.dismissDialog();
                    if (response.code() == 200 && response.isSuccessful()) {
                        if (response.body().entity.size() != 0) {
                            userBeanList = response.body().entity;
                            for (int i = 0; i < userBeanList.size(); i++) {
                                UserBean bean = userBeanList.get(i);
                                bean.month = Utility.dataConvert(bean.createdOn);
                                userBeanList.set(i, bean);
                            }
                            mAdapter = new PopularAdapter(mActivity, userBeanList, PopularFragment.this);
                            recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                            recyclerView.setAdapter(mAdapter);
                        } else {

                        }
                    } else {
                        Utility.showSnackBar(mActivity, response.message());
                    }
                } catch (
                        NullPointerException e)

                {
                    e.printStackTrace();
                } catch (
                        Exception e)

                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBean> call, Throwable t) {
                try {
                    progressDialog.dismissDialog();
                    Utility.logError(t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onClicked(int position) {
        UserBean userBean = userBeanList.get(position);
        if (userBean.isClicked)
            userBean.isClicked = false;
        else
            userBean.isClicked = true;


        userBeanList.set(position, userBean);
        mAdapter.notifyDataSetChanged();
    }
}
