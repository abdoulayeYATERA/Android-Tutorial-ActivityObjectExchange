package com.yadevapp.activityobjectexchangetutorial.element;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by abdoulaye  on 7/7/16.
 * class representing a movie
 * it implement "Serializable" to be able to pass instance through intents
 * Serialization permitted an instance to be transformed into a byteArray
 */
public class Movie implements Parcelable {
    private final String TAG = getClass().getSimpleName();

    private String mName;
    private int mYear;
    private String mType;
    private int mDuration;
    private int mStarsNumber;

    //constructor

    public Movie() {

    }

    //getters

    public String getmName() {
        return mName;
    }

    public int getmYear() {
        return mYear;
    }

    public String getmType() {
        return mType;
    }

    public int getmDuration() {
        return mDuration;
    }

    public int getmStarsNumber() {
        return mStarsNumber;
    }

    //setters

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public void setmDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public void setmStarsNumber(int mStarsNumber) {
        this.mStarsNumber = mStarsNumber;
    }

    //parcelable


    /**
     * Movie creator, from parcel
     */
    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    /**
     * Movie constructor from parcel
     * Be careful ! the variables read and write order must be the same !!!!
     * see {@link Movie#writeToParcel(Parcel, int)}
     * @param in
     */
    protected Movie(Parcel in) {
        mName = in.readString();
        mYear = in.readInt();
        mType = in.readString();
        mDuration = in.readInt();
        mStarsNumber = in.readInt();
    }

    /**
     * write to parcel
     * Be careful ! the variables read and write order must be the same !!!
     * {@link Movie#Movie(Parcel)}
     * @param parcel
     * @param i
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeInt(mYear);
        parcel.writeString(mType);
        parcel.writeInt(mDuration);
        parcel.writeInt(mStarsNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
