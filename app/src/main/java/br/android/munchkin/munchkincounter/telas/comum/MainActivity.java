package br.android.munchkin.munchkincounter.telas.comum;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import br.android.munchkin.munchkincounter.R;


public class MainActivity extends android.support.v4.app.FragmentActivity {

    private TopButton apb;
    private BottomButton sgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();

        apb = new TopButton();
        ft.add(R.id.flTopButton, apb);


        sgb = new BottomButton();
        ft.add(R.id.flBotButton, sgb);

        ft.add(R.id.flCenter, FragmentController.EFragment.PLAYERS_FRAGMENT.getFragment());
        ft.commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
        FragmentController.changeCenterFragment(FragmentController.EFragment.PLAYERS_FRAGMENT, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }





}
