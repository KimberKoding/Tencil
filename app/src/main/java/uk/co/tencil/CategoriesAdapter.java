package uk.co.tencil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

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
        holder.category.setText ( mData.get ( position ).getName () );
        String val = String.valueOf ( mData.get ( position ).getCid () );

        cca = new CategoryCardActivity ();
        cca.setCid ( Integer.parseInt ( val ) );
        holder.categoriesCard.setOnClickListener ( v -> {
            Intent intent = new Intent ( mContext, CategoryCardActivity.class );
            intent.putExtra ( "category", temp.getName () );
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
    public class FeaturedViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout categoriesCard;
        TextView category;


        public FeaturedViewHolder(View itemView) {
            super ( itemView );
            //HOOKS
            categoriesCard = itemView.findViewById ( R.id.categories_card );
            category = itemView.findViewById ( R.id.categories_title );
        }
    }
}