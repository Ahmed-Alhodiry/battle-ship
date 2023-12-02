import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.w3c.dom.Node;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @FXML
    AnchorPane myPane;
    @FXML
    Button myButton;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    public void Click1(javafx.event.ActionEvent e) throws IOException {
        file = new File("sea.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView= new MediaView(mediaPlayer);



        root =  FXMLLoader.load(getClass().getResource("secondBoard.fxml"));
        root.getChildren().add(mediaView);
        stage = (Stage)((Button) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("yooyo");
        stage.setFullScreen(true);
        stage.show();
        mediaPlayer.play();

    }
}
