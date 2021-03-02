package org.example;

import io.undertow.Undertow;
import io.undertow.util.Headers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Undertow server = Undertow.builder().addHttpListener(8000,
                "localhost").setHandler(exchange -> {
            exchange.getResponseHeaders()
                    .put(Headers.CONTENT_TYPE, "text/plain");
            exchange.getResponseSender().send("Krylov Nikita");
        }).build();
        server.start();
    }
}
