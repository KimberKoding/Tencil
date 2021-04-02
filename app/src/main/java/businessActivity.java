import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.tencil.R;


public class businessActivity extends AppCompatActivity {
    private static final String TAG = "BusinessActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.categories_view );
        Log.d ( TAG, "onCreate Started." );
    }


}
