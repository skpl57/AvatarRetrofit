package com.example.jsonapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<AvatarCharacter> avatarCharactersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://last-airbender-api.fly.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AvatarApi avatarApi = retrofit.create(AvatarApi.class);

        Call<List<AvatarCharacter>> call = avatarApi.getRandomCharacters(1);

        call.enqueue(
                new Callback<List<AvatarCharacter>>() {
                    @Override
                    public void onResponse(Call<List<AvatarCharacter>> call, Response<List<AvatarCharacter>> response) {
                        if(!response.isSuccessful()){
                            Log.e("AvatarApp", "Błąd połączenia: " + response.code());
                            return;
                        }
                        AvatarCharacter character = response.body().get(0);
                        Log.d("AvatarApp", "Imię: " + character.getName());
                        Log.d("AvatarApp", "Frakcja: " + character.getAffiliation());
                        Log.d("AvatarApp", "Link do zdjęcia: " + character.getPhotoUrl());
//                        avatarCharactersList = response.body();
                    }

                    @Override
                    public void onFailure(Call<List<AvatarCharacter>> call, Throwable t) {
                        Log.e("AvatarApp", "Błąd połączenia: " + t.getMessage());
                    }
                }
        );
    }
}