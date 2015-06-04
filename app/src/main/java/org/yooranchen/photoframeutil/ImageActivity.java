package org.yooranchen.photoframeutil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yooranchen.photoframeutil.adapter.FrescoAdapter;
import org.yooranchen.photoframeutil.adapter.GlideAdapter;
import org.yooranchen.photoframeutil.adapter.PicassoAdapter;
import org.yooranchen.photoframeutil.adapter.UILAdapter;
import org.yooranchen.photoframeutil.adapter.VolleyImageLoaderAdapter;
import org.yooranchen.photoframeutil.adapter.quickadapter.QuickAdapter;
import org.yooranchen.photoframeutil.been.JsonBean;
import org.yooranchen.photoframeutil.common.BaseActivity;
import org.yooranchen.photoframeutil.common.Constant;
import org.yooranchen.photoframeutil.common.Drawables;
import org.yooranchen.photoframeutil.volleyuitl.VolleyResponseListener;
import org.yooranchen.photoframeutil.volleyuitl.VolleyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class ImageActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    List<JsonBean> mData;
    QuickAdapter<JsonBean> mAdapter;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initView();
        initDataParseByGson();
    }

    /**
     * 使用Gson解析下载的数据
     */
    private void initDataParseByGson() {
        mData = new ArrayList<>();
        String url = "http://7mnpex.com1.z0.glb.clouddn.com/photoframe.json";
        VolleyUtil.jsonObjectRequest(url, new VolleyResponseListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("onErrorResponse", volleyError.getMessage());
                Toast.makeText(getApplicationContext(), "网络异常,请重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(JSONObject response) {
                Log.e("onErrorResponse", response.toString());
                try {
                    Gson gson = new Gson();
                    JSONArray jsonArray = response.getJSONArray("data");
                    int length = jsonArray.length();
                    for (int i = 0; i < length; i++) {
                        JsonBean jsonBean = gson.fromJson(jsonArray.getJSONObject(i).toString(),
                                JsonBean.class);
                        mData.add(jsonBean);
                    }
                    setImageAdapter();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.lv_image);
        mListView.setOnItemClickListener(this);
    }


    private void setImageAdapter() {
        int type = getIntent().getIntExtra(Constant.FLAG_TYPE, Constant.TYPE_FRESCO);
        switch (type) {
            case Constant.TYPE_FRESCO:
                mAdapter = new FrescoAdapter(this, mData);
                break;
            case Constant.TYPE_PICASSO:
                mAdapter = new PicassoAdapter(this, mData);
                break;
            case Constant.TYPE_UIL:
                mAdapter = new UILAdapter(this, mData);
                break;
            case Constant.TYPE_VOLLEY:
                mAdapter = new VolleyImageLoaderAdapter(this, mData);
                break;
            case Constant.TYPE_GLIDE:
                mAdapter = new GlideAdapter(this, mData);
                break;
        }
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        JsonBean jsonBean = mData.get(position);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Constant.JSON_BEAN, jsonBean);
        intent.putExtra(Constant.FLAG_TYPE, getIntent().getIntExtra(Constant.FLAG_TYPE, Constant.TYPE_FRESCO));
        startActivity(intent);
    }
}
