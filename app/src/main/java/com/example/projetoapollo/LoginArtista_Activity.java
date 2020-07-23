package com.example.projetoapollo;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class LoginArtista_Activity extends AppCompatActivity {
    //criar variaveis que irão representar os componentes do xml
    Button btnEntrar, btnCadastro, btnPublico, btnArtista;
    EditText txtEmail, txtSenha;
    TextView txtRecuperacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //está chamada de metódo que faz referência ao layout
        setContentView(R.layout.login_artista_layout);
        //apresentar os componentes do xml para o java
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastro = findViewById(R.id.btnCadastro);
        btnPublico = findViewById(R.id.btnPublico);
        btnArtista = findViewById(R.id.btnArtista);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        txtRecuperacao = findViewById(R.id.txtRecuperacao);}
    // metódo de abrir janela
    public void abrirJanelaPublico(View view) {
        Intent abrirJanelaPublico = new Intent(getApplicationContext(), LoginPublico_Activity.class);
        startActivity(abrirJanelaPublico); }
    public void abrirJanelaArtista(View view) {
        Intent abrirJanelaArtista = new Intent(getApplicationContext(), TelaInscricaoArtista_Activity.class);
        startActivity(abrirJanelaArtista); }
}