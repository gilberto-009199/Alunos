package br.com.senaijandira.alunos.presenter;

import android.view.View;

import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.model.Aluno;
import br.com.senaijandira.alunos.service.model.ApiResult;
import br.com.senaijandira.alunos.util.DateUtil;
import br.com.senaijandira.alunos.view.CadastroView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroPresenter {

    CadastroView view;

    AlunoService service;

    public CadastroPresenter( CadastroView view, AlunoService service){
        this.view = view;
        this.service = service;
    }

    public void addAluno(Aluno aluno) {

        service.cadastrarAluno(aluno).enqueue(new Callback<ApiResult>() {
            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {
                ApiResult result = response.body();

                if(result.getSucesso()){
                    view.clearForm(null);
                    view.showMenssage("Sucesso!!","Aluno Cadastrado");
                }else{
                    view.showMenssage("Falha","O aluno não pode ser cadastrado!!");
                }
                System.out.println("Resultado: "+result.getMsg());
            }

            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }


}
