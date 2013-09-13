/**
 * Auto Generated Java Class.
 */
public class Percolation{
    
    private boolean[] grid;
    private int max;
    private WeightedQuickUnionUF uf;
    
    public Percolation(int N){
        max = N;
        grid = new boolean[max*max];
        for(int index = 0; index < grid.length; index++)
            grid[index] = false;
        
        uf = new WeightedQuickUnionUF(max*max+2);
    }
    
    private void validation(int i, int j) {
        if (i < 1 || i > max )
           throw new IndexOutOfBoundsException("index i out of bounds");
        if( j < 1 || j > max) 
            throw new IndexOutOfBoundsException("index j out of bounds");
    }
    public void open(int i, int j){
        validation(i, j);
        int seed = max *(i-1) + (j-1);
        grid[seed] = true;
        
        // Upper Cell
        if ((i > 1) && isOpen(i-1, j))
            uf.union(seed, max * (i-2) + j-1);
        
        //Lower Cell
        if ((i < max) && isOpen(i+1, j))
            uf.union(seed, (max * i) + j-1);
        
        //Left Cell
        if ((j > 1) && isOpen(i, j-1))
            uf.union(seed, max*(i-1) + (j - 2));
        
        //Right Cell
        if ((j < max) && isOpen(i, j+1))
            uf.union(seed, max*(i-1) + j);
        
        if (i == 1)
            uf.union(max*max, seed);
        
        if (i == max) 
            uf.union(max*max + 1, seed);
    }
    
    public boolean isOpen(int i, int j){
        validation(i, j);
        return grid[max * (i-1) + (j-1)];
    }
    
    public boolean isFull(int i, int j) {
        validation(i, j);
        return isOpen( i, j) && uf.connected(max*max , max*(i-1) + (j-1));
    }
    
    public boolean percolates() {
        return uf.connected(max*max, max*max+1);
    }
  }
