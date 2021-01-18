package com.h5190050.safak_sezer_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190050.safak_sezer_final.R;

public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.arkaplan_splash)
                .centerCrop()
                .into(img);
    }
}
