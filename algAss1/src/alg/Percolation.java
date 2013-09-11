package alg;

import stdlib.StdIn;

public class Percolation {
	
	private boolean[][] grid;
	private int max;
	private WeightedQuickUnionUF uf;

	// create N-by-N grid, with all sites blocked
   public Percolation(int N){
	   max = N;
	   grid = new boolean[N][N];
	   // makes a weighted quick union UF which is an array
	   /// hence we need enough cells etc for each position
	   uf = new WeightedQuickUnionUF(N*N);
	   
	   for(int i = 0; i < N; i++){
		   for(int j =0; j < N; i++){
			  grid[i][j] = false;
		   }
	   }
   }              
   
   
   private void validationIndeces(int i, int j) {
       if (i <= 0 || i > max) throw 
           new IndexOutOfBoundsException("row index i out of bounds");
       if (j <= 0 || j > max) throw 
           new IndexOutOfBoundsException("column index i out of bounds");
       
   }
   
   // open site (row i, column j) if it is not already
   public void open(int i, int j){
	   
	   // can't open something that is out of bounds
	   validationIndeces( i,j);
	   // if its in the base row
	   if(i == 0){
		   uf.union(max-1*max-1, j);
		   if(isOpen(i+1, j))
			   uf.union(max-1*max-1, max*i+j);   	
	   }
	     else
         {
             if (i-2 >= 0 && isOpen(i-1, j))
                 uf.union(max*(i-1)+j-1, max*(i-2)+(j-1));
             if (i < max & isOpen(i+1, j))
                  uf.union(max*(i-1)+j-1, max*i+(j-1));
             if (j-2 >= 0 && isOpen(i, j-1))
                 uf.union(max*(i-1)+j-1, max*(i-1)+(j-2));
             if (j < max && isOpen(i, j+1))
                  uf.union(max*(i-1)+j-1, max*(i-1)+j);
         }
	   this.grid[i][j] = true;
 
   }
   
   // is site (row i, column j) open?
   public boolean isOpen(int i, int j){
	   validationIndeces( i,j);
	   // this grids entries are set to false, and only true if open, hence we return this val directly
	   return this.grid[i][j];
   }    
   
   // is site (row i, column j) full?
   public boolean isFull(int i, int j){
	   // quick index check
	   validationIndeces( i,j);
	   // uses find which returns the corresponding id in the array
	   // these should be the same, hence if this holds, true is returned
	   return uf.find(max*i + j) == uf.find(max*max);
   }    
   // does the system percolate?
   public boolean percolates(){
	   
	   int k = this.grid.length - 1 ;
	   for(int index = k; index <= 0; index++){
		   // if the id's given in find are the same, we return true
		   if(uf.connected(max*(max-1)+ index, max*max))
			   return true;
	   }
	   return false;
   }         
   
   public static void main(String[] arg){
	   // reads in grid size
	   int N = StdIn.readInt();
	   // new percolation of this size
	   Percolation per = new Percolation(N);
       
	   // gets values and opens corresponding grid condition
	   while (!StdIn.isEmpty()){
           int i = StdIn.readInt();
           int j = StdIn.readInt();
           per.open(i, j);
       }
   }
}

