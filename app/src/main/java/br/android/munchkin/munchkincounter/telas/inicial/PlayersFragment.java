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

import java.util.ArrayList;
import java.util.List;

import br.android.munchkin.munchkincounter.BottomButton;
import br.android.munchkin.munchkincounter.FragmentController;
import br.android.munchkin.munchkincounter.IButtonControl;
import br.android.munchkin.munchkincounter.R;
import br.android.munchkin.munchkincounter.TopButton;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.EImagemSexo;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.Player;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.PlayerArrayAdapter;

public class PlayersFragment extends Fragment implements AbsListView.OnItemClickListener, IButtonControl {
    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private PlayerArrayAdapter mAdapter;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Player p = new Player();
        p.setJogos(2);
        p.setNome("Bastião");
        p.setSexo(EImagemSexo.MASCULINO);
        p.setVitorias(2);

        List<Player> ps = new ArrayList<>();

//        for (int i = 0; i < 5; i++) {
//            ps.add(p);
//        }
        mAdapter = new PlayerArrayAdapter(getActivity(), R.layout.list_players, ps);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void addMunchkin(Player player) {
        mAdapter.add(player);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);
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
