package com.github.insane96.katahiraflashcards;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.insane96.katahiraflashcards.databinding.ActivityMainBinding;

import java.util.ArrayList;
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
}