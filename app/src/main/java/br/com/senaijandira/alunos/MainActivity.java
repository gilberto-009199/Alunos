package br.com.senaijandira.alunos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import br.com.senaijandira.alunos.adapter.AlunosAdapter;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.service.model.Aluno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listaAlunos;
    private AlunosAdapter alunosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaAlunos = findViewById(R.id.lstAluno);

        alunosAdapter = new AlunosAdapter(this);

        listaAlunos.setAdapter(alunosAdapter);

    }


    public void chamaApi(View view) {
        System.out.println("OLá!!");
        // Chama o factory de alunos Service que retorna um objeto Aluno Service
        AlunoService alunoservice = ServiceFactory.create();

        // oBJETO DA CHMADA API DE ALUNOS
        Call<List<Aluno>> callalunos = alunoservice.obertAlunos();

        // Efetuar a chmada a API
        callalunos.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                    List<Aluno> alunos = response.body();

                    alunosAdapter.addAll(alunos);

            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Log.e("ERRO_API",t.getMessage());
            }
        });

    }

    public void AbreCadastro(View view) {
        startActivity(new Intent(this,CadastraActivity.class));
    }
}
