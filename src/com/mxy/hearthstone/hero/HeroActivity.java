package com.mxy.hearthstone.hero;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.mxy.hearthstone.R;
import com.mxy.hearthstone.fragment.CardsFragment;


public class HeroActivity extends Activity {
    // private ImageView iv;
    // private AlphaAnimation aa;
    //private static String path = "/data/data/com.mxy.hearthstone/db/data.db";
    //public static SQLiteDatabase db;
    private ScrollView sv_fragment;
    private HeroSlideView hero_sv;
    private String hero;
    private LinearLayout hero_description;
    private LinearLayout hero_cards;
    private final int HUNTER = 0;
    private final int SHAMAN = 1;
    private final int PALADIN = 2;
    private final int MAGE = 3;
    private final int WARRIOR = 4;
    private final int DRUID = 5;
    private final int WARLOCK = 6;
    private final int PRIEST = 7;
    private final int ROGUE = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.hero);
        hero_sv = (HeroSlideView) findViewById(R.id.hero_sv);

        hero_description = (LinearLayout) findViewById(R.id.hero_description);
        hero_cards = (LinearLayout) findViewById(R.id.hero_cards);
        switch (intent.getIntExtra("heroNum", 0)) {
            case HUNTER:
                hero = "hunter";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.hunter_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.hunter_cards_bg));
                break;
            case SHAMAN:
                hero = "shaman";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.shaman_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.shaman_cards_bg));
                break;
            case PALADIN:
                hero = "paladin";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.paladin_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.paladin_cards_bg));
                break;
            case MAGE:
                hero = "mage";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.mage_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.mage_cards_bg));
                break;
            case WARRIOR:
                hero = "warrior";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.warrior_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.warrior_cards_bg));
                break;
            case DRUID:
                hero = "druid";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.druid_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.druid_cards_bg));
                break;
            case WARLOCK:
                hero = "warlock";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.warlock_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.warlock_cards_bg));
                break;
            case PRIEST:
                hero = "priest";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.priest_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.priest_cards_bg));
                break;
            case ROGUE:
                hero = "rogue";
                hero_description = (LinearLayout) View.inflate(hero_description.getContext(), R.layout.rogue_description, hero_description);
                hero_cards.setBackground(getResources().getDrawable(R.drawable.rogue_cards_bg));
                break;
        }
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
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, -1));
                // ft.replace(R.id.fl_fragment, new FragmentAll());
                break;
            case R.id.bt_cost0:
                // 进行操作: 把Activity布局中的Fragment替换成FragmentAll
                // ft.replace(R.id.fl_fragment, new Fragment0());
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, 0));
                break;
            case R.id.bt_cost1:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, 1));
                break;
            case R.id.bt_cost2:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, 2));
                break;
            case R.id.bt_cost3:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, 3));
                break;
            case R.id.bt_cost4:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, 4));
                break;
            case R.id.bt_cost5:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, 5));
                break;
            case R.id.bt_cost6:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, 6));
                break;
            case R.id.bt_cost7plus:
                ft.replace(R.id.fl_fragment, cardsFragment.newInstance(hero, 7));
                break;

        }
        sv_fragment.setVisibility(View.INVISIBLE);
        // 把事物关闭
        ft.commit();

    }
}
