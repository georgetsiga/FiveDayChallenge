package com.example.fivedaychallenge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.fivedaychallenge.data.MyProfile;
import com.example.fivedaychallenge.widget.ProfileOverviewItemWidget;

public class MyProfileActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private static String MY_PROFILE = "MY_PROFILE";
    private static String ERROR = "Error";

    @BindView(R.id.text_name) TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        ButterKnife.bind(this);
        loadProfile();
    }

    public static Intent newInstance(Context context, MyProfile myProfile) {
        Intent intent = new Intent(context, MyProfileActivity.class);
        intent.putExtra(MY_PROFILE, myProfile);
        return intent;
    }

    private void loadProfile() {
        LinearLayout layoutContent = findViewById(R.id.layoutContent);
        layoutContent.removeAllViews();
        if (getIntent() == null || getIntent().getExtras() == null) {
            ProfileOverviewItemWidget errorWidget = new ProfileOverviewItemWidget(this);
            errorWidget.display(this, R.drawable.ic_error_black_24dp, R.color.text_red, R.string.error, ERROR);
            layoutContent.addView(errorWidget);
            return;
        }

        MyProfile myProfile = getIntent().getExtras().getParcelable(MY_PROFILE);
        if (myProfile == null) {
            ProfileOverviewItemWidget errorWidget = new ProfileOverviewItemWidget(this);
            errorWidget.display(this, R.drawable.ic_error_black_24dp, R.color.text_red, R.string.error, ERROR);
            layoutContent.addView(errorWidget);
            return;
        }

        name.setText(myProfile.getName());

        if (myProfile.getTrack() != null) {
            ProfileOverviewItemWidget trackWidget = new ProfileOverviewItemWidget(this);
            trackWidget.display(this, R.drawable.ic_person_black_24dp, R.color.andela_blue, R.string.track, myProfile.getTrack());
            layoutContent.addView(trackWidget);
        }
        if (myProfile.getCountry() != null) {
            ProfileOverviewItemWidget countryWidget = new ProfileOverviewItemWidget(this);
            countryWidget.display(this, R.drawable.ic_account_balance_black_24dp, R.color.andela_blue, R.string.country,
                    myProfile.getCountry());
            layoutContent.addView(countryWidget);
        }
        if (myProfile.getEmail() != null) {
            ProfileOverviewItemWidget emailWidget = new ProfileOverviewItemWidget(this);
            emailWidget.display(this, R.drawable.ic_send_black_24dp, R.color.andela_blue, R.string.email_address,
                    myProfile.getEmail());
            layoutContent.addView(emailWidget);
        }
        if (myProfile.getPhone() != null) {
            ProfileOverviewItemWidget phoneNumberWidget = new ProfileOverviewItemWidget(this);
            phoneNumberWidget.display(this, R.drawable.ic_local_phone_black_24dp, R.color.andela_blue, R.string.phone_number,
                    myProfile.getPhone());
            layoutContent.addView(phoneNumberWidget);
        }
        if (myProfile.getSlack() != null) {
            ProfileOverviewItemWidget slackHandleWidget = new ProfileOverviewItemWidget(this);
            slackHandleWidget.display(this, R.drawable.ic_message_black_24dp, R.color.andela_blue, R.string.slack_username,
                    myProfile.getSlack());
            layoutContent.addView(slackHandleWidget);
        }
    }
}
