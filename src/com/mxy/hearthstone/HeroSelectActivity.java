package com.mxy.hearthstone;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.mxy.hearthstone.hero.WarriorActivity;

/**
 * Created by SinTi on 2014/8/17.
 * 选择英雄
 */
public class HeroSelectActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero);

    }

    public void showHunterCards(View view) {
        Toast.makeText(this, "展示猎人卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showShamanCards(View view) {

        Toast.makeText(this, "展示萨满卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showPaladinCards(View view) {
        Toast.makeText(this, "展示圣骑士卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showMageCards(View view) {
        Toast.makeText(this, "展示法师卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showWarriorCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, WarriorActivity.class);
        startActivity(intent);
    }

    public void showDruidCards(View view) {
        Toast.makeText(this, "展示德鲁伊卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showWarlockCards(View view) {
        Toast.makeText(this, "展示术士卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showPriestCards(View view) {
        Toast.makeText(this, "展示牧师卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showRogueCards(View view) {
        Toast.makeText(this, "展示潜行者卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showNeutralCards(View view) {
        Toast.makeText(this, "展示中立卡牌", Toast.LENGTH_SHORT).show();
    }
}
