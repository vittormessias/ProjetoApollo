package com.example.projetoapollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CadPerfilPublico_Activity extends AppCompatActivity {
    TextView textPerfil, textNomeEstabelecimento, textLocal, textSobre, textCidade, textEstiloMusical, textEstiloArtista;
    ImageView imagemPerfil;
    EditText textCadNome, textCadLocal, textCadSobre, textCadCidade, textCadGeneroMusical;
    Button btnPublico, btnArtista, btnCancelar, btnAvancar;

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


    }
    //validar campos
    private void validaCampo(){

        boolean resp = false;

        String nomeUsuario = textCadNome.getText().toString();

        if (isCampoVazio(nomeUsuario)){
            textCadNome.requestFocus();
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

    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty() );
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