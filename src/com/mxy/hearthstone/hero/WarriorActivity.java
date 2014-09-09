package com.mxy.hearthstone.hero;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.mxy.hearthstone.R;
import com.mxy.hearthstone.fragment.Fragment0;
import com.mxy.hearthstone.fragment.FragmentAll;

/**
 * 战士
 */
public class WarriorActivity extends Activity {
    // private ImageView iv;
    // private AlphaAnimation aa;
    private static String path = "/data/data/com.mxy.hearthstone/db/data.db";
    public static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warrior);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭数据库
        if (db != null) {
            db.close();
        }
    }

    // 全部卡牌
    public void costAll(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, -1);
        // 获得Fragment管理器对象
        FragmentManager fm = getFragmentManager();

        // 获得一个Fragment的事物对象
        FragmentTransaction ft = fm.beginTransaction();

        // 进行操作: 把Activity布局中的Fragment替换成FragmentAll
        ft.replace(R.id.cards_fragment, new FragmentAll());

        // 把事物关闭
        ft.commit();

    }

    // 消耗为0的卡牌
    public void cost0(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, 0);
        // 获得Fragment管理器对象
        FragmentManager fm = getFragmentManager();

        // 获得一个Fragment的事物对象
        FragmentTransaction ft = fm.beginTransaction();

        // 进行操作: 把Activity布局中的Fragment替换成FragmentAll
        ft.replace(R.id.cards_fragment, new Fragment0());

        // 把事物关闭
        ft.commit();
    }

    // 消耗为1的卡牌
    public void cost1(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, 1);
    }

    // 消耗为2的卡牌
    public void cost2(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, 2);
    }

    // 消耗为3的卡牌
    public void cost3(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, 3);
    }

    // 消耗为4的卡牌
    public void cost4(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, 4);
    }

    // 消耗为5的卡牌
    public void cost5(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, 5);
    }

    // 消耗为6的卡牌
    public void cost6(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, 6);
    }

    // 消耗为7的卡牌
    public void cost7plus(View view) {
        // warriorCards = CardsQueryDao.warriorCardsQuery(db, 7);
    }

}
