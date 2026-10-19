package com.example.jsonapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class AvatarCharacter implements Serializable {
    @SerializedName("_id")
    private String id;
    private String name;
    private String photoUrl;
    private String affiliation;
    private ArrayList<String> allies;
    private ArrayList<String> enemies;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhotoUrl() { return photoUrl; }
    public String getAffiliation() { return affiliation; }
    public ArrayList<String> getAllies() { return allies; }
    public ArrayList<String> getEnemies() { return enemies; }

    @Override
    public String toString() {
        return
                "Imię: " + name +
//                ", photoUrl='" + photoUrl + '\'' +
                "\nNacja: " + affiliation +
                "\nKompani: " + allies +
                "\nWrogowie:" + enemies;
    }
}