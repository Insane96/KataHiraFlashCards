package com.github.insane96.katahiraflashcards;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.insane96.katahiraflashcards.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardButton.OnNextCardListener {

    ActivityMainBinding binding;

    List<GroupButton> groupButtons = new ArrayList<>();

    ArrayList<JChar> chars;
    short currentChar = 0;
    CardButton currentCardButton;

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

        /*for (JChar jChar : JChar.values()) {
            Log.i("JChar", "<string name=\"jchar_" + jChar.name().toLowerCase() + "\">" + jChar.roomaji + "</string>");
        }*/

        for (JGroup jGroup : JGroup.NAME_MAP.values()) {
            GroupButton button = new GroupButton(this, jGroup);
            int resId = getResources().getIdentifier("jgroup_" + jGroup.name.toLowerCase(), "string", getPackageName());
            button.setText(resId != 0 ? getString(resId) : jGroup.name);
            groupButtons.add(button);
            binding.scrGroupListLL.addView(button);
        }

        binding.btnStart.setOnLongClickListener(this::onStartLongClick);
    }

    public void onStartClick(View v) {
        chars = new ArrayList<>();
        for (GroupButton button : groupButtons) {
            if (button.isActivated())
                chars.addAll(button.getJGroup().jChars);
        }
        if (chars.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle(R.string.select_one_title)
                    .setMessage(R.string.select_one_message)
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
            builder.show();
            return;
        }
        binding.btnStart.setVisibility(View.GONE);
        binding.scrGroupList.setVisibility(View.GONE);
        Collections.shuffle(chars);
        createNextCardButton();
    }

    public boolean onStartLongClick(View v) {
        for (GroupButton button : groupButtons) {
            button.setActivated(!button.isActivated());
        }
        return true;
    }

    public void onInfoClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(R.string.info_title)
                .setMessage(R.string.info_message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    @Override
    public void onNextCard() {
        binding.getRoot().removeView(currentCardButton);
        if (++currentChar >= chars.size()) {
            binding.btnStart.setVisibility(View.VISIBLE);
            binding.scrGroupList.setVisibility(View.VISIBLE);
            currentChar = 0;
            return;
        }
        createNextCardButton();
    }

    public void createNextCardButton() {
        JChar currentJChar = chars.get(currentChar);
        currentCardButton = new CardButton(this, currentJChar, getTypeFromRadioButton(), this);
        binding.getRoot().addView(currentCardButton);
    }

    public CardButton.Type getTypeFromRadioButton() {
        if (binding.rbHiragana.isChecked())
            return CardButton.Type.HIRAGANA;
        else if (binding.rbKatakana.isChecked())
            return CardButton.Type.KATAKANA;
        else if (binding.rbRoomaji.isChecked())
            return CardButton.Type.ROOMAJI;
        return CardButton.Type.HIRAGANA;
    }
}