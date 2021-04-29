package uk.co.tencil;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;
import java.util.Random;

public class WerecommendAdapter extends RecyclerView.Adapter<WerecommendAdapter.MyHolder> {

    private final List<Businesses> mData;
    private Context mcontext;
    private CategoryCardActivity cca;


    public WerecommendAdapter(Context mcontext, List<Businesses> mData) {
        this.mData = mData;
        this.mcontext = mcontext;
    }

    public WerecommendAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mcontext = parent.getContext ();
        View view = LayoutInflater.from ( mcontext ).inflate ( R.layout.recommend_card_design,
                parent, false );


        return new WerecommendAdapter.MyHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Businesses temp = mData.get ( position );
        // Dymamically Generating card background colours
        Random rnd = new Random ();
        int currentColour = Color.argb ( 255, rnd.nextInt ( 256 ), rnd.nextInt ( 256 ), rnd.nextInt ( 256 ) );
        holder.cardview.setBackgroundColor ( currentColour );
        // END

        holder.businessname.setText ( mData.get ( position ).getBusiness_name () );
        Glide.with ( mcontext )
                .asBitmap ()
                .load ( mData.get ( position ).getBusiness_img () )
                .diskCacheStrategy ( DiskCacheStrategy.ALL )
                .into ( holder.businesslogo );
        holder.cardview.setOnClickListener ( v -> {
            Intent intent = new Intent ( mcontext, Solocompany.class );
            intent.putExtra ( "bus_name", temp.getBusiness_name () );
            intent.putExtra ( "bdesc", temp.getBdesc () );
            intent.putExtra ( "Image_URL", temp.getBusiness_img () );
            intent.putExtra ( "contact", temp.getContact () );
            intent.putExtra ( "website", temp.getBusiness_website () );
            intent.putExtra ( "website_social", temp.getBusiness_website_social () );
            intent.putExtra ( "careers", temp.getCareers () );
            mcontext.startActivity ( intent );


        } );

    }

    @Override
    public int getItemCount() {
        cca = new CategoryCardActivity ();
        cca.setCid ( 2 );
        return mData.size ();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        TextView category;
        RelativeLayout werecommend;
        TextView businessname;
        ImageView businesslogo;
        LinearLayout cardview;


        public MyHolder(@NonNull View itemView) {
            super ( itemView );
            category = itemView.findViewById ( R.id.category );
            werecommend = itemView.findViewById ( R.id.werecommendrecycler );
            businessname = itemView.findViewById ( R.id.businessname );
            businesslogo = itemView.findViewById ( R.id.business_image );
            cardview = itemView.findViewById ( R.id.cardview );
        }
    }
}
