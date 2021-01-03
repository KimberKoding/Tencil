package com.example.tencil.HelperClasses.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.FeaturedBusiness;
import com.example.tencil.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredBusinesses;

    //HOLDS DATA
    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredBusinesses) {
        this.featuredBusinesses = featuredBusinesses;
    }

    @NonNull
    @Override
    //Returns Featured View Dynamically
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.featured_card_design, parent, false );
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder ( view );
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredBusinesses.get ( position );

        holder.image.setImageResource ( featuredHelperClass.getImage () );
        holder.title.setText ( featuredHelperClass.getTitle () );
        holder.desc.setText ( featuredHelperClass.getDescription () );
        holder.itemView.setOnClickListener ( new View.OnClickListener () {

            public void onClick(View v) {
                System.out.println ( "THISISBORKED" );
                Intent intent = new Intent ( v.getContext (), FeaturedBusiness.class );
                v.getContext ().startActivity ( intent );
                System.out.println ( "THIS WORKS" );


            }

        } );

    }

    @Override
    public int getItemCount() {

        return featuredBusinesses.size ();
    }


    //HOLDS VIEWS
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super ( itemView );

            //HOOKS
            image = itemView.findViewById ( R.id.featured_image );
            title = itemView.findViewById ( R.id.featured_title );
            desc = itemView.findViewById ( R.id.featured_desc );
        }
    }


}
