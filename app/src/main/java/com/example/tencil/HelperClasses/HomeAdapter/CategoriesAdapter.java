package com.example.tencil.HelperClasses.HomeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.R;

import java.util.ArrayList;

import static com.example.tencil.R.id.categories_card;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

    private final ArrayList<CategoriesAdapter> categoriesAdapter = new ArrayList<> ();
    private Context mContext;

    //Returns Categories View Dynamically
    public CategoriesAdapter.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View view = LayoutInflater.from ( mContext ).inflate ( R.layout.categories_card_design, parent, false );
        return new CategoriesAdapter.FeaturedViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //HOLDS VIEWS
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout categoriesCard;
        ImageView image;
        TextView title;
        TextView category;


        public FeaturedViewHolder(View itemView) {
            super ( itemView );
            //HOOKS
            categoriesCard = itemView.findViewById ( categories_card );
            image = itemView.findViewById ( R.id.categories_image );
            title = itemView.findViewById ( R.id.categories_title );
            category = itemView.findViewById ( R.id.categories_title );


        }
    }


}