import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws IOException {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("firstBoard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");

            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        }catch (Exception e){
            System.out.println(e );
        }


    }

    public static void main(String[] args) {
        launch();
    }
}
