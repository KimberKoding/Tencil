package com.example.tencil;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.example.tencil.R.id.categories_card;
import static com.example.tencil.R.id.position;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

    private static final String TAG = "CategoriesAdapter"; // RYAN, PLEASE READ THE NAMING CONVENTIONS https://developer.android.com/reference/android/util/Log
    private Context mContext;
    private final List<Categories> mData;
    private final RecyclerViewClickInterface recyclerViewClickInterface;
    private CategoryCardActivity cca;


    public CategoriesAdapter(Context mContext, List<Categories> mData, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.mContext = mContext;
        this.mData = mData;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    //Returns Categories View Dynamically
    @NotNull
    public CategoriesAdapter.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View view = LayoutInflater.from ( mContext ).inflate ( R.layout.categories_card_design, parent, false );
        return new CategoriesAdapter.FeaturedViewHolder ( view, recyclerViewClickInterface );
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        final Categories temp = mData.get (position);
        holder.category.setText (mData.get (position).getName ());
        String val = String.valueOf(mData.get(position).getCid());
        cca = new CategoryCardActivity();
        cca.setCid(Integer.parseInt(val));
        Toast.makeText(mContext, val, Toast.LENGTH_LONG).show();
        holder.categoriesCard.setOnClickListener ( v -> {
            Log.d(TAG, "onClick:Clicked on: " + mData.get(position).getName());
            Log.d(TAG, "onClick:Clicked on: " + mData.get(position).getCid());

            Intent intent = new Intent ( mContext, CategoryCardActivity.class );
            intent.putExtra ( "category", temp.getName () );
            intent.putExtra ( "cat_id", temp.getCid () );
            intent.setFlags ( Intent.FLAG_ACTIVITY_NEW_TASK );
            mContext.startActivity ( intent );
        } );
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


        public FeaturedViewHolder(View itemView, RecyclerViewClickInterface recyclerViewClickInterface) {
            super ( itemView );
            //HOOKS
            categoriesCard = itemView.findViewById ( categories_card );
            category = itemView.findViewById ( R.id.categories_title );
            itemView.setOnClickListener ( this );
            this.recyclerViewClickInterface = recyclerViewClickInterface;
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickInterface.onItemClick ( getAdapterPosition () );

        }
    }
}