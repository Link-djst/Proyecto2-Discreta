import java.util.ArrayList;

public class Edge {
	private int weight;
	private Vertex v1, v2;
	private boolean enabled;
	
	Edge(){
		this.setWeight(0);
		enabled = true;
	}
	
	public void Add(Vertex v1, Vertex v2){
		if(enabled == true){
			/*v1.Add(v2);
			v2.Add(v1);*/
		}
		enabled = false;
	}
	
	public void Weight(int w){
		this.setWeight(w);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Vertex getV1() {
		return v1;
	}

	public void setV1(Vertex v1) {
		this.v1 = v1;
	}

	public Vertex getV2() {
		return v2;
	}

	public void setV2(Vertex v2) {
		this.v2 = v2;
	}
}
