package com.mxy.hearthstone;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.mxy.hearthstone.hero.*;

/**
 * Created by SinTi on 2014/8/17.
 * 选择英雄
 */
public class HeroSelectActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heros);

    }

    public void showHunterCards(View view) {
        Toast.makeText(this, "展示猎人卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showShamanCards(View view) {

        Toast.makeText(this, "展示萨满卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showPaladinCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, PaladinActivity.class);
        startActivity(intent);
    }

    public void showMageCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MageActivity.class);
        startActivity(intent);
    }

    public void showWarriorCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, WarriorActivity.class);
        startActivity(intent);
    }

    public void showDruidCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, DruidActivity.class);
        startActivity(intent);
    }

    public void showWarlockCards(View view) {
        Toast.makeText(this, "展示术士卡牌", Toast.LENGTH_SHORT).show();
    }

    public void showPriestCards(View view) {
        Intent intent = new Intent();
        intent.setClass(this, PriestActivity.class);
        startActivity(intent);
    }

    public void showRogueCards(View view) {
        Toast.makeText(this, "展示潜行者卡牌", Toast.LENGTH_SHORT).show();
    }

    /*public void showNeutralCards(View view) {
        Toast.makeText(this, "展示中立卡牌", Toast.LENGTH_SHORT).show();
    }*/
}
