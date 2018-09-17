package com.example.administrateur.mystackappmagique.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.administrateur.mystackappmagique.api.pojo.Item;

import java.util.List;

@Dao
public interface FavorisDao {

    @Query("SELECT * FROM Favoris")
    List<Item> getAllFavoris();

    @Insert
    void insertFavoris(Item ... item);
}
