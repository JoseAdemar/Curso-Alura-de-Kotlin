package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import br.com.alura.alugames.utilitario.transformarEmIdade
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)
    val informacoesDoGamer = Gamer.criarGamer(leitura)
    val jogosBuscados = mutableListOf<Jogo?>()

    do {
        println("Digite um código de jogo para buscar:");
        val busca = leitura.nextLine();

        val buscarJogo = ConsumoApi();
        val resultado = buscarJogo.buscaJogo(busca);

        jogosBuscados.add(resultado)

        println("Deseja buscar um novo jogo S/N?")
        val pergunta = leitura.nextLine();

    } while (pergunta.equals("s", true))

    println(informacoesDoGamer)
    println("Idade do gamer: " + informacoesDoGamer.dataNascimento?.transformarEmIdade())
    println(jogosBuscados)

    jogosBuscados.sortBy {
        it?.titulo
    }
    jogosBuscados.forEach{
        println("Título: " + it?.titulo)
    }

    val jogosFiltrados = jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }

    println("\n Jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N?")
    val opcao = leitura.nextLine();
    if (opcao.equals("s", true)){
        println("\n------------------------")
        println(jogosBuscados)
        println("Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada:")
    println(jogosBuscados)
}