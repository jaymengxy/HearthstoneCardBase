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
import com.mxy.hearthstone.utils.ZipUtil;

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
        //ZipInputStream localZipInputStream = new ZipInputStream(HSApplication.this.getAssets().open("data.zip"));
        //ZipUtil.decompress(new File(HSApplication.this.getApplicationInfo().dataDir + "/db/"), localZipInputStream);
        copyDB("data.db");
    }

    /*
    if (!new File(getApplicationInfo().dataDir + "/db/data.db").exists())
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              synchronized (HSApplication.this.zipFolderLock)
              {
                try
                {
                  ZipInputStream localZipInputStream = new ZipInputStream(HSApplication.this.getAssets().open("data.zip"));
                  ZipUtil.decompress(new File(HSApplication.this.getApplicationInfo().dataDir + "/db/"), localZipInputStream);
                  SqliteDataQueryer.getInstance().openDbFileFromRes(HSApplication.this, HSApplication.this.getApplicationInfo().dataDir + "/db/data.db", 2131034112);
                  HSApplication.this.cardDb = SQLiteDatabase.openOrCreateDatabase(HSApplication.this.getApplicationInfo().dataDir + "/db/data.db", null);
                  return;
                }
                catch (IOException localIOException)
                {
                  while (true)
                    localIOException.printStackTrace();
                }
              }
            }
            catch (Exception localException)
            {
              while (true)
                localException.printStackTrace();
            }
          }
        }).start();
     */

    private void copyDB(String dbname) {
        try {
            ZipInputStream localZipInputStream = new ZipInputStream(MainActivity.this.getAssets().open("data.zip"));
            ZipUtil.decompress(new File(MainActivity.this.getApplicationInfo().dataDir +"/db/"), localZipInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
