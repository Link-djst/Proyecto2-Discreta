import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class myJController {

    @FXML
    private Button btn_CreateGraph;

    @FXML
    private TextField tf_x;

    @FXML
    private TextField tf_y;
    
    private Vertex v1 = new Vertex("v1");
    private Vertex v2 = new Vertex("v2");
	private Edge e;
	

    @FXML
    void onCreateGraph(ActionEvent event) {
    	
    	e = new Edge();
    	if((!tf_x.getText().equals("")) && (!tf_y.getText().equals(""))){
    		System.out.println("ok");
    	}
    }
}

