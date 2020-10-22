package com.example.projetoapollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CadPerfilPublico_Activity extends AppCompatActivity implements View.OnClickListener {

    public static final String NOME_BANCO_DE_DADOS = "APOLLO_BD";

    UsuarioAdapter usuarioAdapter;

    TextView textPerfil, textNomeEstabelecimento, textLocal, textSobre, textCidade, textEstiloMusical, textEstiloArtista;
    ImageView imagemPerfil;
    EditText textCadNome, textCadLocal, textCadSobre, textCadCidade, textCadGeneroMusical;
    Button btnPublico, btnArtista, btnCancelar, btnAvancar;

    SQLiteDatabase meuBancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_perfil_publico_layout);

        textPerfil = findViewById(R.id.textPerfil);
        textNomeEstabelecimento = findViewById(R.id.textNomeEstabelecimento);
        textLocal = findViewById(R.id.textLocal);
        textSobre = findViewById(R.id.textSobre);
        textCidade = findViewById(R.id.textCidade);
        textEstiloMusical = findViewById(R.id.textEstiloMusical);
        textEstiloArtista = findViewById(R.id.textEstiloArtista);
        imagemPerfil = findViewById(R.id.imagemPerfil);
        textCadNome = findViewById(R.id.textCadNome);
        textCadLocal = findViewById(R.id.textCadLocal);
        textCadSobre = findViewById(R.id.textCadSobre);
        textCadCidade = findViewById(R.id.textCadCidade);
        textCadGeneroMusical = findViewById(R.id.textCadGeneroMusical);
        btnPublico = findViewById(R.id.btnPublico);
        btnArtista = findViewById(R.id.btnArtista);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(this);

        meuBancoDeDados = openOrCreateDatabase(NOME_BANCO_DE_DADOS, MODE_PRIVATE, null);

        criarTabelaPerfilPublico();
    }

    //Este método irá validar a entrada
    private boolean verificarEntrada(String nomeUsuario, String nomeLocal, String nomeSobre, String nomeCidade, String nomeGeneroMusical) {
        if (nomeUsuario.isEmpty()) {
            textCadNome.setError("Por favor entre com um nome de usario");
            textCadNome.requestFocus();
            return false;
        }

        if (nomeLocal.isEmpty()) {
            textCadLocal.setError("Por favor entre com um local");
            textCadLocal.requestFocus();
            return false;
        }
        if (nomeSobre.isEmpty()) {
            textCadSobre.setError("Por favor entre com uma descrição");
            textCadSobre.requestFocus();
            return false;
        }
        if (nomeCidade.isEmpty()) {
            textCadCidade.setError("Por favor entre com uma cidade");
            textCadCidade.requestFocus();
            return false;
        }
        if (nomeGeneroMusical.isEmpty()) {
            textCadGeneroMusical.setError("Por favor entre com um estilo musical");
            textCadGeneroMusical.requestFocus();
            return false;
        }
        return true;
    }

    private void adicionarUsuario() {
        String nomeUsuario = textCadNome.getText().toString().trim();
        String nomeLocal = textCadLocal.getText().toString().trim();
        String nomeSobre = textCadSobre.getText().toString().trim();
        String nomeCidade = textCadCidade.getText().toString().trim();
        String nomeGeneroMusical = textCadGeneroMusical.getText().toString().trim();

        //validando entrada
        if (verificarEntrada(nomeUsuario, nomeLocal, nomeSobre, nomeCidade, nomeGeneroMusical)) {

            String insertSQL = "INSERT INTO PerfilArtista (" +
                    "nomeUsuario, " +
                    "nomeLocal, " +
                    "nomeSobre," +
                    "nomeCidade," +
                    "nomeGeneroMusical)" +
                    "VALUES(?, ?, ?, ?, ?);";

            meuBancoDeDados.execSQL(insertSQL, new String[]{nomeUsuario, nomeLocal, nomeSobre, nomeCidade, nomeGeneroMusical});

            Toast.makeText(getApplicationContext(), "Usuario cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show();
        }
    }

    // este método irá criar a tabela
    private void criarTabelaPerfilPublico() {
        meuBancoDeDados.execSQL(
                "CREATE TABLE IF NOT EXISTS Usuario (" +
                        "id_publico integer PRIMARY KEY AUTOINCREMENT," +
                        "nomeUsuario varchar(40) NOT NULL," +
                        "nomeLocal varchar(100) NOT NULL UNIQUE," +
                        "nomeSobre varchar(400) NOT NULL UNIQUE," +
                        "nomeCidade varchar(20) NOT NULL UNIQUE," +
                        "nomeGeneroMusical varchar(200) NOT NULL );"
        );
    }

    //validar campos
    private void validaCampo() {

        boolean resp = false;

        String nomeUsuario = textCadNome.getText().toString();
        String nomeLocal = textCadNome.getText().toString();
        String nomeSobre = textCadSobre.getText().toString();
        String nomeCidade = textCadCidade.getText().toString();
        String nomeGeneroMusical = textCadGeneroMusical.getText().toString();

        if (isCampoVazio(nomeUsuario)) {
            textCadNome.requestFocus();
            resp = true;
        }
        if (isCampoVazio(nomeLocal)) {
            textCadLocal.requestFocus();
            resp = true;
        }
        if (isCampoVazio(nomeSobre)) {
            textCadSobre.requestFocus();
            resp = true;
        }
        if (isCampoVazio(nomeCidade)) {
            textCadCidade.requestFocus();
            resp = true;
        }
        if (isCampoVazio(nomeGeneroMusical)) {
            textCadGeneroMusical.requestFocus();
            resp = true;
        }
        if (resp) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(R.string.message_campos_invalido_branco);
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnAvancar) {
            adicionarUsuario();
        }
    }

    private boolean isCampoVazio(String valor) {
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    public void voltarJanelaPublico(View view) {
        Intent voltarJanelaPublico = new Intent(getApplicationContext(), TelaInscricao_Activity.class);
        startActivity(voltarJanelaPublico);
    }

    public void abrirJanela(View view) {
        Intent abrirJanela = new Intent(getApplicationContext(), SplashPublico_Activity.class);
        startActivity(abrirJanela);
        validaCampo();
    }

    public void abrirJanelaEstiloMusical(View view) {
        Intent abrirJanelaEstiloMusical = new Intent(getApplicationContext(), EstiloMusicalArtista_Activity.class);
        startActivity(abrirJanelaEstiloMusical);
    }
}