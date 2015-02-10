package br.android.munchkin.munchkincounter.telas.comum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.android.munchkin.munchkincounter.R;


public class BottomButton extends Fragment {
    private static Button btnBottomButton;

    public BottomButton() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnBottomButton = (Button) getActivity().findViewById(R.id.btnBotButton);
    }

    public static void setOnClickListener(View.OnClickListener listener) {
        btnBottomButton.setOnClickListener(listener);
    }

    public static void setButtonText(String buttonText) {
        btnBottomButton.setText(buttonText);
    }

    public static void setButtonAction(String buttonText, View.OnClickListener listener) {
        setOnClickListener(listener);
        setButtonText(buttonText);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start_game_button, container, false);
    }


}
