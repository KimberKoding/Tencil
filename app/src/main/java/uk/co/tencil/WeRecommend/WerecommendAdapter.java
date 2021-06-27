package uk.co.tencil.WeRecommend;

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
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;
import java.util.Random;

import uk.co.tencil.Businesses.Businesses;
import uk.co.tencil.Categories.CategoryCardActivity;
import uk.co.tencil.CompanyView.Solocompany;
import uk.co.tencil.R;

public class WerecommendAdapter extends RecyclerView.Adapter<WerecommendAdapter.MyHolder> {

    static int cid;
    private Context mcontext;
    TextView category;
    private CategoryCardActivity cca;
    private List<Businesses> mData;
    private WerecommendAdapter wra;

    public WerecommendAdapter() {

    }

    public int getCid() {
        System.out.println ( "getCid() method was called! CID is: " + cid );
        return cid;
    }

    public void setCid(int cid) {
        WerecommendAdapter.cid = cid;
        System.out.println ( "setCid() method was called! CID is now: " + WerecommendAdapter.cid );
    }


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
        wra = new WerecommendAdapter ();
        wra.setCid ( 1 );
        wra.getCid ();


        Businesses temp = mData.get ( position );
        // Dymamically Generating card background colours
        Random rnd = new Random ();
        int currentColour = Color.argb ( 255, rnd.nextInt ( 256 ), rnd.nextInt ( 256 ), rnd.nextInt ( 256 ) );
        holder.cardview.setBackgroundColor ( currentColour );
        System.out.println ( category );
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
            intent.putExtra ( "videos", temp.getVideos () );
            intent.putExtra ( "news", temp.getNews () );

            mcontext.startActivity ( intent );


        } );
    }

    @Override
    public int getItemCount() {
        cca = new CategoryCardActivity ();
        return mData.size ();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        TextView category;
        RelativeLayout werecommend;
        TextView businessname;
        ImageView businesslogo;
        LinearLayout cardview;

        VideoView videoView;


        public MyHolder(@NonNull View itemView) {
            super ( itemView );
            werecommend = itemView.findViewById ( R.id.werecommendrecycler );
            businessname = itemView.findViewById ( R.id.businessname );
            businesslogo = itemView.findViewById ( R.id.business_image );
            cardview = itemView.findViewById ( R.id.cardview );

            videoView = itemView.findViewById ( R.id.videoview );


        }
    }
}
