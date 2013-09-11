package alg;

import stdlib.StdDraw;
import stdlib.StdIn;
import java.awt.Font;

public class PercolationVisualiser {

    // draw N-by-N percolation system
    public static void draw(Percolation perc, int N) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);

        // draw N-by-N grid
        int opened = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    opened++;
                }
                else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    opened++;
                }
                else
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(col - 0.5, N - row + 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.25*N, -N*.025, opened + " open sites");
        if (perc.percolates()) StdDraw.text(.75*N, -N*.025, "percolates");
        else                   StdDraw.text(.75*N, -N*.025, "does not percolate");

    }

    public static void main(String[] args) {

    	int N = 0;
        if (args.length > 0) {
            try {
                N = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.print("You have not put in a number");
            }
       }
        else 
        	N = StdIn.readInt();
        
        // repeatedly read in sites to open and draw resulting system
        Percolation p = new Percolation(N);
        draw(p, N);
        while (!StdIn.isEmpty()) {
            StdDraw.show(0);          // turn on animation mode
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            p.open(i, j);
            draw(p, N);
            StdDraw.show(100);        // pause for 100 miliseconds
        }
    }
}
