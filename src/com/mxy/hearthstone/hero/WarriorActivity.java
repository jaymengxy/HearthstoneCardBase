package com.mxy.hearthstone.hero;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.mxy.hearthstone.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * 战士
 */
public class WarriorActivity extends Activity {
    private ImageView iv;
    private AlphaAnimation aa;
    private GridView gv_cards;

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
        gv_cards.setAdapter(new WarriorAdapter());

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

    // 全部卡牌
    public void costAll(View view) {
    }

    // 消耗为0的卡牌
    public void cost0(View view) {
    }

    // 消耗为1的卡牌
    public void cost1(View view) {
    }

    // 消耗为2的卡牌
    public void cost2(View view) {
    }

    // 消耗为3的卡牌
    public void cost3(View view) {
    }

    // 消耗为4的卡牌
    public void cost4(View view) {
    }

    // 消耗为5的卡牌
    public void cost5(View view) {
    }

    // 消耗为6的卡牌
    public void cost6(View view) {
    }

    // 消耗为7的卡牌
    public void cost7plus(View view) {
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
