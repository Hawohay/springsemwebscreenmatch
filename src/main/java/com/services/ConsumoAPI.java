//No próximo vídeo, iremos consumir uma API para busca de dados de séries. Para tal,
// criaremos a classe chamada ConsumoAPI, dentro de um pacote chamado service.
// Nele teremos um método chamado ObterDados, que devolve uma String com o
// json que corresponde à resposta da requisição.
//
//Como é um procedimento muito similar ao que foi feito no último curso da
// formação Java Orientação a Objetos, vamos deixar aqui já disponilizado
// para que você copie o código desse método e cole em sua classe, a fim de agilizar os estudos.
// Mas caso você queira voltar na formação anterior para rever a explicação, clique para acessar o link da aula

package com.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public String obterDados(String address) {

        // Cria um novo cliente HTTP, responsável por enviar requisições e receber respostas.
        HttpClient client = HttpClient.newHttpClient();

        // Constrói uma requisição HTTP GET usando o endereço (URI) fornecido.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address)) // Define o endereço da requisição.
                .build(); // Finaliza a construção da requisição.

        // Declara uma variável para armazenar a resposta da requisição.
        HttpResponse<String> response = null;

        try {
            // Envia a requisição HTTP e espera pela resposta. O corpo da resposta será tratado como uma string.
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Trata possíveis erros de I/O que podem ocorrer durante o envio da requisição ou recebimento da resposta.
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            // Trata interrupções na thread durante o processo de envio e recebimento.
            throw new RuntimeException(e);
        }

        // Extrai o corpo da resposta como uma string (espera-se que seja um JSON ou texto simples).
        String json = response.body();

        // Retorna o conteúdo da resposta para quem chamou o método.
        return json;
    }




}
