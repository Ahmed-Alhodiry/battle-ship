import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

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
        file = new File("space.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);

    }


    public void Click1(javafx.event.ActionEvent e) throws IOException {


        MediaView mediaView= new MediaView(mediaPlayer);
        mediaView.setFitHeight(1080);


        try{
        root =  FXMLLoader.load(getClass().getResource("secondBoard.fxml"));

        stage = (Stage)((Button) e.getSource()).getScene().getWindow();
        Board b = new Board();
        ContinarShip continarShip = new ContinarShip();
        scene = new Scene(root);



            scene.addEventFilter(MouseEvent.DRAG_DETECTED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(mouseEvent.getPickResult());

                }
            });


        stage.setScene(scene);
        stage.setTitle("yooyo");
        stage.setFullScreen(true);
        root.getChildren().addAll(mediaView,b.GetBoard(),continarShip.getContainar());
        stage.show();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        }catch (Exception s) {
            System.out.println(s);
        }


    }
}
