
public class Graph {
	private Vertex[] setVertex;
	private Integer[] adyacencyMatrix;
	private int x,y,size,i,j;
	private Vertex v;
	
	public Graph(String x, String y){
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		size = this.x*this.y;
		
		this.setVertex = new Vertex[size];
		for(i=0;i<size;i++){
			this.setVertex[i]= new Vertex("v"+i);
		}
		
	}
	
	public void AdyancencyMatrix(int x, int y){
		
	}
}
