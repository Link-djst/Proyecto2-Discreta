import java.util.ArrayList;

public class Edge {
	private int weight;
	private Vertex v1, v2;
	private boolean enabled;
	
	Edge(){
		this.weight = 0;
		enabled = true;
	}
	
	public void Add(Vertex v1, Vertex v2){
		if(enabled == true){
			v1.Add(v2);
			v2.Add(v1);
		}
		enabled = false;
	}
	
	public void Weight(int w){
		this.weight = w;
	}
}
