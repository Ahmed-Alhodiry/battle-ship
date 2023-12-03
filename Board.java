import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board extends Parent {

    private VBox main;

    public Board() {
        main = new VBox();
        main.setSpacing(1);
        for (int i = 0 ; i < 10 ; i++){
            HBox rows = new HBox();
            for (int j = 0; j < 10; j++) {
                Cell c = new Cell();

                rows.getChildren().add(c);
            }
            rows.setSpacing(1);
            main.getChildren().add(rows);
        }
        main.setLayoutX(430);
        main.setLayoutY(150);

    }
    public Parent GetBoard(){
        return this.main;
    }
}
