package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.InfoJogo
import br.com.alura.alugames.modelo.Jogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*

class ConsumoApi {

    private val leitura = Scanner(System.`in`)
    fun buscaJogo(id: String): Jogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id";
        val client: HttpClient = HttpClient.newHttpClient();
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();

        val response = client.send(request, HttpResponse.BodyHandlers.ofString());

        val json = response.body();
        val gson = Gson();

        var meuJogo: Jogo? = null;
        var infoJogo: InfoJogo? = null;
        val resultado = runCatching {
            infoJogo = gson.fromJson(json, InfoJogo::class.java);
            meuJogo = Jogo(infoJogo!!.info.title, infoJogo!!.info.thumb);
        }

        resultado.onFailure {
            println("Id não encontrado. Tente outro ID");
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N");
            val opcao = leitura.nextLine();
            if (opcao.equals("s", true)) {
                println("Insira a descrição:");
                val descricaoPersonalizada = leitura.nextLine();
                meuJogo?.descricao = descricaoPersonalizada;
            }
        };
        return meuJogo;
    }
}