package br.android.munchkin.munchkincounter.telas.jogador;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.android.munchkin.munchkincounter.FragmentController;
import br.android.munchkin.munchkincounter.IButtonControl;
import br.android.munchkin.munchkincounter.R;
import br.android.munchkin.munchkincounter.TopButton;


public class CadastroJogador extends Fragment implements IButtonControl {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Fragment mainFragment;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroJogador.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroJogador newInstance(String param1, String param2) {
        CadastroJogador fragment = new CadastroJogador();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public CadastroJogador() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_jogador, container, false);
    }

    @Override
    public void gerenciaTopButton() {
        TopButton.setButtonAction("Cancelar", new Cancelar());
    }

    @Override
    public void gerenciaBotButton() {
        TopButton.setButtonAction("Confirmar", new Confirmar());
    }

    // TODO: Rename method, update argument and hook method into UI event

    private class Cancelar implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            FragmentController.changeCenterFragment(FragmentController.EFragment.PLAYERS_FRAGMENT, CadastroJogador.this.getActivity());
        }
    }


    private class Confirmar implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
}
