package uk.co.tencil.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.tencil.R;


public class SliderAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;
    int[] images = {
            R.drawable.search_place,
            R.drawable.sit_back_and_relax,
            R.drawable.make_a_call,
            R.drawable.pws
    };
    int[] headings = {
            R.string.first_slide_title,
            R.string.second_slide_title,
            R.string.third_slide_title,
            R.string.fourth_slide_title
    };
    int[] description = {
            R.string.first_slide_desc,
            R.string.second_slide_desc,
            R.string.third_slide_desc,
            R.string.fourth_slide_desc
    };

    public SliderAdapter(Context context) {

        this.context = context;
    }

    @Override // RETURNS THE AMOUNT OF HEADINGS SET IN ARRAY 'headings'
    public int getCount() {
        return headings.length;
    }

    @Override // MAKING SURE THE VIEW RETURNED TO US IS A ConstrainntLayout
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    // REQUESTING DESIGN TO BE LOADED
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        View view = layoutInflater.inflate ( R.layout.slides_layout, container, false );

        // HOOKS FOR DESIGN
        ImageView imageView = view.findViewById ( R.id.slider_image );
        TextView heading = view.findViewById ( R.id.slider_heading );
        TextView desc = view.findViewById ( R.id.slider_desc );


        imageView.setImageResource ( images[position] );
        heading.setText ( headings[position] );
        desc.setText ( description[position] );

        container.addView ( view );

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView ( (ConstraintLayout) object );
    }
}
