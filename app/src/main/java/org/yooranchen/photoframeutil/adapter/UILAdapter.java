package org.yooranchen.photoframeutil.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.yooranchen.photoframeutil.R;
import org.yooranchen.photoframeutil.been.JsonBean;
import org.yooranchen.photoframeutil.configs.uil.UilFactory;
import org.yooranchen.photoframeutil.adapter.quickadapter.BaseAdapterHelper;
import org.yooranchen.photoframeutil.adapter.quickadapter.QuickAdapter;

import java.util.List;

/**
 * 使用UIL加载图片
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class UILAdapter extends QuickAdapter<JsonBean> {
    private ImageLoader mImageLoader;

    public UILAdapter(Context context, List<JsonBean> data) {
        super(context, R.layout.listitem_image, data);
        mImageLoader = UilFactory.getImageLoader(context);
    }


    @Override
    protected void convert(BaseAdapterHelper helper, JsonBean item) {
        ImageView imageView = helper.getView(R.id.iv_image);
        String imageUrl = item.getUrl();
        mImageLoader.displayImage(imageUrl, imageView);
    }

    @Override
    public void shunDown() {
        mImageLoader.clearMemoryCache();
    }
}

