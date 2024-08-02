package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:");
    val busca = leitura.nextLine();

    val buscarJogo = ConsumoApi();
    val resultado = buscarJogo.buscaJogo(busca);
    println(resultado);

}