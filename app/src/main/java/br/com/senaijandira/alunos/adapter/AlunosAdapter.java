package br.com.senaijandira.alunos.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.service.model.Aluno;

public class AlunosAdapter extends ArrayAdapter<Aluno> {
    public AlunosAdapter(Context ctx) {
        super(ctx, 0, new ArrayList<Aluno>());
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.aluno_layout, parent, false);
        }
        TextView txtNome = v.findViewById(R.id.txtNome);
        TextView txtMatricula = v.findViewById(R.id.txtMatricula);


        Aluno alunotmp = getItem(position);

        txtNome.setText(alunotmp.getNome());
        txtMatricula.setText(alunotmp.getMatricula());

        return v;
    }
}
