package com.example.jsonapi;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class CharacterActivity extends AppCompatActivity {

    private List<AvatarCharacter> avatarCharactersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_character);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<AvatarCharacter> avatarCharacterList = (ArrayList<AvatarCharacter>) getIntent().getSerializableExtra("LIST_OF_CHARACTERS");
        ArrayAdapter<AvatarCharacter> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , avatarCharacterList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
    }
}