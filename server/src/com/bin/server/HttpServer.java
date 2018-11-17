package com.bin.server;

import com.bin.util.Collections;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServer {

    static String ok = "OK";

    public static void main(String[] args) throws IOException {
        com.sun.net.httpserver.HttpServer httpServer = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8080),0);
        httpServer.createContext("/invoker", new ServerHttpHandler());
        httpServer.start();
    }

    static class ServerHttpHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
                //请求头
            Headers headers = httpExchange.getRequestHeaders();

            System.out.println(httpExchange.getRequestURI().getQuery());
            System.out.println(httpExchange.getRequestURI().getRawQuery());
            //调用接口
            String anInterface = headers.getFirst("interface");
            String method = headers.getFirst("method");
            String type = headers.getFirst("type");
            System.out.println(anInterface);
            System.out.println(method);
            System.out.println(type);
            httpExchange.sendResponseHeaders(200,0);
            if (anInterface == null && method == null) {
                OutputStream responseBody = httpExchange.getResponseBody();
                responseBody.write(ok.getBytes("utf-8"));
                responseBody.close();
            }
        }
    }
}
