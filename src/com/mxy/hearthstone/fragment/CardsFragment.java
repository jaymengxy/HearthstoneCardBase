package com.mxy.hearthstone.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.mxy.hearthstone.MainActivity;
import com.mxy.hearthstone.R;
import com.mxy.hearthstone.db.dao.CardsQueryDao;
import com.mxy.hearthstone.domain.Card;
import com.mxy.hearthstone.hero.WarriorActivity;

import java.util.List;


public class CardsFragment extends Fragment {
    private int mCost = 0;
    private String mHero = "";
    private List<Card> cards;
    private String[] pics;


    public static CardsFragment newInstance(String heroName, int cost) {
        CardsFragment cf = new CardsFragment();

        Bundle args = new Bundle();
        args.putString("hero",heroName);
        args.putInt("cost",cost);
        cf.setArguments(args);
        return cf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHero = getArguments().getString("hero", "warrior");
        mCost = getArguments().getInt("cost",-1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cards_fragment, container,false);
        cards = CardsQueryDao.cardsQuery(MainActivity.db, mHero, mCost);
        GridView gv_cards = (GridView) view.findViewById(R.id.gv_cards);
        // 取消GridView的点击效果
        gv_cards.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gv_cards.setAdapter(new WarriorAdapter());
        pics = new String[cards.size()];
        for (int i = 0; i < cards.size(); i++) {
            pics[i] = cards.get(i).getPicName();
        }

        return view;
    }
    private class WarriorAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return cards.size();
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
            View view = View.inflate(getActivity(), R.layout.cards_item, null);
            ImageView iv_card = (ImageView) view.findViewById(R.id.iv_card);
            Uri uri = Uri.parse("/data/data/com.mxy.hearthstone/db/images/" + pics[position]);
            iv_card.setImageURI(uri);
            return view;
        }
    }
}
