package com.github.insane96.katahiraflashcards;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CardButton extends AppCompatButton {
    public final JChar jChar;
    public boolean hiragana;
    public boolean inverse;

    private boolean hasBeenFlipped;

    private OnNextCardListener onNextCardListener;

    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT);

    public CardButton(@NonNull Context context, JChar jChar, boolean hiragana, boolean inverse, OnNextCardListener onNextCardListener) {
        super(context);
        this.jChar = jChar;
        this.hiragana = hiragana;
        this.inverse = inverse;

        this.onNextCardListener = onNextCardListener;

        if (this.inverse)
            this.setText(jChar.getRoomajiResId(this.getContext()));
        else if (this.hiragana)
            this.setText(jChar.hiragana);
        else
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
        if (this.inverse)
            this.setText(this.jChar.hiragana + " " + this.jChar.katakana);
        else
            this.setText(jChar.getRoomajiResId(this.getContext()));
        this.hasBeenFlipped = true;
    }

    public interface OnNextCardListener {
        void onNextCard();
    }
}
