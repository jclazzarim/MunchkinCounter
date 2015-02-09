package br.android.munchkin.munchkincounter.telas.jogador;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.android.munchkin.munchkincounter.BottomButton;
import br.android.munchkin.munchkincounter.FragmentController;
import br.android.munchkin.munchkincounter.IButtonControl;
import br.android.munchkin.munchkincounter.R;
import br.android.munchkin.munchkincounter.TopButton;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.EImagemSexo;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.Player;
import br.android.munchkin.munchkincounter.telas.inicial.PlayersFragment;


public class CadastroJogador extends Fragment implements IButtonControl {

    private ImageView ivImagemCadastro;
    private TextView tvNomeCadastro;
    private EImagemSexo img = EImagemSexo.MASCULINO;
    private Player p;

    public CadastroJogador() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadastro_jogador, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        p = new Player();
        tvNomeCadastro = (TextView) getActivity().findViewById(R.id.tvNomeCadastro);

        ivImagemCadastro = (ImageView) getActivity().findViewById(R.id.ivSexoCadastro);
        ivImagemCadastro.setOnClickListener(new MudarImagem());
    }

    @Override
    public void gerenciaTopButton() {
        TopButton.setButtonAction("Confirmar", new Confirmar());
    }

    @Override
    public void gerenciaBotButton() {
        BottomButton.setButtonAction("Cancelar", new Cancelar());
    }

    private void changeCenterFragment() {
        FragmentController.changeCenterFragment(FragmentController.EFragment.PLAYERS_FRAGMENT, CadastroJogador.this.getActivity());
    }


    private class Cancelar implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            changeCenterFragment();
        }
    }


    private class Confirmar implements View.OnClickListener {
        @Override
        public void onClick(View v) {


            p.setNome(tvNomeCadastro.getText().toString());
            p.setSexo(img);

            ((PlayersFragment) FragmentController.EFragment.PLAYERS_FRAGMENT.getFragment()).addMunchkin(p);
            changeCenterFragment();
        }
    }

    private class MudarImagem implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (img == EImagemSexo.MASCULINO) {
                ivImagemCadastro.setBackgroundResource(EImagemSexo.FEMININO.getResourses());
                img = EImagemSexo.FEMININO;
            } else {
                ivImagemCadastro.setBackgroundResource(EImagemSexo.MASCULINO.getResourses());
                img = EImagemSexo.MASCULINO;
            }
        }
    }
}
