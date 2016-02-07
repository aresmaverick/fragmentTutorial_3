package br.com.p2hf.fragmenttutorial_3;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by fred on 06/02/16.
 */
public class DetailActivity extends Activity {
    public static final String EXTRA_URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getBoolean(R.bool.dual_pane)) {
            finish();
            return;
        }

        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String url = extras.getString(EXTRA_URL);
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);

            detailFragment.setText(url);
        }
    }
}
