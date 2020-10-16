package com.example.projetoapollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CadPerfilArtista_Activity extends AppCompatActivity {
    TextView textPerfil, textNome, textLocal, textSobre, textCidade, textEstiloMusical, textInstrumentoMusical, textEstiloArtista;
    ImageView imagemPerfil;
    EditText textCadNome, textCadLocal, textCadSobre, textCadCidade, textCadGeneroMusical, textCadInstrumentoMusical;
    Button btnPublico, btnArtista, btnCancelar, btnAvancar;

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

    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty() );
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