package com.example.tencil.HelperClasses.HomeAdapter;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.R;
import com.example.tencil.User.CategoriesHelperClass;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    ArrayList<CategoriesHelperClass> categories;
    private ArrayList<CategoriesHelperClass> mTitle = new ArrayList<> ();
    private ArrayList<CategoriesHelperClass> mImages = new ArrayList<> ();
    private android.content.Context mcontext;


    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categories) {
        this.categories = categories;
        this.mTitle = mTitle;
        this.mImages = mImages;
        this.mcontext = mcontext;
    }


    //Returns Categories View Dynamically
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.categories_card_design, parent, false );
        ViewHolder holder = new ViewHolder ( view );
        return new ViewHolder ( view );
    }

    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d ( TAG, "OnBindViewHolder: Called." );
        holder.image.setImageResource ( com.example.tencil.HelperClasses.HomeAdapter.CategoriesHelperClass.getImage () );
        holder.title.setText ( com.example.tencil.HelperClasses.HomeAdapter.CategoriesHelperClass.getTitle () );
        holder.parentLayout.setOnClickListener ( new View.OnClickListener () {

            public void onClick(View v) {
                Log.d ( TAG, "OnClick: Clicked on" + mImages.get ( position ) );
                Toast.makeText ( mcontext, (CharSequence) mTitle.get ( position ), Toast.LENGTH_SHORT ).show ();
            }
        } );


    }

    public int getItemCount() {

        return categories.size ();
    }

    //HOLDS VIEWS
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super ( itemView );


            //HOOKS
            image = itemView.findViewById ( R.id.categories_image );
            title = itemView.findViewById ( R.id.categories_title );
            parentLayout = itemView.findViewById ( R.id.parentLayout );


        }

    }
}
