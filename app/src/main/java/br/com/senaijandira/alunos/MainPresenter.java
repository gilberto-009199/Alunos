package br.com.senaijandira.alunos;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.service.model.Aluno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 16254850 on 29/10/2018.
 */

public class MainPresenter {

    MainView mainview;
    AlunoService service;

    public MainPresenter(MainView mainview, AlunoService service){
        this.mainview = mainview;
        this.service = service;
        // Chama o factory de alunos Service que retorna um objeto Aluno Service
    }

    public void carregarAlunos() {
        System.out.println("OLá!!");

        mainview.exibirBarraProgresso();

        // oBJETO DA CHMADA API DE ALUNOS
        Call<List<Aluno>> callalunos = service.obertAlunos();

        // Efetuar a chmada a API
        callalunos.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                List<Aluno> alunos = response.body();
                mainview.preencherLista(alunos);
                mainview.esconderBarraProgresso();
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Log.e("ERRO_API",t.getMessage());
            }
        });

    }
}
