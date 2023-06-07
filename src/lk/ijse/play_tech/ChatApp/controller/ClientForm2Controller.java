package lk.ijse.play_tech.ChatApp.Controller;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;

public class ClientForm2Controller {
    public ScrollPane msgContext;
    public TextField txtMessage;
    public AnchorPane context = new AnchorPane();

    final int PORT = 60000;
    public Label lblClient;
    public AnchorPane emoji;
    Socket socket;
    Socket imgSocket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String message = "";
    int i = 10;
    String path = "";
    public static boolean isImageChoose = false;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    File file;
    OutputStream imgOutputStream;
    InputStream imgInputStream;
    public static String name;
    boolean isUsed = false;

    public void btnSendOnAction(MouseEvent mouseEvent) {
    }

    public void btnEmojiOnAction(MouseEvent mouseEvent) {
    }

    public void btnImageChooserOnAction(MouseEvent mouseEvent) {
    }

    public void btnExitOnAction(MouseEvent mouseEvent) {
    }
}
