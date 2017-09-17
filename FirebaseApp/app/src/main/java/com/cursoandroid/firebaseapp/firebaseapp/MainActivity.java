package com.cursoandroid.firebaseapp.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia = databaseReferencia.child("produtos");
    private DatabaseReference produto001Referencia = databaseReferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // Inserir dados

        Usuario usuario = new Usuario();
        usuario.setNome("Ana");
        usuario.setSobrenome("Carla");
        usuario.setIdade(75);
        usuario.setSexo("Feminino");

        // Define um nó
        usuarioReferencia.child("001").setValue(usuario);

        Produto produto = new Produto();
        produto.setDescricao("Carro Japonês");
        produto.setCor("Azul");
        produto.setFabricante("Kia");

        // Define um nó
        produtoReferencia.child("001").setValue(produto);

        */

        //Consultar dados
        produto001Referencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("Firebase", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
