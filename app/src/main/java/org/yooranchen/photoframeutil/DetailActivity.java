package org.yooranchen.photoframeutil;

import android.content.Context;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import org.yooranchen.photoframeutil.been.JsonBean;
import org.yooranchen.photoframeutil.common.BaseActivity;
import org.yooranchen.photoframeutil.common.Constant;
import org.yooranchen.photoframeutil.common.Drawables;
import org.yooranchen.photoframeutil.configs.picasso.SamplePicassoFactory;
import org.yooranchen.photoframeutil.configs.uil.UilFactory;
import org.yooranchen.photoframeutil.configs.volley.VolleyFactory;
import org.yooranchen.photoframeutil.photoview.PhotoView;

/**
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class DetailActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this;
        setContentView(R.layout.activity_detail);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo);
        JsonBean jsonBean = getIntent().getParcelableExtra(Constant.JSON_BEAN);
        int type = getIntent().getIntExtra(Constant.FLAG_TYPE, Constant.TYPE_FRESCO);
        String url = jsonBean.getUrl();
        switch (type) {
            case Constant.TYPE_FRESCO:
                break;
            case Constant.TYPE_PICASSO:
                Picasso picasso = SamplePicassoFactory.getPicasso(context);
                picasso
                        .load(url)
                        .placeholder(Drawables.sPlaceholderDrawable)
                        .error(Drawables.sErrorDrawable)
                        .fit()
                        .into(photoView);
                break;
            case Constant.TYPE_UIL:
                ImageLoader imageLoader = UilFactory.getImageLoader(context);
                imageLoader.displayImage(url, photoView);
                break;
            case Constant.TYPE_VOLLEY:
                VolleyFactory.getImageLoader(context).get(url,
                        com.android.volley.toolbox.ImageLoader.getImageListener(
                                photoView, R.color.placeholder, R.color.error
                        ));
                break;
            case Constant.TYPE_GLIDE:
                Glide.with(context)
                        .load(url)
                        .placeholder(Drawables.sPlaceholderDrawable)
                        .error(Drawables.sErrorDrawable)
                        .crossFade()
                        .into(photoView);
                break;
        }
    }
}
