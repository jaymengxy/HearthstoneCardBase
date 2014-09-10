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
import java.util.zip.ZipInputStream;

public class MainActivity extends Activity {

    private ImageView iv;
    private AlphaAnimation aa;
    private ScaleAnimation sa;

    private static String path = "/data/data/com.mxy.hearthstone/db/data.db";
    public static SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        copyDB();
        new Thread(){
            @Override
            public void run() {
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
            }
        }.start();
    }

    private void copyDB() {
        if (!new File(getApplicationInfo().dataDir + "/db/data.db").exists()) {
            new Thread() {
                public void run() {
                    try {
//                        File zipFile = new File("/db.zip");
//                        ZipUtil.upZipFile(zipFile,MainActivity.this.getApplicationInfo().dataDir + "/db/");
//                        File imgFile = new File("/images.zip");
//                        ZipUtil.upZipFile(imgFile,MainActivity.this.getApplicationInfo().dataDir + "/db/images/");

                        ZipInputStream dbZipInputStream = new ZipInputStream(MainActivity.this.getAssets().open("db.zip"));
                        ZipUtil.ectract(dbZipInputStream, MainActivity.this.getApplicationInfo().dataDir + "/db/");
                        ZipInputStream imgZipInputStream = new ZipInputStream(MainActivity.this.getAssets().open("images.zip"));
                        ZipUtil.ectract(imgZipInputStream, MainActivity.this.getApplicationInfo().dataDir + "/db/images/");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭数据库
        if (db != null) {
            db.close();
        }
    }
}
