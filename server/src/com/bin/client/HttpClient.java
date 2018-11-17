package com.bin.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public static void main(String[] args) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/invoker").openConnection();
        connection.setRequestProperty("interface","com.bin.Interface");
        connection.setRequestProperty("method","say");
        connection.setRequestProperty("type","java.lang.String");

        connection.setDoOutput(true);
        connection.setDoInput(true);

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write("OK".getBytes());
        outputStream.flush();
        outputStream.flush();
        System.out.println(connection.getResponseCode());
//        InputStream inputStream = connection.getInputStream();

    }
}
