package com.github.insane96.katahiraflashcards;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class CardButton extends AppCompatButton {
    public final JChar jChar;
    public boolean hiragana;
    public boolean inverse;

    public CardButton(@NonNull Context context, JChar jChar, boolean hiragana, boolean inverse) {
        super(context);
        this.jChar = jChar;
        this.hiragana = hiragana;
        this.inverse = inverse;

        if (this.inverse)
            this.setText(jChar.roomaji);
        else if (this.hiragana)
            this.setText(jChar.hiragana);
        else
            this.setText(jChar.katakana);

        this.setTextSize(18f);
    }
}
