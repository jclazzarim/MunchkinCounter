package br.android.munchkin.munchkincounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TopButton extends Fragment {
    private static Button btnTopButton;

    public TopButton() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnTopButton = (Button) getActivity().findViewById(R.id.btnAddJogador);

    }

    public static void setOnClickListener(View.OnClickListener listener) {
        btnTopButton.setOnClickListener(listener);
    }

    public static void setButtonText(String buttonText) {
        btnTopButton.setText(buttonText);
    }

    public static void setButtonAction(String buttonText, View.OnClickListener listener) {
        setOnClickListener(listener);
        setButtonText(buttonText);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_player_button, container, false);
    }


}
