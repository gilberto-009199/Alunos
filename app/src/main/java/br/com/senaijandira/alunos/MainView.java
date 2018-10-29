package br.com.senaijandira.alunos;

import java.util.List;

import br.com.senaijandira.alunos.service.model.Aluno;

/**
 * Created by 16254850 on 29/10/2018.
 */

public interface MainView{

    void exibirBarraProgresso();

    void esconderBarraProgresso();

    void preencherLista(List<Aluno> alunos);

}
