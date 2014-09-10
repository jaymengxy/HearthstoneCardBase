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
import com.mxy.hearthstone.R;
import com.mxy.hearthstone.db.dao.CardsQueryDao;
import com.mxy.hearthstone.domain.Card;
import com.mxy.hearthstone.hero.WarriorActivity;

import java.util.List;


/**
 * 所有卡牌的Fragment
 */
public class Fragment6 extends Fragment {
    private List<Card> warriorCards;
    private String[] pics;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cards_fragment, null);
        warriorCards = CardsQueryDao.warriorCardsQuery(WarriorActivity.db, 6);
        GridView gv_cards = (GridView) view.findViewById(R.id.gv_cards);
        // 取消GridView的点击效果
        gv_cards.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gv_cards.setAdapter(new WarriorAdapter());
        pics = new String[warriorCards.size()];
        for (int i = 0; i < warriorCards.size(); i++) {
            pics[i] = warriorCards.get(i).getPicName();
        }

        return view;
    }

    private class WarriorAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return warriorCards.size();
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