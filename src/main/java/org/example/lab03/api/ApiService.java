package org.example.lab03.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.example.lab03.model.Book;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class ApiService {
    private static ApiService ksiazka;

    private ApiService() {
    }

    public static ApiService getInstance() {
        if (ksiazka == null) ksiazka = new ApiService();
        return ksiazka;
    }

    public List<Book> getallBook() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://stephen-king-api.onrender.com/api/books"))
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonArray booksArray = jsonObject.getAsJsonArray("data");

            Type ksiazkilist = new TypeToken<List<Book>>() {
            }.getType();

            return new Gson().fromJson(booksArray, ksiazkilist);
        } catch (URISyntaxException | InterruptedException | IOException e) {
            return Collections.emptyList();

        }

    }

    public Book getBook(int bookid) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://stephen-king-api.onrender.com/api/book/" + bookid))
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject booksArray = jsonObject.getAsJsonObject("data");

            Type ksiazkilist = new TypeToken<Book>() {
            }.getType();
            return new Gson().fromJson(booksArray, ksiazkilist);
        } catch (URISyntaxException | InterruptedException | IOException e) {
            return null;

        }

    }

}








