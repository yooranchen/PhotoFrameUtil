package org.yooranchen.photoframeutil.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.yooranchen.photoframeutil.R;
import org.yooranchen.photoframeutil.adapter.quickadapter.BaseAdapterHelper;
import org.yooranchen.photoframeutil.adapter.quickadapter.QuickAdapter;
import org.yooranchen.photoframeutil.been.JsonBean;
import org.yooranchen.photoframeutil.common.Drawables;

import java.util.List;

/**
 * 使用Glide加载图片
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class GlideAdapter extends QuickAdapter<JsonBean> {


    public GlideAdapter(Context context, List<JsonBean> data) {
        super(context, R.layout.listitem_image, data);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, JsonBean item) {
        String url = item.getUrl();
        ImageView imageView = helper.getView(R.id.iv_image);
        Glide.with(context)
                .load(url)
                .placeholder(Drawables.sPlaceholderDrawable)
                .error(Drawables.sErrorDrawable)
                .crossFade()
                .into(imageView);
    }

    @Override
    public void shunDown() {
        Glide.get(context).clearMemory();
    }
}
