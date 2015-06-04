package org.yooranchen.photoframeutil.volleyuitl;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


/**
 * Volley辅助类
 */
public class VolleyUtil {

    private static RequestQueue mRequestQueue;

    /**
     * 初始化通用RequestQueue
     *
     * @param context
     */
    public static void initCommVolley(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    /**
     * 通过volley请求jsonString
     *
     * @param url
     * @param listener
     */
    public static void stringRequest(String url, final StringResponseListener listener) {
        StringRequest stringRequest = new StringRequest(url, listener, listener);
        mRequestQueue.add(stringRequest);
    }

    /**
     * 通过volley请求jsonString
     *
     * @param method
     * @param url
     * @param listener
     */
    public static void stringRequest(int method, String url, final StringResponseListener listener) {
        StringRequest stringRequest = new StringRequest(method, url, listener, listener);
        mRequestQueue.add(stringRequest);
    }


    /**
     * 通过volley请求json
     * <p>
     * Method GET
     *
     * @param url
     * @param listener
     */
    public static void jsonObjectRequest(String url, final VolleyResponseListener listener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, listener, listener);
        mRequestQueue.add(jsonObjectRequest);
    }

    /**
     * 通过volley请求json，带参数
     * <p>
     * Method GET
     *
     * @param url
     * @param jsonRequest
     * @param listener
     */
    public static void jsonObjectRequest(String url, JSONObject jsonRequest, final VolleyResponseListener listener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, jsonRequest, listener, listener);
        mRequestQueue.add(jsonObjectRequest);
    }

    /**
     * 通过volley请求json，带参数
     * <p>
     * Method GET|POST
     *
     * @param url
     * @param jsonRequest
     * @param listener
     */
    public static void jsonObjectRequest(int method, String url, JSONObject jsonRequest, final VolleyResponseListener listener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url,
                jsonRequest, listener, listener);
        mRequestQueue.add(jsonObjectRequest);
    }
}
