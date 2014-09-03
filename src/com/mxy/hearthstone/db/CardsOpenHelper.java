package com.mxy.hearthstone.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CardsOpenHelper extends SQLiteOpenHelper{
    public CardsOpenHelper(Context context) {
        super(context, "cards.db", null, 1);
    }
    /**
     * 创建表 cards
     * _id主键 自动增长
     * name 名字 varchar(100)
     * type 类型 varchar(20)
     * quality 品质 varchar(20)
     * costs 消耗 integer(2)
     * heroName 所属英雄 varchar(20)
     * location 图片位置 varchar(100)
     *
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cards(_id integer primary key autoincrement,name varchar(100),type varchar(20),quality varchar(20),costs integer(2),heroName varchar(20),location varchar(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
