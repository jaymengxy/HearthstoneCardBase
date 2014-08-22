package com.mxy.hearthstone.hero;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import com.mxy.hearthstone.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by SinTi on 2014/8/18.
 * 战士
 */
public class Warrior extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warrior);
        ImageView iv = (ImageView) findViewById(R.id.iv_test);
        AssetManager am = getAssets();
        try {
            InputStream is = am.open("Warrior/Brawl.png");
            Bitmap bm = BitmapFactory.decodeStream(is);
            iv.setImageBitmap(bm);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
