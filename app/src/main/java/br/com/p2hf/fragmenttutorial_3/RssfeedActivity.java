package br.com.p2hf.fragmenttutorial_3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by fred on 06/02/16.
 */
public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean dual_pane = getResources().getBoolean(R.bool.dual_pane);

        if (!dual_pane) {
            FragmentManager fm = getFragmentManager();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.listcontainer, new MyListFragment());
            ft.commit();
        }

    }

    @Override
    public void onRssItemSelected(String link) {

        boolean dual_pane = getResources().getBoolean(R.bool.dual_pane);

        if (dual_pane) {
            DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
            fragment.setText(link);
        } else {

            FragmentManager fm = getFragmentManager();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.detailscontainer, new DetailFragment());
            ft.addToBackStack("NORMAL");
            ft.commit();


            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_URL, link);
            startActivity(intent);
        }

    }

}

