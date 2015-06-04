package org.yooranchen.photoframeutil.been;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 实体类
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class JsonBean implements Parcelable {

    /**
     * 图片ID
     */
    String id;
    /**
     * 图片地址
     */
    String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.url);
    }

    public JsonBean() {
    }

    protected JsonBean(Parcel in) {
        this.id = in.readString();
        this.url = in.readString();
    }

    public static final Creator<JsonBean> CREATOR = new Creator<JsonBean>() {
        public JsonBean createFromParcel(Parcel source) {
            return new JsonBean(source);
        }

        public JsonBean[] newArray(int size) {
            return new JsonBean[size];
        }
    };
}
