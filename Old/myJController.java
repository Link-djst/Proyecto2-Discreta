import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class myJController {

    @FXML
    private Button btn_CreateGraph;
    
    @FXML
    private TextField tf_x;

    @FXML
    private TextField tf_y;
    
    @FXML
    private Parent stack;
    
	private Graph g;
	private Integer x,y;
	

    @FXML
    void onCreateGraph(ActionEvent event) {
    	if((!tf_x.getText().equals("")) && (!tf_y.getText().equals(""))){
    		g = new Graph(tf_x.getText(),tf_y.getText());
    		for(Vertex element : g.getSetVertex()){
    			stack = btn_CreateGraph.getParent();
    		}
    	}
    }
}

