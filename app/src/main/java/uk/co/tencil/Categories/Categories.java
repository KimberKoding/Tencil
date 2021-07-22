package uk.co.tencil.Categories;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import uk.co.tencil.Businesses.JSONResponse;

public class Categories extends JSONResponse implements Parcelable {
    private final int cid;
    private final String name;

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

    protected Categories(@Nullable Parcel in) {
        assert in != null;
        cid = in.readInt ();
        name = in.readString ();
    }

    public int getCid() {
        return cid;
    }


    @Nullable
    public String getName() {
        return name.substring ( 0, 1 ).toUpperCase () + name.substring ( 1 );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@Nullable Parcel dest, int flags) {
        assert dest != null;
        dest.writeInt ( cid );
        dest.writeString ( name );
    }
}
