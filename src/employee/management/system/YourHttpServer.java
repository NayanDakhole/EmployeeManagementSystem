package employee.management.system;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class YourHttpServer {

    public static void main(String[] args) throws IOException {
        // Create an HTTP server that listens on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Create a context for the "/your-context" path and set the handler
        server.createContext("/your-context", new MyHandler());

        // Start the server
        server.setExecutor(null);
        server.start();
    }

    // Your existing MyHandler class
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String htmlResponse = "<html><body><applet code='YourAppletClass.class' width='300' height='300'></applet></body></html>";

            t.getResponseHeaders().set("Content-Type", "text/html");
            t.sendResponseHeaders(200, htmlResponse.length());
            OutputStream os = t.getResponseBody();
            os.write(htmlResponse.getBytes());
            os.close();
        }
    }
}
