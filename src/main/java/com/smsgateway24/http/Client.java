package com.smsgateway24.http;

import com.smsgateway24.token.Token;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;

public class Client {
    final static long DEFAULT_TIMEOUT = 3;
    final static String BASE_URL = "https://smsgateway24.com/getdata/";

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NEVER)
            .connectTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
            .build();

    protected Token token;
    protected String baseUrl;

    public Client() {
        this.token = new Token("NO_TOKEN");
        this.baseUrl = BASE_URL;
    }

    public Client(Token token) {
        this.token = token;
        this.baseUrl = BASE_URL;
    }


    public String get(String endpoint, Map<Object, Object> data) {
        if(!Objects.equals(this.token.getValue(), "NO_TOKEN")) {
            data.put("token", this.token);
        }

        System.out.println(URI.create(BASE_URL + endpoint + "?" + ofFormData(data)));
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(BASE_URL + endpoint + "?" + ofFormData(data)))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();
        try {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print response headers
        //HttpHeaders headers = response.headers();
        //headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "";

    }

    public String post(String endpoint, Map<Object, Object> data) {

        if(this.token.getValue() != null)
        data.put("token", this.token.getValue());

        HttpRequest request = HttpRequest.newBuilder()
                .POST(ofFormData(data))
                .uri(URI.create(BASE_URL + endpoint))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // print status code
            System.out.println(response.statusCode());

            // print response body
            System.out.println(response.body());
            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }


    // Sample: 'password=123&custom=secret&username=abc&ts=1570704369823'
    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if(entry.getValue() != null) {
                if (builder.length() > 0) {
                    builder.append("&");
                }
                builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
                builder.append("=");
                builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
            }
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
}
