package br.android.munchkin.munchkincounter.br.android.munchkin.model;

import android.widget.ImageView;

/**
 * Created by SOFT0085 on 26/01/2015.
 */
public class Player {

    private Integer id;

    private EImagemSexo sexo;
    private Integer vitorias;
    private Integer jogos;
    private String nome;

    public Player() {
        setVitorias(0);
        setJogos(0);
    }

    public EImagemSexo getSexo() {
        return sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSexo(EImagemSexo sexo) {
        this.sexo = sexo;
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
