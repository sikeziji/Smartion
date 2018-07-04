package com.wangj.smartion.smartion.framgent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.wangj.smartion.smartion.BaseFragemnt;
import com.wangj.smartion.smartion.R;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class UserFragment extends BaseFragemnt {


    private ImageView burImage,avatarImageVIew;
    private View view;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
         view = inflater.inflate(R.layout.activity_main, container, false);
        return view;
    }

    @Override
    protected void initData() {
        burImage = view.findViewById(R.id.user_back);
        avatarImageVIew = view.findViewById(R.id.user_head);

        //头部磨砂布局代码
        Glide.with(this).load(R.drawable.head).bitmapTransform(new BlurTransformation(getActivity
                        (), 25),
                new CenterCrop(getActivity()))
                .into(burImage);

        Glide.with(this).load(R.drawable.head)
                .bitmapTransform(new CropCircleTransformation(getActivity())).into(avatarImageVIew);
    }
}
