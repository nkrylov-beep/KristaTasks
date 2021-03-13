package ru.krista.edu.distrib.tech.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class PortScanner {
    static final int PORT_COUNT = 65535;
    static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        for (int i = 0; i < PORT_COUNT; ++i) {
            System.out.print("Port " + i + " is scanned...");
            if (isUsed(i)) System.out.print(" Port " + i + " is used!");
            System.out.println();
        }
    }

    static boolean isUsed(int port) {
        boolean isUsed = true;
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(HOST, port), 200);
        } catch (IOException e) {
            isUsed = false;
        }
        return isUsed;
    }
}
