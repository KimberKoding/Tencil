package com.example.tencil.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.R;
import com.example.tencil.User.CategoriesHelperClass;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

    ArrayList<CategoriesHelperClass> categories;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categories) {
        this.categories = categories;
    }


    @NonNull
    @Override
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


    }

    @Override
    public int getItemCount() {

        return categories.size ();
    }

    //HOLDS VIEWS
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;

        public FeaturedViewHolder(@NonNull View itemView) {
            super ( itemView );

            //HOOKS
            image = itemView.findViewById ( R.id.categories_image );
            title = itemView.findViewById ( R.id.categories_title );
        }
    }


}
