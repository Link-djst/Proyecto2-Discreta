import java.util.ArrayList;

import javafx.scene.control.Button;

public class Vertex extends Button {
	private ArrayList<Vertex> adyacent;
	private String id, ady;
	private int i; 
	
	Vertex(String id){
		super(id);
		this.id = id;
		/*adyacent = new ArrayList<Vertex>(0);
		ady = "";*/
	}
	
	public String getD(){
		return this.id;
	}
	
	public void Add(Vertex v){
		if(adyacent.contains(v)){
			System.out.println("Ya Estan unidos estos dos vértices");
		}
		else {
			adyacent.add(v);
		}
	}
	
	public String toString(){
		ady = "";
		for (i=0;i<adyacent.size();i++){
			ady+=" "+adyacent.get(i).getD();
		}
		return (id+ady);
	}
}
