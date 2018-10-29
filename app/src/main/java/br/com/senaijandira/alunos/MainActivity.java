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
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunos.adapter.AlunosAdapter;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.service.model.Aluno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainView {

    private ListView listaAlunos;
    private AlunosAdapter alunosAdapter;
    private ProgressBar progress;
    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaAlunos = findViewById(R.id.lstAluno);

        alunosAdapter = new AlunosAdapter(this);

        progress = findViewById(R.id.progressBar);

        listaAlunos.setAdapter(alunosAdapter);



        presenter = new MainPresenter(this,
                ServiceFactory.create());

        presenter.carregarAlunos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //carregarAlunos();
    }

    @Override
    public void exibirBarraProgresso(){
        progress.setVisibility(View.VISIBLE);
        listaAlunos.setVisibility(View.GONE);
    }
    @Override
    public void esconderBarraProgresso(){
        progress.setVisibility(View.GONE);
        listaAlunos.setVisibility(View.VISIBLE);
    }
    @Override
    public void preencherLista(List<Aluno> alunos){
        alunosAdapter.clear();
        alunosAdapter.addAll(alunos);
    };

    public void AbreCadastro(View view) {
        startActivity(new Intent(this,CadastraActivity.class));
    }
}
