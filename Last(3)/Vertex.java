
import javafx.scene.control.Button;

public class Vertex extends Button {
	private int id; 
	
	Vertex(Integer id){
		super();
		this.id = id;
	}
	
	public Integer getNumber(){
		return this.id;
	}
}
