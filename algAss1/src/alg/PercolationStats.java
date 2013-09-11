package alg;

import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StdIn;

public class PercolationStats {
	
	private double threshold[];
	private double sum;
	private int experiments;
	private int grid;
	private double mean;
	private double stDev;
	
	// perform T independent computational experiments on an N-by-N grid
	   public PercolationStats(int N, int T){
		   
		   if(N <= 0 || T <= 0){
			    throw new IllegalArgumentException("T or N are outofBounds");
		   }
		   
		  this.threshold = new double[T];
		  this.sum = 0;
		  this.experiments = T;
		  this.grid = N;
		  
		  for(int t = 0; t < T; t++){
				   Percolation current = new Percolation(N);
				   int count = 0;
				   while(!current.percolates()){
					   int i = StdRandom.uniform(N) + 1;
					   int j = StdRandom.uniform(N) + 1;
					   if(!current.isOpen(i, j)){
						   current.open(i,j);
						   count++;
					   }
				   }
				   threshold[t] = (double)count/(double)(N*N);
				   sum += threshold[t];  
		   }
	   }    
	   
	// sample mean of percolation threshold
	   public double mean(){
			 return this.sum/this.experiments;
	   }   
	   
	   // sample standard deviation of percolation threshold
	   public double stddev(){
		   this.mean  = mean();
		   this.stDev = 0.0;
		   for(int i = 0; i < this.experiments; i++){
			   stDev += Math.pow(this.threshold[i] - mean, 2);
		   }
		   this.stDev /= (this.experiments -1);
		   return this.stDev;
	   }
	   
	   // returns lower bound of the 95% confidence interval
	   public double confidenceLo(){
		   return this.mean - (double)(1.96*this.stDev/ Math.pow(experiments,0.5));
	   }  
	   
	   // returns upper bound of the 95% confidence interval
	   public double confidenceHi(){
		   return this.mean + (double)(1.96*this.stDev/ Math.pow(experiments,0.5));
	   }
	   
	   // test client, described below
	   public static void main(String[] args){
		   
		   int N = StdIn.readInt();
		   int T = StdIn.readInt();
	       if (args.length > 0) {
	            try {
	                N = Integer.parseInt(args[0]);
	                T = Integer.parseInt(args[1]);
	            } catch (NumberFormatException e) {
	                System.err.print("You have not put in a number");
	            }
	       }
		   PercolationStats current = new PercolationStats(N, T);
		   StdOut.println(current.mean + " mean");
		   StdOut.println(current.stDev + "standard dev ");
		   StdOut.println(current.confidenceLo() + " lower confidence interval");
		   StdOut.println(current.confidenceHi() + " upper confidence interval ");
		   
	   }   
}