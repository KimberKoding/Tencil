package com.example.tencil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SoloAdapter extends RecyclerView.Adapter<SoloAdapter.SoloViewHolder> {
    private final List<Businesses> mData;
    private Context mContext;

    {
    }

    public SoloAdapter(Context mContext, List<Businesses> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public SoloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View view = LayoutInflater.from ( mContext ).inflate ( R.layout.company_solo_page, parent, false );
        return new SoloAdapter.SoloViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull SoloViewHolder holder, int position) {
        holder.Companycategory.setText ( mData.get ( position ).getCat_id () );
        holder.Companyname.setText ( mData.get ( position ).getBusiness_name () );
        holder.Companydesc.setText ( mData.get ( position ).getBusiness_desc () );
        holder.Social_media.setText ( mData.get ( position ).getSocial_media () );
        holder.Website.setText ( mData.get ( position ).getWebsite () );
        System.out.println ( mData.size () );

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

    public class SoloViewHolder extends RecyclerView.ViewHolder {
        LinearLayout solocard;
        TextView Companycategory;
        TextView Companyname;
        TextView Companydesc;
        TextView Social_media;
        TextView Website;


        public SoloViewHolder(View view) {
            super ( view );
            solocard = view.findViewById ( R.id.soloPage );
            Companycategory = view.findViewById ( R.id.categoryname );
            Companyname = view.findViewById ( R.id.textbusiness );
            Companydesc = view.findViewById ( R.id.company_desc );
            Social_media = view.findViewById ( R.id.socialmedia );
            Website = view.findViewById ( R.id.website );


        }
    }
}
