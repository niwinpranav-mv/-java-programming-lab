package deliveryapp;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.Files;
import java.util.*;

public class WebServer {

    // Hardcoded customer (mini project)
    static Customer customer =
            new Customer("Alice", "123 Java Lane", "alice", "1234");

    public static void main(String[] args) throws Exception {

        // 🔌 SERVER PORT
        HttpServer server = HttpServer.create(
                new InetSocketAddress(9090), 0
        );

        /* =========================
           LOGIN API
           http://localhost:9090/login?username=alice&password=1234
        ========================= */
        server.createContext("/login", exchange -> {
            try {
                Map<String, String> params = parse(exchange.getRequestURI());
                String response;

                if (customer.validateLogin(
                        params.get("username"),
                        params.get("password"))) {
                    response = "{\"status\":\"success\"}";
                } else {
                    response = "{\"status\":\"fail\"}";
                }

                sendJson(exchange, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        /* =========================
           ORDER API (dynamic items)
           http://localhost:9090/order?item=Burger&item=Fries
        ========================= */
        server.createContext("/order", exchange -> {
            try {
                Driver driver = new Driver("Bob", "Scooter");
                Order order = new Order(customer, driver);

                // Read selected items
                String query = exchange.getRequestURI().getQuery();
                if (query != null) {
                    for (String q : query.split("&")) {
                        if (q.startsWith("item=")) {
                            String item = q.split("=")[1];

                            switch (item) {
                                case "Burger":
                                    order.addItem(new Item("Burger", 8.99));
                                    break;
                                case "Fries":
                                    order.addItem(new Item("Fries", 3.50));
                                    break;
                                case "Pizza":
                                    order.addItem(new Item("Pizza", 12.00));
                                    break;
                            }
                        }
                    }
                }

                String response =
                        "{"
                                + "\"customer\":\"" + customer.getName() + "\","
                                + "\"address\":\"" + customer.getAddress() + "\","
                                + "\"driver\":\"" + driver.getName() + "\","
                                + "\"vehicle\":\"" + driver.getVehicle() + "\","
                                + "\"total\":" + order.getTotal()
                                + "}";

                sendJson(exchange, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        /* =========================
           SERVE FRONTEND FILES
           http://localhost:9090/login.html
        ========================= */
        server.createContext("/", exchange -> {
            try {
                String path = exchange.getRequestURI().getPath();
                if (path.equals("/")) path = "/login.html";

                File file = new File("deliveryapp/web page" + path);

                if (!file.exists()) {
                    exchange.sendResponseHeaders(404, -1);
                    return;
                }

                // Detect file type
                String contentType = "text/html";
                if (path.endsWith(".css")) contentType = "text/css";
                else if (path.endsWith(".js")) contentType = "application/javascript";

                byte[] data = Files.readAllBytes(file.toPath());
                exchange.getResponseHeaders().add("Content-Type", contentType);
                exchange.sendResponseHeaders(200, data.length);
                exchange.getResponseBody().write(data);
                exchange.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        server.start();
        System.out.println("✅ Server running at http://localhost:9090");
    }

    /* =========================
       SEND JSON
    ========================= */
    private static void sendJson(HttpExchange ex, String res) throws Exception {
        ex.getResponseHeaders().add("Content-Type", "application/json");
        ex.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        ex.sendResponseHeaders(200, res.length());
        OutputStream os = ex.getResponseBody();
        os.write(res.getBytes());
        os.close();
    }

    /* =========================
       QUERY PARAM PARSER
    ========================= */
    private static Map<String, String> parse(URI uri) {
        Map<String, String> map = new HashMap<>();
        if (uri.getQuery() == null) return map;

        for (String p : uri.getQuery().split("&")) {
            String[] pair = p.split("=");
            if (pair.length == 2) {
                map.put(pair[0], pair[1]);
            }
        }
        return map;
    }
}
