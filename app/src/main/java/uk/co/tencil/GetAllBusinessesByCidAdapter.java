package uk.co.tencil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        Businesses temp = allData.get ( position );
        holder.business_name.setText ( allData.get ( position ).getBusiness_name () );
        System.out.println ( allData.size () );
        holder.allcatCard.setOnClickListener ( v -> {
            Toast.makeText ( mContext, "Clicked", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( mContext, Solocompany.class );
            intent.putExtra ( "bus_name", temp.getBusiness_name () );
            intent.putExtra ( "bdesc", temp.getBdesc () );
            intent.putExtra ( "Image_URL", temp.getBusiness_img () );
            intent.putExtra ( "contact", temp.getContact () );
            intent.putExtra ( "website", temp.getBusiness_website () );
            intent.putExtra ( "website_social", temp.getBusiness_website_social () );
            intent.putExtra ( "careers", temp.getCareers () );


            mContext.startActivity ( intent );
        } );

    }


    @Override
    public int getItemCount() {
        return allData.size ();

    }
    public class MyHolder extends RecyclerView.ViewHolder {

        RelativeLayout allcatCard;
        TextView business_name;
        TextView bdesc;
        ImageView business_logocard;


        public MyHolder(@NonNull View itemView) {
            super ( itemView );

            allcatCard = itemView.findViewById ( R.id.business_card );
            business_name = itemView.findViewById ( R.id.business_namecard );
            bdesc = itemView.findViewById ( R.id.bdesc );
            business_logocard = itemView.findViewById ( R.id.business_logocard );


        }
    }

}