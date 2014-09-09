package com.mxy.hearthstone.hero;

import android.app.Activity;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.mxy.hearthstone.R;
import com.mxy.hearthstone.db.dao.CardsQueryDao;
import com.mxy.hearthstone.domain.Card;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 战士
 */
public class WarriorActivity extends Activity {
    private ImageView iv;
    private AlphaAnimation aa;
    private GridView gv_cards;
    private static String path = "/data/data/com.mxy.hearthstone/db/data.db";
    private SQLiteDatabase db;
    private List<Card> cards;

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
        gv_cards = (GridView) findViewById(R.id.gv_cards);
        // 取消GridView的点击效果
        gv_cards.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gv_cards.setAdapter(new WarriorAdapter());
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
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
        cards = CardsQueryDao.warriorCardsQuery(db, -1);

    }

    // 消耗为0的卡牌
    public void cost0(View view) {
        cards = CardsQueryDao.warriorCardsQuery(db, 0);
    }

    // 消耗为1的卡牌
    public void cost1(View view) {
        cards = CardsQueryDao.warriorCardsQuery(db, 1);
    }

    // 消耗为2的卡牌
    public void cost2(View view) {
        cards = CardsQueryDao.warriorCardsQuery(db, 2);
    }

    // 消耗为3的卡牌
    public void cost3(View view) {
        cards = CardsQueryDao.warriorCardsQuery(db, 3);
    }

    // 消耗为4的卡牌
    public void cost4(View view) {
        cards = CardsQueryDao.warriorCardsQuery(db, 4);
    }

    // 消耗为5的卡牌
    public void cost5(View view) {
        cards = CardsQueryDao.warriorCardsQuery(db, 5);
    }

    // 消耗为6的卡牌
    public void cost6(View view) {
        cards = CardsQueryDao.warriorCardsQuery(db, 6);
    }

    // 消耗为7的卡牌
    public void cost7plus(View view) {
        cards = CardsQueryDao.warriorCardsQuery(db, 7);
    }

    private class WarriorAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(WarriorActivity.this, R.layout.cards_item, null);
            ImageView iv_card = (ImageView) view.findViewById(R.id.iv_card);
            AssetManager am = getAssets();
            try {
                InputStream is = am.open("Warrior/Brawl.png");
                Bitmap bm = BitmapFactory.decodeStream(is);
                iv_card.setImageBitmap(bm);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return view;
        }
    }
}
