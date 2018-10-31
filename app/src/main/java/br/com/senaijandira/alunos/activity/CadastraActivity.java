package br.com.senaijandira.alunos.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.List;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.presenter.CadastroPresenter;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.service.model.Aluno;
import br.com.senaijandira.alunos.service.model.ApiResult;
import br.com.senaijandira.alunos.util.DateUtil;
import br.com.senaijandira.alunos.view.CadastroView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastraActivity extends AppCompatActivity implements CadastroView {

    static EditText txtNome,txtDtNasc,txtMatricula,txtCpf;
    private AlunoService alunoservice;
    private CadastroPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra);

        txtNome = findViewById(R.id.txtNome);
        txtDtNasc = findViewById(R.id.txtDtNasc);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCpf);

        alunoservice = ServiceFactory.create();

        presenter = new CadastroPresenter(this,alunoservice);

    }

    public void addAluno(View view) {


        String nome = txtNome.getText().toString();

        String datan = txtDtNasc.getText().toString();

        int dtNasc = new DateUtil().convertToInt(datan);

        String matricula = txtMatricula.getText().toString();
        String cpf = txtCpf.getText().toString();

        // oBJETO DA CHMADA API DE ALUNOS
        Aluno alunotmp = new Aluno();
        alunotmp.setNome(nome);
        alunotmp.setDataNacimento(dtNasc);
        alunotmp.setMatricula(matricula);
        alunotmp.setCpf(cpf);

        presenter.addAluno(alunotmp);

    }
    @Override
    public void showMenssage(String titulo,String msg){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(titulo);
        alert.setMessage(msg);
        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }
    @Override
    public void clearForm(View view) {
        txtNome.setText("");
        txtDtNasc.setText("");
        txtMatricula.setText("");
        txtCpf.setText("");
    }

    public void abrirCalendario(View view) {
        DialogFragment newFragment = new DatePickerFragment();


        newFragment.show(getSupportFragmentManager(), "datePicker");

    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user

            // %02d conpleta o inteiro com 0 se tiver uma cadeica de caracteres com monos que 2 chars
            // 9 = 09 : 10 = 10
            String data = String.format("%02d/%02d/%d",day,month+1,year);
            txtDtNasc.setText(data);
        }
    }
}
