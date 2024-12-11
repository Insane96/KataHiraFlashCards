package com.github.insane96.katahiraflashcards;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CardButton extends AppCompatButton {
    public final JChar jChar;
    public Type type;

    private boolean hasBeenFlipped;

    private final OnNextCardListener onNextCardListener;

    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT);

    public CardButton(@NonNull Context context, JChar jChar, Type type, OnNextCardListener onNextCardListener) {
        super(context);
        this.jChar = jChar;
        this.type = type;

        this.onNextCardListener = onNextCardListener;

        if (this.type == Type.ROOMAJI)
            this.setText(jChar.getRoomajiResId(this.getContext()));
        else if (this.type == Type.HIRAGANA)
            this.setText(jChar.hiragana);
        else if (this.type == Type.KATAKANA)
            this.setText(jChar.katakana);

        this.setLayoutParams(layoutParams);
        this.setTextSize(118f);
        setOnClickListener(v -> flip());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    public void flip() {
        if (this.hasBeenFlipped) {
            this.onNextCardListener.onNextCard();
            return;
        }
        if (this.type == Type.ROOMAJI)
            this.setText(getContext().getString(R.string.hira_kata, jChar.hiragana, jChar.katakana));
        else
            this.setText(jChar.getRoomajiResId(this.getContext()));
        this.hasBeenFlipped = true;
    }

    public enum Type {
        HIRAGANA,
        KATAKANA,
        ROOMAJI
    }

    public interface OnNextCardListener {
        void onNextCard();
    }
}
