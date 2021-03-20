package com.example.tencil;

import android.content.Context;
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
        holder.business_name.setText ( mData.get ( position ).getBusiness_name () );
        holder.featured_desc.setText ( mData.get ( position ).getBdesc () );
        holder.featured_card.setOnClickListener ( v -> {
            Toast.makeText ( mContext, "Clicked", Toast.LENGTH_SHORT ).show ();


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
