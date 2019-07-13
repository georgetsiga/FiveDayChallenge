package com.example.fivedaychallenge.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.fivedaychallenge.R;

public class MyProfile implements Parcelable {
    private String mName;
    private String mCountry;
    private String mTrack;
    private String mEmail;
    private String mPhone;
    private String mSlack;

    public MyProfile(Context context) {
        this.mName = context.getString(R.string.my_name);
        this.mTrack = context.getString(R.string.track_name);
        this.mCountry = context.getString(R.string.country_name);
        this.mEmail = context.getString(R.string.email_address_name);
        this.mPhone = context.getString(R.string.phone_number_name);
        this.mSlack = context.getString(R.string.slack_username_name);
    }

    public MyProfile(Parcel source) {
        this.mName = source.readString();
        this.mTrack = source.readString();
        this.mCountry = source.readString();
        this.mEmail = source.readString();
        this.mPhone = source.readString();
        this.mSlack = source.readString();
    }

    public String getName() {
        return mName;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getTrack() {
        return mTrack;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getSlack() {
        return mSlack;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mTrack);
        parcel.writeString(mCountry);
        parcel.writeString(mEmail);
        parcel.writeString(mPhone);
        parcel.writeString(mSlack);
    }

    public static final Parcelable.Creator<MyProfile> CREATOR = new Parcelable.Creator<MyProfile>() {

        @Override
        public MyProfile createFromParcel(Parcel parcel) {
            return new MyProfile(parcel);
        }

        @Override
        public MyProfile[] newArray(int i) {
            return new MyProfile[i];
        }
    };
}
