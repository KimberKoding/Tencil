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

public class GetAllBusinessesByCidAdapter extends RecyclerView.Adapter<GetAllBusinessesByCidAdapter.MyHolder> {

    private final List<Businesses> allData;
    private Context mContext;

    public GetAllBusinessesByCidAdapter(Context mContext, List<Businesses> allData) {
        this.mContext = mContext;
        this.allData = allData;
    }

    @NonNull
    @Override
    public GetAllBusinessesByCidAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext ();
        View v = LayoutInflater.from ( mContext ).inflate ( R.layout.categoriesallbusinesses, parent, false );


        return new GetAllBusinessesByCidAdapter.MyHolder ( v );
    }

    @Override
    public void onBindViewHolder(@NonNull GetAllBusinessesByCidAdapter.MyHolder holder, int position) {
        holder.setIsRecyclable ( false );
        holder.business_name.setText ( allData.get ( position ).getBusiness_name () );
        holder.cat_id.setText ( allData.get ( position ).getCat_id () );
        System.out.println ( allData.size () );

    }


    @Override
    public int getItemCount() {
        return allData.size ();

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


    public class MyHolder extends RecyclerView.ViewHolder {

        RelativeLayout allcatCard;
        TextView business_name;
        TextView cat_id;


        public MyHolder(@NonNull View itemView) {
            super ( itemView );

            allcatCard = itemView.findViewById ( R.id.business_card );
            business_name = itemView.findViewById ( R.id.business_namecard );
            cat_id = itemView.findViewById ( R.id.business_cid );


        }
    }
}