package br.android.munchkin.munchkincounter.br.android.munchkin.model;

import br.android.munchkin.munchkincounter.R;

/**
 * Created by SOFT0085 on 26/01/2015.
 */
public enum EImagemSexo {

    MASCULINO(R.drawable.homem),
    FEMININO(R.drawable.mulher)
        ;
    private int resourses;

    EImagemSexo(int resourses) {
        this.resourses = resourses;
    }

    public int getResourses() {
        return resourses;
    }

}
