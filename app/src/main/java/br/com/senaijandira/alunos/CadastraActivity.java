package br.com.senaijandira.alunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.service.model.Aluno;
import retrofit2.Call;

public class CadastraActivity extends AppCompatActivity {

    private EditText txtNome,txtDtNasc,txtMatricula,txtCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra);

        txtNome = findViewById(R.id.txtNome);
        txtDtNasc = findViewById(R.id.txtDtNasc);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCpf);
    }

    public void addAluno(View view) {
        AlunoService alunoservice = ServiceFactory.create();

        String nome = txtNome.getText().toString();
        int dtNasc = Integer.parseInt(txtDtNasc.getText().toString());
        String matricula = txtMatricula.getText().toString();
        String cpf = txtCpf.getText().toString();

        // oBJETO DA CHMADA API DE ALUNOS
        Call cadastro = alunoservice.addAluno(nome,dtNasc,matricula,cpf);

        
    }

    public void clearForm(View view) {
        txtNome.setText("");
        txtDtNasc.setText("");
        txtMatricula.setText("");
        txtCpf.setText("");
    }
}
