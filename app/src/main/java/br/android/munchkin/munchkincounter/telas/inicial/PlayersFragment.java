package br.android.munchkin.munchkincounter.telas.inicial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

import br.android.munchkin.munchkincounter.telas.comum.BottomButton;
import br.android.munchkin.munchkincounter.telas.comum.FragmentController;
import br.android.munchkin.munchkincounter.telas.comum.IButtonControl;
import br.android.munchkin.munchkincounter.R;
import br.android.munchkin.munchkincounter.telas.comum.TopButton;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.Player;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.PlayerArrayAdapter;
import br.android.munchkin.munchkincounter.persistencia.DataHelper;

public class PlayersFragment extends Fragment implements IButtonControl {
    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private PlayerArrayAdapter mAdapter;

    private DataHelper dh;

    public static PlayersFragment newInstance(String param1, String param2) {
        PlayersFragment fragment = new PlayersFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlayersFragment() {


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        dh = new DataHelper(activity);

        mAdapter = new PlayerArrayAdapter(activity, R.layout.list_players, dh.selectAll());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        return view;
    }


    public void addMunchkin(Player player) {
        ((PlayerArrayAdapter) mListView.getAdapter()).add(player);
        ((PlayerArrayAdapter) mListView.getAdapter()).notifyDataSetChanged();
    }

    public void gerenciaTopButton() {
        TopButton.setButtonAction("Add munchkin", new AdicionaJogador());
    }

    public void gerenciaBotButton() {
        BottomButton.setButtonAction("Começar massacre", new ComecarJogo());
    }

    private class AdicionaJogador implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            FragmentController.changeCenterFragment(FragmentController.EFragment.CADASTRO_JOGADOR, PlayersFragment.this.getActivity());
        }
    }

    private class ComecarJogo implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(PlayersFragment.this.getActivity(), "Iniciando massacre!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
