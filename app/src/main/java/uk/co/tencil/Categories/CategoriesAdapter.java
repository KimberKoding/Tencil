package uk.co.tencil.Categories;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Objects;

import uk.co.tencil.R;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.FeaturedViewHolder> {

    private Context mContext;
    private final List<Categories> mData;
    private CategoryCardActivity cca;


    public CategoriesAdapter(@Nullable Context mContext,
                             @Nullable List<Categories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    //Returns Categories View Dynamically
    @NotNull
    public CategoriesAdapter.FeaturedViewHolder onCreateViewHolder
    (@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View view = LayoutInflater.from ( mContext ).inflate
                (R.layout.categories_card_design, parent, false );
        return new FeaturedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        assert mData != null;
        Categories temp = mData.get ( position );

        holder.category.setText ( mData.get ( position ).getName () );


        holder.categoriesCard.setOnClickListener ( v -> {
            Intent intent = new Intent ( mContext, CategoryCardActivity.class );
            intent.putExtra ( "category", temp.getName () );
            String val = String.valueOf ( mData.get ( position ).getCid () );
            System.out.println ( mData.get ( position ).getCid () );
            System.out.println ( mData.get ( position ).getName () );
            cca = new CategoryCardActivity ();
            cca.setCid ( Integer.parseInt ( val ) );
            mContext.startActivity ( intent );
        } );

    }

    @Override
    public int getItemCount() {
        assert mData != null;
        return mData.size ();
    }

    //HOLDS VIEWS
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout categoriesCard;
        TextView category;


        public FeaturedViewHolder(@Nullable View itemView) {
            super (Objects.requireNonNull(itemView));
            //HOOKS
            categoriesCard = itemView.findViewById ( R.id.categories_card );
            category = itemView.findViewById ( R.id.categories_title );

        }

    }
}