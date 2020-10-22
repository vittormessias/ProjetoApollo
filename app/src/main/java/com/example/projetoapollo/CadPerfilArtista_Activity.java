package com.example.projetoapollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CadPerfilArtista_Activity extends AppCompatActivity implements View.OnClickListener {

    public static final String NOME_BANCO_DE_DADOS = "APOLLO_BD";

    UsuarioAdapter usuarioAdapter;

    TextView textPerfil, textNome, textLocal, textSobre, textCidade, textEstiloMusical, textInstrumentoMusical, textEstiloArtista;
    ImageView imagemPerfil;
    EditText textCadNome, textCadLocal, textCadSobre, textCadCidade, textCadGeneroMusical, textCadInstrumentoMusical;
    Button btnPublico, btnArtista, btnCancelar, btnAvancar;

    SQLiteDatabase meuBancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cad_perfil_artista_layout);

        textPerfil = findViewById(R.id.textPerfil);
        textNome = findViewById(R.id.textNome);
        textLocal = findViewById(R.id.textLocal);
        textSobre = findViewById(R.id.textSobre);
        textCidade = findViewById(R.id.textCidade);
        textEstiloMusical = findViewById(R.id.textEstiloMusical);
        textInstrumentoMusical = findViewById(R.id.textInstrumentoMusical);
        textEstiloArtista = findViewById(R.id.textEstiloArtista);
        imagemPerfil = findViewById(R.id.imagemPerfil);
        textCadNome = findViewById(R.id.textCadNome);
        textCadLocal = findViewById(R.id.textCadLocal);
        textCadSobre = findViewById(R.id.textCadSobre);
        textCadCidade = findViewById(R.id.textCadCidade);
        textCadGeneroMusical = findViewById(R.id.textCadGeneroMusical);
        textCadInstrumentoMusical = findViewById(R.id.textCadInstrumentoMusical);
        btnPublico = findViewById(R.id.btnPublico);
        btnArtista = findViewById(R.id.btnArtista);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(this);

        meuBancoDeDados = openOrCreateDatabase(NOME_BANCO_DE_DADOS, MODE_PRIVATE, null);

        criarTabelaPerfilArtista();

    }

    //Este método irá validar a entrada
    private boolean verificarEntrada(String nomeUsuario, String nomeLocal, String nomeSobre, String nomeCidade, String nomeGeneroMusical, String nomeInstrumentoMusical) {
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
        if (nomeInstrumentoMusical.isEmpty()) {
            textCadInstrumentoMusical.setError("Por favor entre com um instrumento musical");
            textCadInstrumentoMusical.requestFocus();
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
        String nomeInstrumentoMusical = textCadInstrumentoMusical.getText().toString().trim();

        //validando entrada
        if (verificarEntrada(nomeUsuario, nomeLocal, nomeSobre, nomeCidade, nomeGeneroMusical, nomeInstrumentoMusical)) {

            String insertSQL = "INSERT INTO PerfilArtista (" +
                    "nomeUsuario, " +
                    "nomeLocal, " +
                    "nomeSobre," +
                    "nomeCidade," +
                    "nomeGeneroMusical," +
                    "nomeInstrumentoMusical)" +
                    "VALUES(?, ?, ?, ?, ?, ?);";

            meuBancoDeDados.execSQL(insertSQL, new String[]{nomeUsuario, nomeLocal, nomeSobre, nomeCidade, nomeGeneroMusical, nomeInstrumentoMusical});

            Toast.makeText(getApplicationContext(), "Usuario cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show();
        }
    }

    // este método irá criar a tabela
    private void criarTabelaPerfilArtista() {
        meuBancoDeDados.execSQL(
                "CREATE TABLE IF NOT EXISTS Usuario (" +
                        "id_artista integer PRIMARY KEY AUTOINCREMENT," +
                        "nomeUsuario varchar(40) NOT NULL," +
                        "nomeLocal varchar(100) NOT NULL UNIQUE," +
                        "nomeSobre varchar(400) NOT NULL UNIQUE," +
                        "nomeCidade varchar(20) NOT NULL UNIQUE," +
                        "nomeGeneroMusical varchar(200) NOT NULL UNIQUE," +
                        "nomeInstrumentoMusical varchar(30) NOT NULL );"
        );
    }

    //validar campos
    private void validaCampo() {

        boolean resp = false;

        String nomeUsuario = textCadNome.getText().toString();

        if (isCampoVazio(nomeUsuario)) {
            textCadNome.requestFocus();
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

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.btnAvancar:
                validaCampo();
                break;
            case R.id.btnCancelar:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
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

    public void voltarJanelaArtista(View view) {
        Intent voltarJanelaArtista = new Intent(getApplicationContext(), TelaInscricao_Activity.class);
        startActivity(voltarJanelaArtista);
    }

    public void abrirJanelaSplash(View view) {
        Intent abrirJanelaSplash = new Intent(getApplicationContext(), SplashArtista_Activity.class);
        startActivity(abrirJanelaSplash);

    }

    public void abrirJanelaGeneroMusical(View view) {
        Intent abrirJanelaGeneroMusical = new Intent(getApplicationContext(), EstiloMusicalArtista_Activity.class);
        startActivity(abrirJanelaGeneroMusical);
    }

    public void abrirJanelaInstrumento(View view) {
        Intent abrirJanelaInstrumento = new Intent(getApplicationContext(), EstiloInstrumento_Activity.class);
        startActivity(abrirJanelaInstrumento);
    }
}