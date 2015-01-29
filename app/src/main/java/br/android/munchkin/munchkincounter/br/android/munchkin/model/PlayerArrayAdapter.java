package br.android.munchkin.munchkincounter.br.android.munchkin.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.android.munchkin.munchkincounter.R;

/**
 * Created by SOFT0085 on 26/01/2015.
 */
public class PlayerArrayAdapter extends ArrayAdapter<Player> implements View.OnClickListener {

    private  Context context;
    private  int resource;
    private  List<Player> objects;
    private LayoutInflater inflater;
    private TextView tvOrdem;
    private TextView tvNome;
    private TextView tvQuantidadeJogos;
    private TextView tvQuantidadeVitorias;
    private ImageView ivDeletar;
    private ImageView ivSexo;

    public PlayerArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public PlayerArrayAdapter(Context context, int resource, List<Player> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player item = this.getItem(position);

        if (convertView == null ){
            convertView = inflater.inflate(R.layout.item_list_player, null);
        }
        getCampos(convertView);

        tvNome.setText(item.getNome());
       // tvQuantidadeJogos.setText(item.getJogos());
//        tvQuantidadeVitorias.setText(item.getVitorias());

        ivSexo.setBackgroundResource(item.getSexo().getResourses());

        //TODO falta fazer umas piras aqui lokamente

        return convertView;
    }


    private void getCampos(View convertView){
        tvQuantidadeJogos = (TextView) convertView.findViewById(R.id.tvQuantidadeJogos);
        tvQuantidadeVitorias = (TextView) convertView.findViewById(R.id.tvQuantidadeVitorias);
        tvOrdem = (TextView) convertView.findViewById(R.id.tvOrdem);
        tvNome = (TextView) convertView.findViewById(R.id.tvNome);
         ivDeletar = (ImageView) convertView.findViewById(R.id.ivDeletar);
         ivSexo = (ImageView) convertView.findViewById(R.id.ivSexo);
    }

}
