package br.android.munchkin.munchkincounter.br.android.munchkin.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.android.munchkin.munchkincounter.R;

/**
 * Created by SOFT0085 on 26/01/2015.
 */
public class PlayerArrayAdapter extends ArrayAdapter<Player> implements View.OnClickListener {

    private Context context;
    private int resource;
    private List<Player> objects;
    private LayoutInflater inflater;
    private TextView tvNome;
    private TextView tvQJ;
    private TextView tvQV;
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
        Toast.makeText(getContext(), "Clicou", Toast.LENGTH_SHORT).show();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player item = this.getItem(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_player, null);
        }
        getCampos(convertView);

        tvNome.setText(item.getNome());
        tvQJ.setText(item.getJogos().toString());
        tvQV.setText(item.getVitorias().toString());

        ivSexo.setBackgroundResource(item.getSexo().getResourses());
        ivDeletar.setOnClickListener(new DeletarJogador(item));
        return convertView;
    }


    private void getCampos(View convertView) {
        tvQJ = (TextView) convertView.findViewById(R.id.tvQuantidadeJogos);
        tvQV = (TextView) convertView.findViewById(R.id.tvQuantidadeVitorias);
        tvNome = (TextView) convertView.findViewById(R.id.tvNome);
        ivDeletar = (ImageView) convertView.findViewById(R.id.ivDeletar);
        ivSexo = (ImageView) convertView.findViewById(R.id.ivSexo);
    }

    private class DeletarJogador implements View.OnClickListener {

        private Player jogador;

        private DeletarJogador(Player jogador) {
            this.jogador = jogador;
        }

        @Override
        public void onClick(View v) {
            dialogoDeletarJogador();
        }

        private void dialogoDeletarJogador() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Deletar jogador!!!!");
            builder.setMessage("Deseja deletar o jogador: " + jogador.getNome() + "?");

            builder.setPositiveButton("Mata esse fdp!!!!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(getContext(), "A cabeça de " + jogador.getNome() + " rola pelo chão!", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Let he live!!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(getContext(), jogador.getNome() + " permanece vivo! ", Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog alerta = builder.create();
            alerta.show();
        }

    }
}