import java.util.Arrays;
import java.util.Queue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class mainActivity extends Application {
	private Button cBtn;
	private Integer[] adyacencyVertex;
	private Vertex first, last;
	private Vertex[] setVertex;
	private TextField x;
	private TextField y;
	private StackPane frame;
	private Queue<Vertex> frontier;
	private Boolean[] visited;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		cBtn = new Button("Create Matrix");
		x = new TextField("X: ");
		y = new TextField("Y: ");
		HBox hb = new HBox();
		hb.getChildren().addAll(x,y,cBtn);
		frame = new StackPane();
		frame.getChildren().add(hb);
		Scene scene = new Scene(frame, 700, 625);
		
		cBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	initGraph();
		    }
		});
		
		primaryStage.resizableProperty().setValue(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Proyecto Discreta 2");
		primaryStage.show();
	}
	
	private void initGraph(){
		FlowPane fp = new FlowPane();
		Graph G = new Graph(x.getText(), y.getText());
		this.setVertex = G.getSetVertex();
		for(int i = 0;i < setVertex.length;i++){
			setVertex[i].setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	int current = ((Vertex) e.getSource()).getNumber();
			    	adyacencyVertex = G.getAdyacencyList(current);
			    }
			});
			fp.getChildren().add(setVertex[i]);
		}
		frame.getChildren().add(fp);
		
	}
	
	
	public static void main(String[] args){
		launch(args);
	}

}
