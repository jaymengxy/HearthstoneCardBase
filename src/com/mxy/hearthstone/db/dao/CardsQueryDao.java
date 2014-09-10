package com.mxy.hearthstone.db.dao;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mxy.hearthstone.domain.Card;

import java.util.ArrayList;
import java.util.List;

public class CardsQueryDao {

    public static List<Card> cardsQuery(SQLiteDatabase db,String heroName, int cost) {
        List<Card> cards = new ArrayList<Card>();
        Cursor cursor;
        if (cost >= 0 && cost <= 6) {
            cursor = db.rawQuery("select * from cards where class = ? and cost = ?",new String[]{heroName,String.valueOf(cost)});
        } else if (cost > 6) {
            cursor = db.rawQuery("select * from cards where class = ? and cost > '6'", new String[]{heroName});

        } else {
            cursor = db.rawQuery("select * from cards where class = ?", new String[]{heroName});
        }
        while (cursor.moveToNext()) {
            Card card = new Card();
            card.setCardName(cursor.getString(cursor.getColumnIndex("cardName")));
            card.setCardType(cursor.getString(cursor.getColumnIndex("cardType")));
            card.setCardEffect(cursor.getString(cursor.getColumnIndex("cardEffect")));
            card.setCost(cursor.getInt(cursor.getColumnIndex("cost")));
            card.setDescription(cursor.getString(cursor.getColumnIndex("description")));
            card.setHeroName(cursor.getString(cursor.getColumnIndex("class")));
            card.setPicName(cursor.getString(cursor.getColumnIndex("code")));
            card.setQuality(cursor.getString(cursor.getColumnIndex("quality")));
            cards.add(card);
        }
        cursor.close();
        return cards;
    }
}
