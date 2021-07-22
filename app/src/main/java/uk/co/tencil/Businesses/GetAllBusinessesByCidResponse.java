package uk.co.tencil.Businesses;

import androidx.annotation.Nullable;

public class GetAllBusinessesByCidResponse {

    private final Businesses[] businesses;

    public GetAllBusinessesByCidResponse(@Nullable Businesses[] businesses) {
        this.businesses = businesses;
    }

    @Nullable
    public Businesses[] getAllBusinessesByCid() {
        return businesses;
    }


}
