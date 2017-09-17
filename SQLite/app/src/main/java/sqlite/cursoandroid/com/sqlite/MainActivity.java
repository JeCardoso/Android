package sqlite.cursoandroid.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            // Criar Tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3) ) ");

            //Inserir dados
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Marcos', 30) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Ana', 20) ");
			bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Jorge', 35) ");
			bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Gisele', 15) ");
			
			// Alterar dados
			bancoDados.execSQL("UPDATE pessoas SET idade = 32 WHERE nome = 'Jorge'");

			// Apagar Dados
			bancoDados.execSQL("DELETE FROM pessoas WHERE nome = 'Ana' ");
			
			// Criar um cursor para receber consulta
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas WHERE idade >= 30 AND nome LIKE '%ar%' ", null);

			// Pegar o índice das colunas na tabela
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");

			// Posicionar o cursor no primeiro item da consulta
            cursor.moveToFirst();

			// Mostrar os resultados
            while (cursor != null) {

                Log.i("RESULTADO - id: ", cursor.getString(indiceColunaId));
                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));

                cursor.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
