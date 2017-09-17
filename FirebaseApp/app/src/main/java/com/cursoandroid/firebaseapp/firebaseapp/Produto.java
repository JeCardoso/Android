package com.cursoandroid.firebaseapp.firebaseapp;

public class Produto {
    private String descricao;
    private String cor;
    private String fabricante;

    public Produto() {}

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCor() {
        return cor;
    }

    public String getFabricante() {
        return fabricante;
    }
}
