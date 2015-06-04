package org.yooranchen.photoframeutil.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.yooranchen.photoframeutil.R;
import org.yooranchen.photoframeutil.adapter.quickadapter.BaseAdapterHelper;
import org.yooranchen.photoframeutil.adapter.quickadapter.QuickAdapter;
import org.yooranchen.photoframeutil.been.JsonBean;
import org.yooranchen.photoframeutil.common.Drawables;
import org.yooranchen.photoframeutil.configs.picasso.SamplePicassoFactory;

import java.util.List;

/**
 * 使用Picasso加载图片
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class PicassoAdapter extends QuickAdapter<JsonBean> {
    private final Picasso mPicasso;

    public PicassoAdapter(Context context, List<JsonBean> data) {
        super(context, R.layout.listitem_image, data);
        mPicasso = SamplePicassoFactory.getPicasso(context);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, JsonBean item) {
        ImageView imageView = helper.getView(R.id.iv_image);
        mPicasso.load(item.getUrl())
                .placeholder(Drawables.sPlaceholderDrawable)
                .error(Drawables.sErrorDrawable)
                .fit()
                .into(imageView);
    }

    @Override
    public void shunDown() {
        for (int i = 0; i < getCount(); i++) {
            String uri = getItem(i).getUrl();
            mPicasso.invalidate(uri);
        }
    }
}
