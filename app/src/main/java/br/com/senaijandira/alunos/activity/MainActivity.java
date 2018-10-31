package br.com.senaijandira.alunos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunos.VisualizarActivity;
import br.com.senaijandira.alunos.presenter.MainPresenter;
import br.com.senaijandira.alunos.view.MainView;
import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.adapter.AlunosAdapter;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.service.model.Aluno;

public class MainActivity extends AppCompatActivity implements MainView,AdapterView.OnItemClickListener {

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

        listaAlunos.setOnItemClickListener(this);

        presenter = new MainPresenter(this,
                ServiceFactory.create());

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.carregarAlunos();
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Aluno aluno = alunosAdapter.getItem(position);

        Intent intent = new Intent(this, VisualizarActivity.class);
        intent.putExtra("idAluno",aluno.getId());

        startActivity(intent);

    }
}
