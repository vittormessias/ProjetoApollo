package com.example.projetoapollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaInscricao_Activity extends AppCompatActivity implements View.OnClickListener {

    public static final String NOME_BANCO_DE_DADOS = "APOLLO_BD";

    UsuarioAdapter usuarioAdapter;

    //criar variaveis que irão representar os componentes do xml
    Button btnCancelar, btnAvancar;
    TextView txtNomeUsuario, txtLogin, txtEmail, txtSenha, txtConfigSenha;
    EditText txtCadUsuario, txtCadLogin, txtCadEmail, txtCadSenha, txtCadConfigSenha;

    SQLiteDatabase meuBancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //está chamada de metódo que faz referência ao layout
        setContentView(R.layout.tela_inscricao_layout);
        //apresentar os componentes do xml para o java
        btnCancelar = findViewById(R.id.btnCancelar);
        btnAvancar = findViewById(R.id.btnAvancar);
        txtNomeUsuario = findViewById(R.id.txtNomeUsuario);
        txtLogin = findViewById(R.id.txtLogin);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        txtConfigSenha = findViewById(R.id.txtConfigSenha);
        txtCadUsuario = findViewById(R.id.txtCadUsuario);
        txtCadLogin = findViewById(R.id.txtCadLogin);
        txtCadEmail = findViewById(R.id.txtCadEmail);
        txtCadSenha = findViewById(R.id.txtCadSenha);
        txtCadConfigSenha = findViewById(R.id.txtCadConfigSenha);

        btnAvancar.setOnClickListener(this);

        meuBancoDeDados = openOrCreateDatabase(NOME_BANCO_DE_DADOS, MODE_PRIVATE, null);

        criarTabelaUsuario();

    }

    //Este método irá validar o nomeUsuario
    private boolean verificarEntrada(String nomeUsuario, String nomeLogin, String nomeEmail, String nomeSenha, String nomeConfigSenha) {
        if (nomeUsuario.isEmpty()) {
            txtCadUsuario.setError("Por favor entre com um nome de usario");
            txtCadUsuario.requestFocus();
            return false;
        }

        if (nomeLogin.isEmpty()) {
            txtCadLogin.setError("Por favor entre com uma nome de login");
            txtCadLogin.requestFocus();
            return false;
        }
        if (nomeEmail.isEmpty()) {
            txtCadEmail.setError("Por favor entre com um email");
            txtCadEmail.requestFocus();
            return false;
        }
        if (nomeSenha.isEmpty()) {
            txtCadSenha.setError("Por favor entre com uma senha");
            txtCadSenha.requestFocus();
                return false;
            }
        if (nomeConfigSenha.isEmpty()) {
            txtCadConfigSenha.setError("Por favor entre com uma senha");
            txtCadConfigSenha.requestFocus();
            return false;
        }
        return true;
    }

    private void adicionarUsuario() {
        String nomeUsuario = txtCadUsuario.getText().toString().trim();
        String nomeLogin = txtCadLogin.getText().toString().trim();
        String nomeEmail = txtCadEmail.getText().toString().trim();
        String nomeSenha = txtCadSenha.getText().toString().trim();
        String nomeConfigSenha = txtCadConfigSenha.getText().toString().trim();

        //validando entrada
        if (verificarEntrada(nomeUsuario, nomeLogin, nomeEmail, nomeSenha, nomeConfigSenha)) {

            String insertSQL = "INSERT INTO Usuario (" +
                    "nomeUsuario, " +
                    "nomeLogin, " +
                    "nomeEmail," +
                    "nomeSenha," +
                    "nomeConfigSenha)" +
                    "VALUES(?, ?, ?, ?, ?);";

            meuBancoDeDados.execSQL(insertSQL, new String[]{nomeUsuario, nomeLogin, nomeEmail, nomeSenha, nomeConfigSenha});

            Toast.makeText(getApplicationContext(), "Usuario cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show();
        }
    }

    // este método irá criar a tabela
    private void criarTabelaUsuario() {
        meuBancoDeDados.execSQL(
                "CREATE TABLE IF NOT EXISTS Usuario (" +
                        "id_usuario integer PRIMARY KEY AUTOINCREMENT," +
                        "nomeUsuario varchar(80) NOT NULL," +
                        "nomeLogin varchar(40) NOT NULL UNIQUE," +
                        "nomeEmail varchar(100) NOT NULL UNIQUE," +
                        "nomeSenha varchar(20) NOT NULL UNIQUE," +
                        "nomeConfigSenha varchar(20) NOT NULL );"
        );
    }

    //validar campos
    private void validaCampo(){

        boolean resp = false;

        String nomeUsuario = txtCadUsuario.getText().toString();
        String nomeLogin = txtCadLogin.getText().toString();
        String nomeEmail = txtCadEmail.getText().toString();
        String nomeSenha = txtCadSenha.getText().toString();
        String nomeConfSenha = txtCadConfigSenha.getText().toString();

        if (isCampoVazio(nomeUsuario)){
            txtCadUsuario.requestFocus();
            resp = true;
        }
        else
            if (isCampoVazio(nomeLogin)){
            txtCadLogin.requestFocus();
            resp = true;
        }else
            if (!isEmailValido(nomeEmail)){
                txtCadEmail.requestFocus();
                resp = true;
        }else
            if (isCampoVazio(nomeSenha)) {
                txtCadSenha.requestFocus();
                resp = true;
            }else
                if (isCampoVazio(nomeConfSenha)){
                txtCadConfigSenha.requestFocus();
                resp = true;
            }
        if (resp){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(R.string.message_campos_invalido_branco);
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }
    //verificar se há campos vazios
    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty() );
        return resultado;
    }
    //verifica se o email é valido
    private boolean isEmailValido(String nomeEmail){
        boolean resultado = (!isCampoVazio(nomeEmail) && Patterns.EMAIL_ADDRESS.matcher(nomeEmail).matches());
        return resultado;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){

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

    public void btnAvancar(View view) {
        Intent btnAvancar = new Intent(getApplicationContext(), TelaArtistaPublico_Activity.class);
        startActivity(btnAvancar);
    }

    //voltar janela
    public void voltarJanelaArtista(View view) {
        Intent voltarJanelaArtista = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(voltarJanelaArtista);
    }
}