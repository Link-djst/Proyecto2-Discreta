
public class Graph {
	private  Vertex[] setVertex;
	private Integer[][] adyacencyMatrix;
	private int x,y,size,i,j,k,current;
	private Vertex v;
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
			/*System.out.println(line);*/
		}
	}
	
	public void AdyacencyMatrix(){
		k=0;
		initAdyacencyMatrix();
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
				current = this.setVertex[k].getNumber();
				/*Caso banda superior*/
				if(current<this.x){
					/*Caso común*/
					if((current != this.x-1) && (current != 0)){
						this.adyacencyMatrix[i][current-1] = 1;
						this.adyacencyMatrix[i][current+1] = 1;
						this.adyacencyMatrix[i][current+this.x] = 1;
					}
					/*Caso de x*/
					else if(current == this.x-1){
						this.adyacencyMatrix[i][current-1] = 1;
						this.adyacencyMatrix[i][current+this.x] = 1;
					}
					/*Caso de cero*/
					else if(current == 0){
						this.adyacencyMatrix[i][current+1] = 1;
						this.adyacencyMatrix[i][current+this.x] = 1;
					} 
				}
			}
			
			/*Caso banda inferior*/
			if((current<size)&&(current>size-this.x)){
				/*Caso común*/
				if((current != size-1) && (current != size-this.x-1)){
					this.adyacencyMatrix[i][current-1] = 1;
					this.adyacencyMatrix[i][current+1] = 1;
					this.adyacencyMatrix[i][current-this.x] = 1;
				}
				/*Caso de x*/
				else if(current == size-this.x-1){
					this.adyacencyMatrix[i][current+1] = 1;
					this.adyacencyMatrix[i][current-this.x] = 1;
				}
				/*Caso de cero*/
				else if(current == size-1){
					this.adyacencyMatrix[i][current-1] = 1;
					this.adyacencyMatrix[i][current-this.x] = 1;
				} 
			}
			k++;
		}
			showAdyacencyMatrix();
	}
	
	public Vertex[] getSetVertex(){
		return setVertex;
	}
	public Integer[] getAdyacency(int vertex){
		return adyacencyMatrix[vertex];
	}
	
}
