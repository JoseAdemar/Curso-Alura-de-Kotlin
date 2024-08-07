package br.com.alura.alugames.utilitario

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    val formmatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    val dataNascimento = LocalDate.parse(this, formmatter)
    val dataHoje = LocalDate.now()
    idade = Period.between(dataNascimento, dataHoje).years
    return idade
}