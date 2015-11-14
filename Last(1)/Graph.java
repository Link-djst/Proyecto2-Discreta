
import java.util.Vector;

public class Graph {
	private  Vertex[] setVertex;
	private Integer[][] adyacencyMatrix;
	private int x,y,size,i,j,current;
	private String line;
	
	public Graph(String x, String y){
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		size = this.x*this.y;
		
		adyacencyMatrix = new Integer[size][size];
		
		this.setVertex = new Vertex[size];
		for(i=0;i<size;i++){
			this.setVertex[i]= new Vertex(i);
			this.setVertex[i].setPrefWidth(700/this.x);
			this.setVertex[i].setPrefWidth(700/this.y);
		}
		
		AdyacencyMatrix();
		
	}
	public Vertex getVertex(int pos){
		return this.setVertex[pos];
	}
	
	public void initAdyacencyMatrix(){
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
				this.adyacencyMatrix[i][j]=0;
			}
		}
	}
	public void showAdyacencyMatrix(){
		for(i=0;i<size;i++){
			line = "[";
			for(j=0;j<size;j++){
				line+=" "+this.adyacencyMatrix[i][j];
			}
			line+=" ]";
			System.out.println(line);
		}
	}
	
	public void AdyacencyMatrix(){
		initAdyacencyMatrix();
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
				current = this.setVertex[i].getNumber();
				try{
					if((current%this.x)!=this.x-1){
						this.adyacencyMatrix[current][current+1] = 1;
					}
				}catch(Exception e){
				}try{
					if((current%this.x)!=0){
						this.adyacencyMatrix[current][current-1] = 1;
					}
				}catch(Exception e){
				} try{
					this.adyacencyMatrix[current][current+this.x] = 1;
				}catch(Exception e){
				} try{
					this.adyacencyMatrix[current][current-this.x] = 1;
				} catch(Exception e){
				}
			}
		}
			showAdyacencyMatrix();
	}
	
	public Vertex[] getSetVertex(){
		return setVertex;
	}
	public Integer[] getAdyacencyList(int vertex){
			String index ="";
			Integer[] dummy = adyacencyMatrix[vertex];
			Vector<Integer> dummy2 = new Vector<Integer>();
			for(int i = 0; i< size; i++){
				if(dummy[i]==1){
					dummy2.add(i);
					index = index +" "+ i;
    		}
    	}
    	System.out.println(vertex+" adyacent to "+index);
    	Integer[] adyacencyList = new Integer[dummy2.size()];
    	dummy2.toArray(adyacencyList);
		return adyacencyList;
	}
	
}
