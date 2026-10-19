package com.example.jsonapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<AvatarCharacter> avatarCharactersList;
    private Button searchBTN;
    private Button randomBTN;
    private Button affiliationBTN;

    private EditText characterName;

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
        searchBTN = findViewById(R.id.searchBTN);
        randomBTN = findViewById(R.id.randomBTN);
        affiliationBTN = findViewById(R.id.affiliationBTN);
        characterName = findViewById(R.id.nameOfCharacter);




        randomBTN.setOnClickListener(
                v -> {
                    Call<List<AvatarCharacter>> randomCall = avatarApi.getRandomCharacters(1);

                    randomCall.enqueue(
                            new Callback<List<AvatarCharacter>>() {
                                @Override
                                public void onResponse(Call<List<AvatarCharacter>> call, Response<List<AvatarCharacter>> response) {
                                    if(!response.isSuccessful()){
                                        Log.e("AvatarApp", "Błąd połączenia: " + response.code());
                                        return;
                                    }
                                    avatarCharactersList = (ArrayList<AvatarCharacter>) response.body();

                                    Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
                                    intent.putExtra("LIST_OF_CHARACTERS", avatarCharactersList);
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<List<AvatarCharacter>> call, Throwable t) {
                                    Log.e("AvatarApp", "Błąd połączenia: " + t.getMessage());
                                }
                            }
                    );
                }
        );

        searchBTN.setOnClickListener(
                v -> {



                    Call<List<AvatarCharacter>> randomCall = avatarApi.getRandomCharacters(1);

                    randomCall.enqueue(
                            new Callback<List<AvatarCharacter>>() {
                                @Override
                                public void onResponse(Call<List<AvatarCharacter>> call, Response<List<AvatarCharacter>> response) {
                                    if(!response.isSuccessful()){
                                        Log.e("AvatarApp", "Błąd połączenia: " + response.code());
                                        return;
                                    }
                                    avatarCharactersList = (ArrayList<AvatarCharacter>) response.body();

                                    Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
                                    intent.putExtra("LIST_OF_CHARACTERS", avatarCharactersList);
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<List<AvatarCharacter>> call, Throwable t) {
                                    Log.e("AvatarApp", "Błąd połączenia: " + t.getMessage());
                                }
                            }
                    );
                }
        );

        affiliationBTN.setOnClickListener(
                v -> {
                    Call<List<AvatarCharacter>> randomCall = avatarApi.getRandomCharacters(1);

                    randomCall.enqueue(
                            new Callback<List<AvatarCharacter>>() {
                                @Override
                                public void onResponse(Call<List<AvatarCharacter>> call, Response<List<AvatarCharacter>> response) {
                                    if(!response.isSuccessful()){
                                        Log.e("AvatarApp", "Błąd połączenia: " + response.code());
                                        return;
                                    }
                                    avatarCharactersList = (ArrayList<AvatarCharacter>) response.body();

                                    Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
                                    intent.putExtra("LIST_OF_CHARACTERS", avatarCharactersList);
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<List<AvatarCharacter>> call, Throwable t) {
                                    Log.e("AvatarApp", "Błąd połączenia: " + t.getMessage());
                                }
                            }
                    );
                }
        );
    }
}