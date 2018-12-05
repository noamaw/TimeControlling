package com.example.noamw.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class TimerObject implements Parcelable {
    long startTimer;
    String description;

    public TimerObject(String description, long startTime) {
        this.description = description;
        this.startTimer = startTime;
    }

    private TimerObject(Parcel in) {
        description = in.readString();
        startTimer = in.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public long getStartTimer() { return startTimer; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return description + ". started at: " + startTimer; //TODO change the way startTime is viewed.
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(description);
        out.writeLong(startTimer);
    }

    public static final Parcelable.Creator<TimerObject> CREATOR = new Parcelable.Creator<TimerObject>() {
        public TimerObject createFromParcel(Parcel in) {
            return new TimerObject(in);
        }

        public TimerObject[] newArray(int size) {
            return new TimerObject[size];
        }
    };
}