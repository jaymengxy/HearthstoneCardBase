package com.mxy.hearthstone.hero;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.mxy.hearthstone.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by SinTi on 2014/8/18.
 * 战士
 */
public class Warrior extends Activity {
    private ImageView iv;
    private AlphaAnimation aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warrior);
        /*ImageView iv = (ImageView) findViewById(R.id.iv_test);
        AssetManager am = getAssets();
        try {
            InputStream is = am.open("Warrior/Brawl.png");
            Bitmap bm = BitmapFactory.decodeStream(is);
            iv.setImageBitmap(bm);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        ImageView iv_top_right = (ImageView) findViewById(R.id.iv_top_right);
        ImageView iv_top_left = (ImageView) findViewById(R.id.iv_top_left);
        ImageView iv_mid_left = (ImageView) findViewById(R.id.iv_mid_left);
        ImageView iv_mid_right = (ImageView) findViewById(R.id.iv_mid_right);
        ImageView iv_bottom_left = (ImageView) findViewById(R.id.iv_bottom_left);
        ImageView iv_bottom_right = (ImageView) findViewById(R.id.iv_bottom_right);
        AssetManager am = getAssets();
        try {
            InputStream is = am.open("Warrior/Brawl.png");
            Bitmap bm = BitmapFactory.decodeStream(is);
            iv_top_left.setImageBitmap(bm);
            iv_top_right.setImageBitmap(bm);
            iv_mid_left.setImageBitmap(bm);
            iv_mid_right.setImageBitmap(bm);
            iv_bottom_left.setImageBitmap(bm);
            iv_bottom_right.setImageBitmap(bm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        iv = (ImageView) findViewById(R.id.iv_garrosh);
        aa = new AlphaAnimation(1, 0); // 指定从显示到隐藏
        aa.setDuration(7000);
        aa.setFillAfter(true); // 指定动画停留在动画结束的状态下
        iv.startAnimation(aa);
    }
}
