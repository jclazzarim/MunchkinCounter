package br.android.munchkin.munchkincounter.telas.comum;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import br.android.munchkin.munchkincounter.R;
import br.android.munchkin.munchkincounter.telas.inicial.PlayersFragment;
import br.android.munchkin.munchkincounter.telas.jogador.CadastroPlayerFragment;

/**
 * Created by SOFT0085 on 09/02/2015.
 */
public class FragmentController {

    private static PlayersFragment playersFragment;
    private static CadastroPlayerFragment cadastroJogador;

    public static void changeCenterFragment(EFragment eTelas, FragmentActivity activity) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flCenter, eTelas.getFragment());
        ft.commit();

        ((IButtonControl) eTelas.getFragment()).gerenciaTopButton();
        ((IButtonControl) eTelas.getFragment()).gerenciaBotButton();
    }

    public static void detachCenterFragment(EFragment eTela, FragmentActivity activity){
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.detach(eTela.getFragment());
        ft.commit();
    }

    static PlayersFragment getPlayersFragment() {
        if (playersFragment == null) {
            playersFragment = new PlayersFragment();
        }

        return playersFragment;
    }

    static CadastroPlayerFragment getCadastroJogadorFragment() {
//        if (cadastroJogador == null) {
        cadastroJogador = new CadastroPlayerFragment();
//        }

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
