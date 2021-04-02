package com.example.tencil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class FeaturedSoloCompanyAdapter extends RecyclerView.Adapter<BusinessesAdapter.MyViewHolder> {
    private static final String TAG = "FeaturedSoloCompanyAdapter";
    private final List<Businesses> mData;
    private Context mContext;

    public FeaturedSoloCompanyAdapter(List<Businesses> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    public BusinessesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View v = LayoutInflater.from ( mContext ).inflate ( R.layout.featuredsolopage, parent, false );
        return new BusinessesAdapter.MyViewHolder ( v );
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessesAdapter.MyViewHolder holder, int position) {
        Glide.with ( mContext )
                .asBitmap ()
                .load ( mData.get ( position ).getBusiness_img () )
                .diskCacheStrategy ( DiskCacheStrategy.ALL )
                .into ( holder.featured_image );

    }

    @Override
    public int getItemCount() {
        return mData.size ();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout featured_card;
        TextView business_name;
        TextView featured_desc;
        ImageView featured_image;

        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );
            //HOOKS
            featured_card = itemView.findViewById ( R.id.featured_card );
            business_name = itemView.findViewById ( R.id.business_name );
            featured_desc = itemView.findViewById ( R.id.featured_desc );
            featured_image = itemView.findViewById ( R.id.featured_image );
        }
    }
}
