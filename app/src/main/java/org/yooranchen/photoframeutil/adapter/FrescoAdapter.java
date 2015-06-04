package org.yooranchen.photoframeutil.adapter;

import android.content.Context;

import org.yooranchen.photoframeutil.R;
import org.yooranchen.photoframeutil.been.JsonBean;
import org.yooranchen.photoframeutil.adapter.quickadapter.BaseAdapterHelper;
import org.yooranchen.photoframeutil.adapter.quickadapter.QuickAdapter;

import java.util.List;

/**
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class FrescoAdapter extends QuickAdapter<JsonBean> {
    public FrescoAdapter(Context context, List<JsonBean> data) {
        super(context, R.layout.listitem_image, data);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, JsonBean item) {
    }

    @Override
    public void shunDown() {

    }
}
