package br.com.munieri.cadastro.soa.boot;

import br.com.munieri.cadastro.soa.boot.server.ApplicationServer;
import br.com.munieri.cadastro.soa.boot.server.WebServer;

public class Main {

    public static void main(String[] args) throws Exception {
        WebServer server = new ApplicationServer();
        server.start();
    }
}
