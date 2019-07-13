package com.example.fivedaychallenge.widget;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fivedaychallenge.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileOverviewItemWidget extends LinearLayout {

    private CircleImageView imageView;
    private TextView headerText;
    private TextView valueText;

    public ProfileOverviewItemWidget(Context context) {
        this(context, null);
    }

    public ProfileOverviewItemWidget(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProfileOverviewItemWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.profile_overview_item, this);

        this.imageView = findViewById(R.id.inner_image_view);
        this.headerText = findViewById(R.id.header_text);
        this.valueText = findViewById(R.id.value_text);
    }

    public ProfileOverviewItemWidget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void display(Context context, @DrawableRes int imageRes, @ColorRes int imageTint, @StringRes int headerRes,
            String value) {
        imageView.setImageResource(imageRes);
        imageView.setColorFilter(ContextCompat.getColor(context, imageTint), android.graphics.PorterDuff.Mode.SRC_IN);
        headerText.setText(getContext().getString(headerRes));
        valueText.setText(value);
    }
}
