package com.mxy.hearthstone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.Toast;
import com.mxy.hearthstone.hero.Warrior;

/**
 * Created by SinTi on 2014/8/17.
 * 选择英雄
 */
public class HeroSelect extends Activity{

    private ImageView iv;
    private AlphaAnimation aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero);

    }

    @Override
    protected void onStart() {
        super.onStart();
        iv = (ImageView) findViewById(R.id.iv_garrosh);
        aa = new AlphaAnimation(1, 0); // 指定从显示到隐藏
        aa.setDuration(6000);
        aa.setFillAfter(true); // 指定动画停留在动画结束的状态下
        iv.startAnimation(aa);
    }

    public void showHunterCards(View view) {
        Toast.makeText(this,"展示猎人卡牌",Toast.LENGTH_SHORT).show();
    }

    public void showShamanCards(View view) {

        Toast.makeText(this,"展示萨满卡牌",Toast.LENGTH_SHORT).show();
    }

    public void showPaladinCards(View view) {
        Toast.makeText(this,"展示圣骑士卡牌",Toast.LENGTH_SHORT).show();
    }

    public void showMageCards(View view) {
        Toast.makeText(this,"展示法师卡牌",Toast.LENGTH_SHORT).show();
    }

    public void showWarriorCards(View view) {
        Toast.makeText(this,"展示战士卡牌",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(this, Warrior.class);
        startActivity(intent);
    }

    public void showDruidCards(View view) {
        Toast.makeText(this,"展示德鲁伊卡牌",Toast.LENGTH_SHORT).show();
    }

    public void showWarlockCards(View view) {
        Toast.makeText(this,"展示术士卡牌",Toast.LENGTH_SHORT).show();
    }

    public void showPriestCards(View view) {
        Toast.makeText(this,"展示牧师卡牌",Toast.LENGTH_SHORT).show();
    }

    public void showRogueCards(View view) {
        Toast.makeText(this,"展示潜行者卡牌",Toast.LENGTH_SHORT).show();
    }

    public void showNeutralCards(View view) {
        Toast.makeText(this,"展示中立卡牌",Toast.LENGTH_SHORT).show();
    }
}
