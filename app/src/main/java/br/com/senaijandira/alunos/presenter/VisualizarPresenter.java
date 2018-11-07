package br.com.senaijandira.alunos.presenter;

import java.util.ArrayList;

import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.model.Aluno;
import br.com.senaijandira.alunos.view.CadastroView;
import br.com.senaijandira.alunos.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {

    private VisualizarView activity;
    private AlunoService service;

    public VisualizarPresenter(VisualizarView activity, AlunoService service){
        this.activity = activity;
        this.service = service;
    }

    public void carregarAluno(int id){

        service.obertAluno(id).enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                Aluno alunotmp = response.body();
                activity.mostrarAluno(alunotmp);
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

}
