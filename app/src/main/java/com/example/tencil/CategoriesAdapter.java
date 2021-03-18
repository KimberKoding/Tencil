package com.example.tencil;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.example.tencil.R.id.categories_card;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

    private static final String TAG = "CategoriesAdapter"; // RYAN, PLEASE READ THE NAMING CONVENTIONS https://developer.android.com/reference/android/util/Log
    private Context mContext;
    private final List<Categories> mData;
    private CategoryCardActivity cca;


    public CategoriesAdapter(Context mContext, List<Categories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    //Returns Categories View Dynamically
    @NotNull
    public CategoriesAdapter.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View view = LayoutInflater.from ( mContext ).inflate ( R.layout.categories_card_design, parent, false );
        return new CategoriesAdapter.FeaturedViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        Categories temp = mData.get ( position );
        holder.setIsRecyclable ( false );
        holder.category.setText ( mData.get ( position ).getName () );
        String val = String.valueOf ( mData.get ( position ).getCid () );
        cca = new CategoryCardActivity ();
        cca.setCid ( Integer.parseInt ( val ) );
        holder.categoriesCard.setOnClickListener ( v -> {
            Log.d ( TAG, "onClick:Clicked on: " + mData.get ( position ).getName () );
            Log.d ( TAG, "onClick:Clicked on: " + mData.get ( position ).getCid () );

            Intent intent = new Intent ( mContext, CategoryCardActivity.class );
            intent.putExtra ( "category", temp.getName () );
            mContext.startActivity ( intent );
        } );
    }

    @Override
    public long getItemId(int position) {
        System.out.println ( position );
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        System.out.println ( "POSITION IS:" + position );
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size ();
    }

    public interface RecyclerViewClickInterface {
        void onItemClick(int position);
    }

    //HOLDS VIEWS
    public class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout categoriesCard;
        TextView category;


        RecyclerViewClickInterface recyclerViewClickInterface;


        public FeaturedViewHolder(View itemView) {
            super ( itemView );
            //HOOKS
            categoriesCard = itemView.findViewById ( categories_card );
            category = itemView.findViewById ( R.id.categories_title );
            itemView.setOnClickListener ( this );

        }

        @Override
        public void onClick(View v) {
            recyclerViewClickInterface.onItemClick ( getAdapterPosition () );

        }
    }
}