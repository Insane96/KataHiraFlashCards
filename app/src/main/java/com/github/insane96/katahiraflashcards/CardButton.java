package com.github.insane96.katahiraflashcards;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class CardButton extends AppCompatButton {
    public final JChar jChar;
    public boolean hiragana;
    public boolean katakana;
    public boolean inverse;

    public CardButton(@NonNull Context context, JChar jChar) {
        super(context);
        this.jChar = jChar;
    }
}
