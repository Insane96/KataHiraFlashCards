package com.github.insane96.katahiraflashcards;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

public class GroupButton extends AppCompatButton {
    private JGroup jGroup;

    public GroupButton(@NonNull Context context, JGroup jGroup) {
        super(context);
        this.jGroup = jGroup;
        setBackgroundResource(R.drawable.group_button_background);
        setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        setOnClickListener(v -> switchActiveState());
    }

    public void switchActiveState() {
        this.setActivated(!this.isActivated());
    }

    public JGroup getJGroup() {
        return this.jGroup;
    }
}
