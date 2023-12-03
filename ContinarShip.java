
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import org.w3c.dom.Node;
import javafx.scene.image.Image;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ContinarShip extends Parent {
    private VBox containar;

    private double startX,startY;
    private double oldx,oldy;
    public ContinarShip() {

        containar = new VBox();
        containar.setPrefWidth(287);
        containar.setPrefHeight(239);
        containar.setLayoutX(991);
        containar.setLayoutY(400);
        createShip();
        String cssLayout = "-fx-border-color: white;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: dashed;\n";
        containar.setStyle(cssLayout);
        containar.setSpacing(2);


    }
    public VBox getContainar(){
        return this.containar;
    }
    public void createShip()  {
        Image image[] = {new Image(getClass().getResourceAsStream("ship_r_5_h.png")),
                new Image(getClass().getResourceAsStream("ship_r_4_h.png")),
                new Image(getClass().getResourceAsStream("ship_r_3_2_h.png")),
                new Image(getClass().getResourceAsStream("ship_r_3_1_h.png")),
                new Image(getClass().getResourceAsStream("ship_r_2_h.png"))
        };

        Arrays.stream(image).forEach(this::addToContainar);
    }
    public void addToContainar(Image node){
        ImageView mediaView = new ImageView(node);

        mediaView.setOnMousePressed(e->{
            startX = e.getSceneX() - mediaView.getTranslateX();
            startY = e.getSceneY() - mediaView.getTranslateY();

        });


        mediaView.setOnMouseDragged(e->{
                mediaView.setTranslateX(e.getSceneX() - startX);
                mediaView.setTranslateY(e.getSceneY()- startY);
        });






        containar.getChildren().add(mediaView);
    }

}
