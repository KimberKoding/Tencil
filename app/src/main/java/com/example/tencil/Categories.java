package com.example.tencil;

import android.os.Parcel;
import android.os.Parcelable;

public class Categories extends JSONResponse implements Parcelable {
    public static final Creator<Categories> CREATOR = new Creator<Categories> () {
        @Override
        public Categories createFromParcel(Parcel in) {
            return new Categories ( in );
        }

        @Override
        public Categories[] newArray(int size) {
            return new Categories[size];
        }
    };
    //Model Class
    private final String cid;
    private final String name;

    protected Categories(Parcel in) {
        cid = in.readString ();
        name = in.readString ();
    }

    public String getCid() {
        return cid;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString ( cid );
        dest.writeString ( name );
    }
}
