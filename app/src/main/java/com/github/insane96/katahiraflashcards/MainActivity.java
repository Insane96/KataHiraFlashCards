package com.github.insane96.katahiraflashcards;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.insane96.katahiraflashcards.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    List<GroupButton> groupButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (JGroup jGroup : JGroup.NAME_MAP.values()) {
            GroupButton button = new GroupButton(this, jGroup);
            int resId = getResources().getIdentifier("jgroup_" + jGroup.name.toLowerCase(), "string", getPackageName());
            button.setText(resId != 0 ? getString(resId) : jGroup.name);
            groupButtons.add(button);
            binding.scrGroupListLL.addView(button);
        }
    }

    public void onStartClick(View v) {
        binding.btnStart.setVisibility(View.GONE);
        //binding.scrGroupList.setVisibility(View.GONE);

        ArrayList<JChar> chars = new ArrayList<>();
        for (GroupButton button : groupButtons) {
            if (button.isActivated())
                chars.addAll(button.getJGroup().jChars);

            button.setVisibility(View.GONE);
        }
        Collections.shuffle(chars);
        chars.forEach(jChar -> {

            //Button btnChar = new Button(this);
            //binding.scrGroupListLL.addView(btnChar);
            //btnChar.setText(jChar.roomaji + " " + jChar.hiragana + " " + jChar.katakana);
        });
    }
}