package com.gkshanmugavel.mobile.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.gkshanmugavel.mobile.R;
import com.gkshanmugavel.mobile.bean.UserBean;
import com.gkshanmugavel.mobile.onClickListener;
import com.gkshanmugavel.mobile.utils.CircleImageView;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    Context context;
    List<UserBean> userBeanList;
    onClickListener onClickListener;

    public PopularAdapter(Context context, List<UserBean> userBeanList, onClickListener onClickListener) {
        this.context = context;
        this.userBeanList = userBeanList;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_item_list, viewGroup, false);

        return new PopularViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PopularViewHolder holder, final int position) {
        try {
            final UserBean userBean = userBeanList.get(position);

            if (position % 2 != 1) {
                holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.md_white_1000));
            } else {
                holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.md_grey_200));

            }

            Glide.with(context).load(userBean.thumbnailUrl)
                    .thumbnail(0.5f)
                    .into(holder.ivLogo);

            Glide.with(context).load(userBean.largeUrl)
                    .thumbnail(0.5f)
                    .into(holder.ivLargeImage);

            holder.tvMonth.setText(userBean.month + " Months");
            holder.tvName.setText("" + userBean.userIdBean.firstName);
            isClick(holder, userBean, userBean.isClicked);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClicked(position);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void isClick(final PopularViewHolder holder, UserBean userBean, boolean isClick) {
        if (!isClick) {
            holder.tvAddressLeft.setText(userBean.address.equals("") ? "no Address" : "" + userBean.address);
            holder.tvCommentCountLeft.setText(userBean.commentCount + " Comments");

            holder.tvAddressLeft.setVisibility(View.VISIBLE);
            holder.tvCommentCountLeft.setVisibility(View.VISIBLE);

            holder.tvAddressBottom.setVisibility(View.GONE);
            holder.tvCommentCountBottom.setVisibility(View.GONE);
            holder.ivLargeImage.setVisibility(View.GONE);
            holder.viewDivider.setVisibility(View.VISIBLE);

            holder.tvAddressBottom.setText(userBean.address.equals("") ? "no Address" : "" + userBean.address);
        } else {
            holder.tvAddressLeft.setText(userBean.address.equals("") ? "no Address" : "" + userBean.address);
            holder.tvCommentCountBottom.setText(userBean.commentCount + " ");

            holder.tvAddressLeft.setVisibility(View.GONE);
            holder.tvCommentCountLeft.setVisibility(View.GONE);

            holder.tvAddressBottom.setVisibility(View.VISIBLE);
            holder.tvCommentCountBottom.setVisibility(View.VISIBLE);
            holder.ivLargeImage.setVisibility(View.VISIBLE);
            holder.viewDivider.setVisibility(View.GONE);
            holder.tvAddressBottom.setText(userBean.address.equals("") ? "no Address" : "" + userBean.address);
        }

    }

    @Override
    public int getItemCount() {
        return userBeanList == null ? 0 : userBeanList.size();
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder {
        private final CircleImageView ivLogo;
        private final AppCompatTextView tvName;
        private final AppCompatTextView tvMonth;
        private final AppCompatTextView tvAddressLeft;
        private final AppCompatTextView tvCommentCountLeft;
        private final AppCompatImageView ivLargeImage;
        private final AppCompatTextView tvAddressBottom;
        private final AppCompatTextView tvCommentCountBottom;
        private final View viewDivider;

        public PopularViewHolder(View view) {
            super(view);
            ivLogo = (CircleImageView) view.findViewById(R.id.iv_logo);
            tvName = (AppCompatTextView) view.findViewById(R.id.tv_name);
            tvMonth = (AppCompatTextView) view.findViewById(R.id.tv_month);
            tvAddressLeft = (AppCompatTextView) view.findViewById(R.id.tv_address_left);
            tvCommentCountLeft = (AppCompatTextView) view.findViewById(R.id.tv_comment_count_left);

            ivLargeImage = (AppCompatImageView) view.findViewById(R.id.iv_large_image);
            tvAddressBottom = (AppCompatTextView) view.findViewById(R.id.tv_address_bottom);
            tvCommentCountBottom = (AppCompatTextView) view.findViewById(R.id.tv_comment_count_bottom);
            viewDivider = (View) view.findViewById(R.id.view_divider);

        }
    }

}
