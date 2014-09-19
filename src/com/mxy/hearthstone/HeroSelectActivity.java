package com.mxy.hearthstone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.mxy.hearthstone.hero.*;

/**
 * Created by SinTi on 2014/8/17.
 * 选择英雄
 */
public class HeroSelectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heros_select);
    }

    public void showHunterCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 0);
        startActivity(intent);
    }

    public void showShamanCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 1);
        startActivity(intent);
    }

    public void showPaladinCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 2);
        startActivity(intent);
    }

    public void showMageCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 3);
        startActivity(intent);
    }

    public void showWarriorCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 4);
        startActivity(intent);
    }

    public void showDruidCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 5);
        startActivity(intent);
    }

    public void showWarlockCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 6);
        startActivity(intent);
    }

    public void showPriestCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 7);
        startActivity(intent);
    }

    public void showRogueCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroActivity.class);
        intent.putExtra("heroNum", 8);
        startActivity(intent);
    }

    /*public void showNeutralCards(View view) {
        Toast.makeText(this, "展示中立卡牌", Toast.LENGTH_SHORT).show();
    }*/
}
