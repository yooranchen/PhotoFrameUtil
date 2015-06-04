package org.yooranchen.photoframeutil.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

import org.yooranchen.photoframeutil.R;
import org.yooranchen.photoframeutil.adapter.quickadapter.BaseAdapterHelper;
import org.yooranchen.photoframeutil.adapter.quickadapter.QuickAdapter;
import org.yooranchen.photoframeutil.been.JsonBean;
import org.yooranchen.photoframeutil.configs.volley.VolleyFactory;

import java.util.List;

/**
 * 使用volley的ImageLoader加载图片
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class VolleyImageLoaderAdapter extends QuickAdapter<JsonBean> {

    private final ImageLoader mImageLoader;

    public VolleyImageLoaderAdapter(Context context, List<JsonBean> data) {
        super(context, R.layout.listitem_image, data);
        mImageLoader = VolleyFactory.getImageLoader(context);
    }


    @Override
    protected void convert(BaseAdapterHelper helper, JsonBean item) {
        ImageView imageView = helper.getView(R.id.iv_image);
        mImageLoader.get(item.getUrl(), ImageLoader.getImageListener(imageView, R.color.placeholder, R.color.error));
    }

    @Override
    public void shunDown() {
        VolleyFactory.getMemoryCache().clear();
    }
}
