package com.example.tencil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BusinessesAdapter extends RecyclerView.Adapter<BusinessesAdapter.MyViewHolder> {
    private static final String TAG = "businessadapter";
    private final List<Businesses> mData;
    private Context mContext;

    public BusinessesAdapter(Context mContext, List<Businesses> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public BusinessesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View view = LayoutInflater.from ( mContext ).inflate ( R.layout.featured_card_design, parent, false );
        return new BusinessesAdapter.MyViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessesAdapter.MyViewHolder holder, int position) {
        Businesses temp = mData.get ( position );
        holder.business_name.setText ( mData.get ( position ).getBusiness_name () );
        holder.featured_desc.setText ( mData.get ( position ).getBdesc () );
        holder.featured_card.setOnClickListener ( v -> {
            Toast.makeText ( mContext, "Clicked", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( mContext, FeaturedSolocompany.class );
            intent.putExtra ( "feat_name", temp.getBusiness_name () );
            intent.putExtra ( "feat_bdesc", temp.getBdesc () );
            mContext.startActivity ( intent );
            System.out.println ( "POP SMOKE" );


        } );


    }

    @Override
    public int getItemCount() {
        return mData.size ();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout featured_card;
        TextView business_name;
        TextView featured_desc;

        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );
            //HOOKS
            featured_card = itemView.findViewById ( R.id.featured_card );
            business_name = itemView.findViewById ( R.id.business_name );
            featured_desc = itemView.findViewById ( R.id.featured_desc );
        }
    }
}
