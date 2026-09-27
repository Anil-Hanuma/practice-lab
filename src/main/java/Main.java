import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0", 8080),
                0
        );

        server.createContext("/", Main::handleRequest);

        server.start();

        System.out.println("Server started on port 8080");
    }

    private static void handleRequest(HttpExchange exchange)
            throws IOException {

        String response = "Hello from Java Maven Docker Application!";

        exchange.sendResponseHeaders(200, response.length());

        try (OutputStream output = exchange.getResponseBody()) {
            output.write(response.getBytes());
        }
    }
}
