package com.github.insane96.katahiraflashcards;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.insane96.katahiraflashcards.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements CardButton.OnNextCardListener {

    ActivityMainBinding binding;

    List<GroupButton> groupButtons = new ArrayList<>();

    ArrayList<JChar> chars = new ArrayList<>();
    short currentChar = 0;
    CardButton currentCardButton;
    Random random = new Random();

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

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (currentCardButton != null)
                    backToMain();
                else
                    finish();
            }
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
        binding.chkHiragana.setOnCheckedChangeListener(this::onUnckeckHiraKata);
        binding.chkKatakana.setOnCheckedChangeListener(this::onUnckeckHiraKata);
        binding.chkRoomaji.setOnCheckedChangeListener(this::onCheckRoomaji);
    }

    public void onStartClick(View v) {
        chars.clear();
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
        binding.txtProgress.setVisibility(View.VISIBLE);
        //binding.txtProgress.bringToFront();
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
        binding.txtProgress.setText(String.format("%d%%", (currentChar + 1) * 100 / chars.size()));
        if (++currentChar >= chars.size()) {
            backToMain();
            return;
        }
        createNextCardButton();
    }

    public void createNextCardButton() {
        JChar currentJChar = chars.get(currentChar);
        currentCardButton = new CardButton(this, currentJChar, getTypeFromRadioButton(), this);
        binding.getRoot().addView(currentCardButton);
    }

    public void backToMain() {
        binding.btnStart.setVisibility(View.VISIBLE);
        binding.scrGroupList.setVisibility(View.VISIBLE);
        binding.getRoot().removeView(currentCardButton);
        currentCardButton = null;
        currentChar = 0;
        binding.txtProgress.setText("0%");
        binding.txtProgress.setVisibility(View.INVISIBLE);
    }

    public CardButton.Type getTypeFromRadioButton() {
        if (binding.chkRoomaji.isChecked())
            return CardButton.Type.ROOMAJI;
        else if (binding.chkHiragana.isChecked() && binding.chkKatakana.isChecked())
            return random.nextBoolean() ? CardButton.Type.HIRAGANA : CardButton.Type.KATAKANA;
        else if (binding.chkHiragana.isChecked())
            return CardButton.Type.HIRAGANA;
        else if (binding.chkKatakana.isChecked())
            return CardButton.Type.KATAKANA;
        return CardButton.Type.HIRAGANA;
    }

    private void onUnckeckHiraKata(View v, boolean b) {
        if (!binding.chkHiragana.isChecked() && !binding.chkKatakana.isChecked()) {
            ((CheckBox)v).setChecked(true);
            Toast.makeText(this, R.string.uncheck_toast, Toast.LENGTH_SHORT).show();
        }
    }

    public void onCheckRoomaji(View v, boolean isChecked) {
        binding.chkHiragana.setEnabled(!isChecked);
        binding.chkKatakana.setEnabled(!isChecked);
    }
}