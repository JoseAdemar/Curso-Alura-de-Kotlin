package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Jose", "jose@email.com");
    val gamer2 = Gamer("Jeni", "jeni@email.com", "19/09/1992", "jeniblo");

    gamer1.let {
        it.dataNascimento = "18/06/1990"
        it.usuario = "joseai"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    println(gamer2)
}