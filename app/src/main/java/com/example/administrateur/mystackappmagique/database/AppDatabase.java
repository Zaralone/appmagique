package com.example.administrateur.mystackappmagique.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.administrateur.mystackappmagique.Fragments.Favoris;
import com.example.administrateur.mystackappmagique.api.pojo.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;

    public static AppDatabase getINSTANCE(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "ITEM").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public abstract FavorisDao favorisDao();
}
