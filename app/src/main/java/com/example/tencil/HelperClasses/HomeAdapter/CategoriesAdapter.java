package com.example.tencil.HelperClasses.HomeAdapter;

<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
=======

import android.util.Log;
>>>>>>> origin/master
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tencil.R;
import com.example.tencil.socialMedia;

import java.util.ArrayList;

<<<<<<< HEAD
import static com.example.tencil.R.id.categories_card;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

    private final Context mContext;
    ArrayList<com.example.tencil.HelperClasses.HomeAdapter.CategoriesHelperClass> categories;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesHelperClasses, Context mContext) {
        this.categories = categoriesHelperClasses;
        this.mContext = mContext;


    }

=======
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


>>>>>>> origin/master
    //Returns Categories View Dynamically
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.categories_card_design, parent, false );
        ViewHolder holder = new ViewHolder ( view );
        return new ViewHolder ( view );
    }

    public void onBindViewHolder(ViewHolder holder, int position) {

<<<<<<< HEAD
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
=======
        Log.d ( TAG, "OnBindViewHolder: Called." );
        holder.image.setImageResource ( com.example.tencil.HelperClasses.HomeAdapter.CategoriesHelperClass.getImage () );
        holder.title.setText ( com.example.tencil.HelperClasses.HomeAdapter.CategoriesHelperClass.getTitle () );
        holder.parentLayout.setOnClickListener ( new View.OnClickListener () {

            public void onClick(View v) {
                Log.d ( TAG, "OnClick: Clicked on" + mImages.get ( position ) );
                Toast.makeText ( mcontext, (CharSequence) mTitle.get ( position ), Toast.LENGTH_SHORT ).show ();
            }
        } );

>>>>>>> origin/master

    }

    public int getItemCount() {

        return categories.size ();
    }

    //HOLDS VIEWS
<<<<<<< HEAD
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout categoriesCard;
=======
    public static class ViewHolder extends RecyclerView.ViewHolder {
>>>>>>> origin/master
        ImageView image;
        TextView title;
        RelativeLayout parentLayout;

<<<<<<< HEAD

        public FeaturedViewHolder(@NonNull View itemView) {
=======
        public ViewHolder(View itemView) {
>>>>>>> origin/master
            super ( itemView );


            //HOOKS
            categoriesCard = itemView.findViewById ( categories_card );
            image = itemView.findViewById ( R.id.categories_image );
            title = itemView.findViewById ( R.id.categories_title );
<<<<<<< HEAD

        }
    }


}
=======
            parentLayout = itemView.findViewById ( R.id.parentLayout );


        }

    }
}
>>>>>>> origin/master
