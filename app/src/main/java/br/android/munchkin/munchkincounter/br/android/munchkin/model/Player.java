package br.android.munchkin.munchkincounter.br.android.munchkin.model;

import android.widget.ImageView;

import br.android.munchkin.munchkincounter.R;

/**
 * Created by SOFT0085 on 26/01/2015.
 */
public class Player {

    String nome;
    EImagemSexo sexo;
    Integer vitorias;
    Integer jogos;

    public Player() {
    }

    public EImagemSexo getSexo() {
        return sexo;
    }

    public void setSexo(EImagemSexo sexo) {
        this.sexo = sexo;
    }

    public void setSexo(ImageView sexo) {

    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getJogos() {
        return jogos;
    }

    public void setJogos(Integer jogos) {
        this.jogos = jogos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
