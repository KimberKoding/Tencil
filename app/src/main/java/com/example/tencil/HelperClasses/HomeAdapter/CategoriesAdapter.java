package com.example.tencil.HelperClasses.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.R;
import com.example.tencil.socialMedia;

import java.util.ArrayList;

import static com.example.tencil.R.id.categories_card;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

    private final Context mContext;
    ArrayList<com.example.tencil.HelperClasses.HomeAdapter.CategoriesHelperClass> categories;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesHelperClasses, Context mContext) {
        this.categories = categoriesHelperClasses;
        this.mContext = mContext;


    }

    //Returns Categories View Dynamically
    public CategoriesAdapter.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.categories_card_design, parent, false );
        return new FeaturedViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        CategoriesHelperClass categoriesHelperClass = categories.get ( position );

        holder.image.setImageResource ( categoriesHelperClass.getImage () );
        holder.title.setText ( categoriesHelperClass.getTitle () );
        holder.categoriesCard.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                System.out.println ( "THISISBORKED" );
                Intent intent = new Intent ( v.getContext (), socialMedia.class );
                v.getContext ().startActivity ( intent );
                System.out.println ( "THIS WORKS" );
            }
        } );

    }

    @Override
    public int getItemCount() {

        return categories.size ();
    }

    //HOLDS VIEWS
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout categoriesCard;
        ImageView image;
        TextView title;


        public FeaturedViewHolder(@NonNull View itemView) {
            super ( itemView );

            //HOOKS
            categoriesCard = itemView.findViewById ( categories_card );
            image = itemView.findViewById ( R.id.categories_image );
            title = itemView.findViewById ( R.id.categories_title );

        }
    }


}