package br.com.senaijandira.alunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class VisualizarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        int idAluno = getIntent().getIntExtra("idAluno",0);

        Log.d("ID_ALUNO","aluno de id"+idAluno);
        
    }
}
