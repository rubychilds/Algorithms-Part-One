/**
 * Auto Generated Java Class.
 */
public class PercolationStats {
    private Percolation p;
    //private double mean = 0;
  //  private double stdDev = 0;
    private double[] percolateValues;
    private int T =0;
    public PercolationStats(int N, int T){
        validationIndeces(N, T);
        this.T = T;
        percolateValues = new double[T];
        for (int i = 0; i < T; ++i) {
            p = new Percolation(N);
            int count =0;
            while (!p.percolates()) {
                int row = StdRandom.uniform(N)+1;
                int col = StdRandom.uniform(N)+1;
               // StdOut.println("in stats row: " + row + " col: " + col);
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
    public double confidenceLo(){
     return mean() - (1.96*stddev())/(T^(1/2));
    }

    public double confidenceHi(){
     return mean() + (1.96*stddev())/(T^(1/2));
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
        else {
            N = StdIn.readInt();
            T = StdIn.readInt();
        }
        
        PercolationStats pStats = new PercolationStats(N, T);
        System.out.println("Mean: " + pStats.mean());
        System.out.println("Standard dev " + pStats.stddev());
        System.out.println("Confidence lower bound " + pStats.confidenceLo());
        System.out.println("Confidence upper bound " + pStats.confidenceHi());
    }
    
    
}
