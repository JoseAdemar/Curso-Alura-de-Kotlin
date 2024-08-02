package br.com.alura.alugames.modelo

import com.google.gson.annotations.SerializedName

data class Jogo(var titulo: String, val capa: String) {

    public var descricao: String? = "";

    override fun toString(): String {
        return "Meu jogo:\n" +
                "Título: $titulo' \n" +
                "Capa: $capa\n" +
                "Descrição: $descricao";
    }
}