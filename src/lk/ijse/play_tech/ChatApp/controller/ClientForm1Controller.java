package lk.ijse.play_tech.ChatApp.Controller;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class ClientForm1Controller {
    public ScrollPane msgContext;
    public TextField txtMessage;
    public AnchorPane context = new AnchorPane();

    final int PORT = 50000;
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
    boolean isUsed = false;

    public void initialize() {
        Platform.setImplicitExit(false);
        msgContext.setContent(context);
        msgContext.vvalueProperty().bind(context.heightProperty());
        msgContext.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        msgContext.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        lblClient.setText(LoginForm1Controller.name);

        new Thread(() -> {
            try {
                socket = new Socket("localhost", PORT);
                while (true) {
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    message = dataInputStream.readUTF();
                    System.out.println(message);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (message.startsWith("/")) {
                                BufferedImage sendImage = null;
                                try {
                                    sendImage = ImageIO.read(new File(message));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Image img = SwingFXUtils.toFXImage(sendImage, null);
                                ImageView imageView = new ImageView(img);
                                imageView.setFitHeight(150);
                                imageView.setFitWidth(150);
                                imageView.setLayoutY(i);
                                context.getChildren().add(imageView);
                                i += 150;
                            } else if (message.startsWith(LoginForm1Controller.name)) {
                                message = message.replace(LoginForm1Controller.name, "You");
                                Label label = new Label(message);
                                label.setStyle(" -fx-font-family: Ubuntu; -fx-font-size: 20px; -fx-background-color: #85b6ff; -fx-text-fill: #5c5c5c");
                                label.setLayoutY(i);
                                context.getChildren().add(label);
                            } else {
                                Label label = new Label(message);
                                label.setStyle(" -fx-font-family: Ubuntu; -fx-font-size: 20px; -fx-background-color: #CDB4DB; -fx-text-fill: #5c5c5c");
                                label.setLayoutY(i);
                                context.getChildren().add(label);
                            }
                            i += 30;
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        txtMessage.setOnAction(event -> {
            try {
                sendMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void sendMessage() throws IOException {
        if (isImageChoose) {
            dataOutputStream.writeUTF(path.trim());
            dataOutputStream.flush();
            isImageChoose = false;
        } else {
            dataOutputStream.writeUTF(lblClient.getText() + " : " + txtMessage.getText().trim());
            dataOutputStream.flush();
        }
        txtMessage.clear();
    }

    public void btnSendOnAction(MouseEvent mouseEvent) {
    }

    public void btnEmojiOnAction(MouseEvent mouseEvent) {
    }

    public void btnImageChooserOnAction(MouseEvent mouseEvent) {
    }

    public void btnExitOnAction(MouseEvent mouseEvent) {
    }
}
