package br.android.munchkin.munchkincounter.br.android.munchkin.model;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

/**
 * Created by SOFT0085 on 26/01/2015.
 */
public class PlayerAdapter extends ArrayAdapter<Player> implements View.OnClickListener {

    public PlayerAdapter(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public void onClick(View v) {

    }
}
