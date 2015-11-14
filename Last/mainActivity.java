import java.util.LinkedList;
import java.util.Queue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class mainActivity extends Application {
	private Integer position;
	private Button cBtn;
	private Integer[] adyacencyVertex;
	private Vertex[] setVertex;
	private TextField x;
	private TextField y;
	private StackPane frame;
	private Queue<Integer> frontier;
	private Queue<Integer> search;
	private Boolean[] visited;
	private Graph G;
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
		search = new LinkedList<Integer>();
		frontier = new LinkedList<Integer>();
		FlowPane fp = new FlowPane();
		this.G = new Graph(x.getText(), y.getText());
		this.setVertex = G.getSetVertex();
		for(int i = 0;i < setVertex.length;i++){
			setVertex[i].setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	int current = ((Vertex) e.getSource()).getNumber();
			    	adyacencyVertex = G.getAdyacencyList(current);
			    	path(current);
			    	System.out.println(search.toString());
			    }
			});
			fp.getChildren().add(setVertex[i]);
		}
		frame.getChildren().add(fp);
	}
	
	private void path(Integer current){
		if(search.size()<2){
    		search.add(current);    		
    	} else {
    		search.poll();
    		search.add(current);
    		createPath(search);
    	}
	}
	
	private void createPath(Queue<Integer> search){
		frontier.add(search.peek());
		while (!frontier.isEmpty()){
			position = frontier.poll();
			for(Integer next : G.getAdyacencyList(position)){
				System.out.println(next);
			}
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
