package br.com.faus.somdosbichos.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_salvar;
    private TextView txt_exibicao;
    private EditText edt_nome;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_exibicao = (TextView) findViewById(R.id.textoExibicaoId);
        edt_nome = (EditText) findViewById(R.id.editTextNomeId);

        btn_salvar = (Button) findViewById(R.id.botaoSalvarId);
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edt_nome.getText().toString();
                if(nome.equals("")){
                    Toast.makeText(MainActivity.this, "Por favor informe um nome!", Toast.LENGTH_SHORT).show();
                }else{
                    gravar(nome);
                    txt_exibicao.setText("Olá, " + nome);
                }
            }
        });

        buscar();
    }

    private void gravar(String nome) {
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nome", nome);
        editor.apply();
    }

    private void buscar(){
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, Context.MODE_PRIVATE);
        if(sharedPreferences.contains("nome")){
            String nome = sharedPreferences.getString("nome", null);
            txt_exibicao.setText("Olá, " + nome);
        }
    }
}
