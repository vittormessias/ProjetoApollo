package com.example.projetoapollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaInscricaoArtista_Activity extends AppCompatActivity {
    //criar variaveis que irão representar os componentes do xml
    Button btnPublico, btnArtista, btnCancelar, btnAvancar;
    TextView txtNomeUsuario, txtLogin, txtEmail, txtSenha, txtConfigSenha;
    EditText txtCadUsuario, txtCadLogin, txtCadEmail, txtCadSenha, txtCadConfigSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //está chamada de metódo que faz referência ao layout
        setContentView(R.layout.tela_inscricao_artista_layout);
        //apresentar os componentes do xml para o java
        btnPublico = findViewById(R.id.btnPublico);
        btnArtista = findViewById(R.id.btnArtista);
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

    public void abrirJanela(View view) {
        validaCampo();
    }

    //voltar janela
    public void voltarJanelaArtista(View view) {
        Intent voltarJanelaArtista = new Intent(getApplicationContext(), LoginArtista_Activity.class);
        startActivity(voltarJanelaArtista);
    }

    public void abrirJanelaPublico(View view) {
        Intent abrirJanelaPublico = new Intent(getApplicationContext(), TelaInscricaoPublico_Activity.class);
        startActivity(abrirJanelaPublico);
    }

    public void abrirJanelaAvancar(View view) {
        Intent abrirJanelaAvancar = new Intent(getApplicationContext(), CadPerfilArtista_Activity.class);
        startActivity(abrirJanelaAvancar);

    }
}