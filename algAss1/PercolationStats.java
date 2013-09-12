/**
 * Auto Generated Java Class.
 */
public class PercolationStats2 {
    private Percolation2 p;
    private double mean = 0;
    private double stdDev = 0;
    private double minConfInt = 0;
    private double maxConfInt = 0;
    private double[] percolateValues;
    private double percolateValue = 0;
    private int randomRowSelect;
    private int randomColumnSelect;
    
    public PercolationStats2(int N, int T){
        validationIndeces(N, T);
        percolateValues = new double[T];
        for (int i = 0; i < T; ++i) {
            p = new Percolation2(N);
            int count =0;
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
               // StdOut.println("row: " + row + " col: " + col);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                    count++;
                }
            }
            percolateValues[i] = (double)count/(double) (N*N);
        }
    }
    
    private void validationIndeces(int N, int T) {
        if (N <= 0 || T <= 0) throw 
            new IllegalArgumentException("dimen or no. of experiment error");
    }
    public double mean(){
        return StdStats.mean(percolateValues);
    }
    public double stddev(){
        return StdStats.stddev(percolateValues);
    }
    public static void main(String[] args){
        int N = 0;
        int T = 0;        
        if (args.length > 0) {
            try {
                N = Integer.parseInt(args[0]);
                T = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.print("Number format incorrect !");
            }
            //System.out.println (N) ;
            //System.out.println (T) ;
        }
        
        PercolationStats2 pStats = new PercolationStats2(N, T);
        System.out.println(pStats.mean());
        System.out.println(pStats.stddev());
    }
    
    
}
