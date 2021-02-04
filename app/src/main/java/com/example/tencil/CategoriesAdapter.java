package com.example.tencil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.tencil.R.id.categories_card;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

    private Context mContext;
    private final List<Movie> mData;

    public CategoriesAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    //Returns Categories View Dynamically
    public CategoriesAdapter.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View view = LayoutInflater.from ( mContext ).inflate ( R.layout.categories_card_design, parent, false );
        return new CategoriesAdapter.FeaturedViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        holder.category.setText ( mData.get ( position ).getName () );
        holder.cid.setText ( mData.get ( position ).getCid () );
    }

    @Override
    public int getItemCount() {
        return mData.size ();
    }

    //HOLDS VIEWS
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout categoriesCard;
        TextView cid;
        TextView category;


        public FeaturedViewHolder(View itemView) {
            super ( itemView );
            //HOOKS
            categoriesCard = itemView.findViewById ( categories_card );
            cid = itemView.findViewById ( R.id.categories_cid );
            category = itemView.findViewById ( R.id.categories_title );


        }
    }


}