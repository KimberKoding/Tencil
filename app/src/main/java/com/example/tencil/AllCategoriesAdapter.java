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

public class AllCategoriesAdapter extends RecyclerView.Adapter<AllCategoriesAdapter.FeaturedViewHolder> {
    private final List<AllCategories> mData;
    private final RecyclerViewClickInterface recyclerViewClickInterface;
    private Context mContext;

    public AllCategoriesAdapter(Context mContext, List<AllCategories> mData, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.mContext = mContext;
        this.mData = mData;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @Override
    //RETURN ALL CATEGORIES
    public AllCategoriesAdapter.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View v = LayoutInflater.from ( mContext ).inflate ( R.layout.all_categories_card, parent, false );
        return new AllCategoriesAdapter.FeaturedViewHolder ( v );
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoriesAdapter.FeaturedViewHolder holder, int position) {
        holder.selected_category.setText ( mData.get ( position ).getBusiness_category () );

    }

    @Override
    public int getItemCount() {
        return mData.size ();
    }


    public interface onNoteListener {
        void onNoteClick(int position);
    }

    public class FeaturedViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout allcategorycard;
        TextView selected_category;
        TextView business_name;

        public FeaturedViewHolder(View v) {
            super ( v );
            //HOOKS
            allcategorycard = v.findViewById ( R.id.business_card );
            selected_category = v.findViewById ( R.id.selectedcategory );
            business_name = v.findViewById ( R.id.business_namecard );
        }

    }


}
