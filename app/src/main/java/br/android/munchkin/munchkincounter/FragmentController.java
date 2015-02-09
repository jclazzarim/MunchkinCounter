package br.android.munchkin.munchkincounter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import br.android.munchkin.munchkincounter.telas.inicial.PlayersFragment;
import br.android.munchkin.munchkincounter.telas.jogador.CadastroJogador;

/**
 * Created by SOFT0085 on 09/02/2015.
 */
public class FragmentController {

    private static PlayersFragment playersFragment;
    private static CadastroJogador cadastroJogador;

    public static void changeCenterFragment(EFragment eTelas, FragmentActivity activity) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flCenter, eTelas.getFragment());
        ft.commit();

        ((IButtonControl)eTelas.getFragment()).gerenciaTopButton();
        ((IButtonControl)eTelas.getFragment()).gerenciaBotButton();;
    }

    private static PlayersFragment getPlayersFragment() {
        if (playersFragment == null) {
            playersFragment = new PlayersFragment();
        }

        return playersFragment;
    }

    private static CadastroJogador getCadastroJogadorFragment() {
        if (cadastroJogador == null) {
            cadastroJogador = new CadastroJogador();
        }

        return cadastroJogador;
    }


    public enum EFragment {
        PLAYERS_FRAGMENT(getPlayersFragment()),
        CADASTRO_JOGADOR(getCadastroJogadorFragment());

        private Fragment fragment;

        EFragment(Fragment fragment) {
            this.fragment = fragment;
        }

        public Fragment getFragment() {
            return fragment;
        }
    }

}
