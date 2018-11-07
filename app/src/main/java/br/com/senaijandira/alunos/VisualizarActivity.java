package br.com.senaijandira.alunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.function.Consumer;

import br.com.senaijandira.alunos.presenter.VisualizarPresenter;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.service.model.Aluno;
import br.com.senaijandira.alunos.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView{

    private TextView txtNome,txtMatricula,txtDtNasc,txtCpf,txtMedia;
    private VisualizarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);
        int idAluno = 1;
        idAluno = getIntent().getIntExtra("idAluno",0);
        Log.d("ID_ALUNO","aluno de id "+idAluno);



        presenter = new VisualizarPresenter(this, ServiceFactory.create());



        txtNome = findViewById(R.id.txtNome);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtDtNasc = findViewById(R.id.txtDtNasc);
        txtCpf = findViewById(R.id.txtCpf);
        txtMedia = findViewById(R.id.txtMedia);

        presenter.carregarAluno(idAluno);
    }


    @Override
    public void mostrarAluno(Aluno aluno) {
        txtNome.setText(aluno.getNome());
        txtMatricula.setText(aluno.getMatricula());
        txtDtNasc.setText(aluno.getDataNacimento()+"");
        txtCpf.setText(aluno.getCpf());
        

    }
}
