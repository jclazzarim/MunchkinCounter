package br.android.munchkin.munchkincounter.telas.jogador;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.android.munchkin.munchkincounter.telas.comum.BottomButton;
import br.android.munchkin.munchkincounter.telas.comum.FragmentController;
import br.android.munchkin.munchkincounter.telas.comum.IButtonControl;
import br.android.munchkin.munchkincounter.R;
import br.android.munchkin.munchkincounter.telas.comum.TopButton;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.EImagemSexo;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.Player;
import br.android.munchkin.munchkincounter.persistencia.DataHelper;


public class CadastroPlayerFragment extends Fragment implements IButtonControl {

    private ImageView ivImagemCadastro;
    private TextView tvNomeCadastro;
    private EImagemSexo img = EImagemSexo.MASCULINO;
    private DataHelper dh;

    public CadastroPlayerFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        dh = new DataHelper(activity);
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
        FragmentController.changeCenterFragment(FragmentController.EFragment.PLAYERS_FRAGMENT, CadastroPlayerFragment.this.getActivity());
        limpar();
    }

    private void limpar() {
        tvNomeCadastro.setText("");
        img = EImagemSexo.MASCULINO;
        ivImagemCadastro.setBackgroundResource(img.getResourses());
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
            String nome = tvNomeCadastro.getText().toString();

            if (!nome.isEmpty()) {
                Player p = new Player();

                Player player = dh.consultaPorNome(nome);
                if (player != null && player.getId() != null) {
                    Toast.makeText(getActivity(), "Já existe um Munchkin cadastrado com este nome!", Toast.LENGTH_SHORT).show();
                    return;
                }

                p.setNome(nome);
                p.setSexo(img);

                dh.insert(p);

                changeCenterFragment();


            } else {
                Toast.makeText(getActivity(), "É necessário dar um nome para o Munchkin!", Toast.LENGTH_SHORT).show();
            }

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
