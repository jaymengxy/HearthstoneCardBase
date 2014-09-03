package com.mxy.hearthstone;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class MainActivity extends Activity {

    private ImageView iv;
    private AlphaAnimation aa;
    private ScaleAnimation sa;
    private Object zipFolderLock = new Object();
    private SQLiteDatabase cardDb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        iv = (ImageView) findViewById(R.id.iv_startImage);
        sa = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        sa.setDuration(2000);
        sa.setFillAfter(true);
        iv.startAnimation(sa);

        sa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                aa = new AlphaAnimation(1, 0);
                aa.setFillAfter(true);
                iv.startAnimation(aa);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // 拷贝的位置 new File(getApplicationInfo().dataDir + "/db/data.db"

    }


    public void findByHero(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroSelectActivity.class);
        startActivity(intent);
    }

    public void findByQuality(View view) {
        Intent intent = new Intent();
        intent.setClass(this, QualitySelectActivity.class);
        startActivity(intent);
    }

    public void findByType(View view) {
        Intent intent = new Intent();
        intent.setClass(this, TypeSelectActivity.class);
        startActivity(intent);
    }
}
