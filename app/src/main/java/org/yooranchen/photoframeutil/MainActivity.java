package org.yooranchen.photoframeutil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.yooranchen.photoframeutil.common.Constant;
import org.yooranchen.photoframeutil.common.Drawables;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawables.init(getResources());
    }

    public void btnFresco(View view) {
        startImageActivity(Constant.TYPE_FRESCO);
    }


    public void btnPicasso(View view) {
        startImageActivity(Constant.TYPE_PICASSO);
    }

    public void btnUIL(View view) {
        startImageActivity(Constant.TYPE_UIL);
    }

    public void btnVolley(View view) {
        startImageActivity(Constant.TYPE_VOLLEY);
    }

    public void btnGlide(View view) {
        startImageActivity(Constant.TYPE_GLIDE);
    }

    private void startImageActivity(int type) {
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra(Constant.FLAG_TYPE, type);
        startActivity(intent);
    }
}
