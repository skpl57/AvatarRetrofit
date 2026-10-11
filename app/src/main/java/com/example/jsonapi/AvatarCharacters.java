package com.example.jsonapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AvatarCharacters {
    @SerializedName("_id")
    private String id;
    private String name;
    private String photoUrl;
    private String affiliation;
    private List<String> allies;
    private List<String> enemies;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhotoUrl() { return photoUrl; }
    public String getAffiliation() { return affiliation; }
    public List<String> getAllies() { return allies; }
    public List<String> getEnemies() { return enemies; }
}