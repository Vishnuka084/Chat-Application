package lk.ijse.play_tech.ChatApp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Client {
    private int port;
    private String name;
    private Socket accept;
    private Socket imgSocket;
    private ServerSocket serverSocket;
    private InputStream imgInputStream;
    private OutputStream imgOutputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String message = "";




}
