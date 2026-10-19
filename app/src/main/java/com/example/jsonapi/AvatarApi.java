package com.example.jsonapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AvatarApi {
    @GET("api/v1/characters")
    public Call<List<AvatarCharacter>> getCharacters(
            @Query("perPage") int perPage,
            @Query("page") int page
    );

    @GET("api/v1/characters/random")
    Call<List<AvatarCharacter>> getRandomCharacters(
            @Query("count") int count
    );

    @GET("api/v1/characters")
    Call<List<AvatarCharacter>> getCharacterByName(
            @Query("name") String name
    );
}
