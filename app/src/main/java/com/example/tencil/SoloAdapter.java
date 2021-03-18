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
    private final List<Solocompany> soloData;
    private Context mContext;

    public SoloAdapter(Context mContext, List<Solocompany> soloData) {
        this.soloData = soloData;
        this.mContext = mContext;
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


    }

    @Override
    public int getItemCount() {
        return soloData.size ();
    }

    public class SoloViewHolder extends RecyclerView.ViewHolder {
        LinearLayout sololayout;
        TextView soloname;


        public SoloViewHolder(View view) {
            super ( view );
            sololayout = view.findViewById ( R.id.sololayout );


        }
    }
}
