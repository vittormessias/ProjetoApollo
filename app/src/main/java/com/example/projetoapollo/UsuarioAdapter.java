package com.example.projetoapollo;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;

        import java.util.List;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    Context mCtx;
    int listaLayoutRes;
    List<Usuario> listaUsuarios;
    SQLiteDatabase meuBancoDeDados;

    TextView textNomeUsuHomeArtista;

    public UsuarioAdapter(@NonNull Context mCtx, int listaLayoutRes, List<Usuario> listaUsuarios, SQLiteDatabase meuBancoDeDados) {
        super(mCtx, listaLayoutRes, listaUsuarios);
        this.mCtx = mCtx;
        this.listaLayoutRes = listaLayoutRes;
        this.listaUsuarios = listaUsuarios;
        this.meuBancoDeDados = meuBancoDeDados;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listaLayoutRes, null);

        final Usuario usuario = listaUsuarios.get(position);

        textNomeUsuHomeArtista = view.findViewById(R.id.textNomeUsuHomeArtista);


        TextView textNomeUsuHomeArtista = view.findViewById(R.id.textNomeUsuHomeArtista);


        textNomeUsuHomeArtista.setText(usuario.getNomeUsuario());


        return view;
    }
}
