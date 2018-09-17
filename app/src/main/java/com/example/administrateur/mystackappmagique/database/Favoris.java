package com.example.administrateur.mystackappmagique.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.widget.ImageView;

import java.util.Date;

@Entity
public class Favoris {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private ImageView image;
    private String description;
    private Date date;

    public Favoris(ImageView image, String description, Date date) {
        this.image = image;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
