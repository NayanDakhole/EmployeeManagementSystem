package employee.management.system;
// ServerApp.java
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;

        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("Server is running on http://localhost:" + serverPort);
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Hello! Your Swing application can be accessed here.";

            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
