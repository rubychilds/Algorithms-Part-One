/**
 * Auto Generated Java Class.
 */
public class Percolation2 {
    
    private boolean[] grid;
    private int max;
    private WeightedQuickUnionUF uf;
    
    public Percolation2(int N){
        max = N;
        grid = new boolean[max*max];
        for(int index = 0; index < grid.length; index++)
            grid[index] = false;
        
        uf = new WeightedQuickUnionUF(max*max+2);
    }
    
    private void validation(int i, int j) {
      //  StdOut.println("current max is " + max);
      //  StdOut.println("current i is " + i);
      //  StdOut.println("current j is " + j);
        
        if (i < 0 || i > max-1 || j < 0 || j > max-1) 
            throw new IndexOutOfBoundsException("indices out of bounds");
    }
    public void open(int i, int j){
        validation(i, j);
        int seed = (max *i) + j;
        grid[seed] = true;
        
        // Upper Cell
        if ((i > 0) && isOpen(i-1, j))
            uf.union(seed, max * (i-1) + j);
        
        //Lower Cell
        if ((i < max-1) && isOpen(i+1, j))
            uf.union(seed, (max * i+1) + j);
        
        //Left Cell
        if ((j > 0) && isOpen(i, j-1))
            uf.union(seed, max * i + (j - 1));
        
        //Right Cell
        if ((j < max-1) && isOpen(i, j+1))
            uf.union(seed, max * i + (j+1));
        
        if (i == 0)
            uf.union(max*max-1, seed);
        
        if (i == max-1) 
            uf.union(max*max, seed);
    }
    
    public boolean isOpen(int i, int j) { // is site (row i, column j) open?
        validation(i, j);
        return grid[(max * i) + j];
    }
    
    public boolean isFull(int i, int j) { // is site (row i, column j) full?
        validation(i, j);
        return isOpen(i,j) && uf.connected(max*max -1, max*i + j);
    }
    
    public boolean percolates() {     // does the system percolate?
        return uf.connected(max*max-1, max*max);
    }
  }