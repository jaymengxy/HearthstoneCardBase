package com.mxy.hearthstone.hero;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.mxy.hearthstone.R;
import com.mxy.hearthstone.fragment.*;

/**
 * 战士
 */
public class WarriorActivity extends Activity {
    // private ImageView iv;
    // private AlphaAnimation aa;
    //private static String path = "/data/data/com.mxy.hearthstone/db/data.db";
    //public static SQLiteDatabase db;
    private ScrollView sv_fragment;
    private WarriorSlideView warrior_sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warrior);

        warrior_sv = (WarriorSlideView) findViewById(R.id.warrior_sv);
        sv_fragment = (ScrollView) findViewById(R.id.sv_fragment);
    }
/*

    @Override
    protected void onStart() {
        super.onStart();
        iv = (ImageView) findViewById(R.id.iv_garrosh);
        aa = new AlphaAnimation(1, 0); // 指定从显示到隐藏
        aa.setDuration(7000);
        aa.setFillAfter(true); // 指定动画停留在动画结束的状态下
        iv.startAnimation(aa);
    }
*/

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭数据库
        if (db != null) {
            db.close();
        }
    }*/

    public void costClick(View view) {
        int id = view.getId();
        // 获得Fragment管理器对象
        FragmentManager fm = getFragmentManager();

        // 获得一个Fragment的事物对象
        FragmentTransaction ft = fm.beginTransaction();
        CardsFragment cardsFragment = (CardsFragment) getFragmentManager().findFragmentById(R.id.fl_fragment);
        switch (id) {
            case R.id.bt_costAll:
                // 进行操作: 把Activity布局中的Framelayout替换成FragmentAll
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", -1));
                // ft.replace(R.id.fl_fragment, new FragmentAll());
                break;
            case R.id.bt_cost0:
                // 进行操作: 把Activity布局中的Fragment替换成FragmentAll
                // ft.replace(R.id.fl_fragment, new Fragment0());
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", 0));
                break;
            case R.id.bt_cost1:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", 1));
                break;
            case R.id.bt_cost2:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", 2));
                break;
            case R.id.bt_cost3:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", 3));
                break;
            case R.id.bt_cost4:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", 4));
                break;
            case R.id.bt_cost5:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", 5));
                break;
            case R.id.bt_cost6:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", 6));
                break;
            case R.id.bt_cost7plus:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance("warrior", 7));
                break;

        }
        sv_fragment.setVisibility(View.INVISIBLE);
        // 把事物关闭
        ft.commit();

    }

}
