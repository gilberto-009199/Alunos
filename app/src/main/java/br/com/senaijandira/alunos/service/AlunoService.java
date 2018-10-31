package br.com.senaijandira.alunos.service;

import java.util.List;
import br.com.senaijandira.alunos.service.model.Aluno;
import br.com.senaijandira.alunos.service.model.ApiResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AlunoService {
    // 10.0.2.2 e o ip da nossa maquina local do emulador
    String URL_BASE = "http://10.0.2.2:5001/";

    @GET("/alunos")
    Call<List<Aluno>> obertAlunos();

    @GET("/aluno/(id)")
    Call<Aluno> obertAluno(@Path("id") int id);

    @POST("/novo")
    Call<ApiResult> cadastrarAluno(@Body Aluno aluno);

    /*@FormUrlEncoded
    Call addAluno(@Field("nome") String nome, @Field("data_nascimento") int dtNasc,
                  @Field("matricula") String matricula,@Field("cpf") String cpf );*/



}

