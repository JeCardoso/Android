package com.cursoandroid.autenticacaousuario.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        // Cadastrar usuário - ao cadastrar o usuário fica logado no sistema
        firebaseAuth.createUserWithEmailAndPassword("joca@hotmail.com","jhon589")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("createUser", "Usuario cadastrado com sucesso!!!");
                        }
                        else{
                            Log.i("createUser", "Erro ao cadastrar usuario!!!" + task.getException());
                        }
                    }
                });

        // Logar o usuário
        firebaseAuth.signInWithEmailAndPassword("jean@hotmail.com","jean123").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("createUser", "Login feito com sucesso!!!");
                }
                else{
                    Log.i("createUser", "Erro ao fazer login do usuario!!!");
                }
            }
        });

        // Verifica se o usuário está logado
        if(firebaseAuth.getCurrentUser() != null) {
            Log.i("verificaUsuario", "Usuário está logado!!!");
        }
        else{
            Log.i("verificaUsuario", "Usuário não está logado!!!");
        }

        // Deslogar usuário
        firebaseAuth.signOut();

    }
}