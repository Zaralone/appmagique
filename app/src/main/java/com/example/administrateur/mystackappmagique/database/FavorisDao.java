package com.example.administrateur.mystackappmagique.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FavorisDao {

    @Query("SELECT * FROM Favoris")
    List<Favoris> getAllFavoris();

    @Insert
    void insertFavoris(Favoris... favoris);
}
