package uk.co.tencil.Businesses;

import androidx.annotation.Nullable;

public class BusinessesResponse {
    private Businesses[] businesses;

    @Nullable
    public Businesses[] getBusinesses() {
        return businesses;
    }

    public void setBusinesses(@Nullable Businesses[] businesses) {
        this.businesses = businesses;
    }
}
