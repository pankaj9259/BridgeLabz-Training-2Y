import java.util.Random;

public class MatrixOperationsAdvanced {

    public static double[][] randomMatrix(int r,int c){
        Random rand = new Random();
        double[][] m = new double[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) m[i][j] = rand.nextDouble()*10;
        return m;
    }

    public static double[][] transpose(double[][] a){
        int r=a.length, c=a[0].length; double[][] t=new double[c][r];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) t[j][i]=a[i][j];
        return t;
    }

    public static double det2(double[][] m){ return m[0][0]*m[1][1]-m[0][1]*m[1][0]; }

    public static double det3(double[][] m){
        double d = m[0][0]*(m[1][1]*m[2][2]-m[1][2]*m[2][1])
                 - m[0][1]*(m[1][0]*m[2][2]-m[1][2]*m[2][0])
                 + m[0][2]*(m[1][0]*m[2][1]-m[1][1]*m[2][0]);
        return d;
    }

    public static double[][] inverse2(double[][] m){
        double d = det2(m);
        if(Math.abs(d) < 1e-9) return new double[][]{};
        return new double[][]{{m[1][1]/d, -m[0][1]/d},{-m[1][0]/d, m[0][0]/d}};
    }

    public static double[][] inverse3(double[][] m){
        double d = det3(m);
        if(Math.abs(d) < 1e-9) return new double[][]{};
        double[][] adj = new double[3][3];
        for(int i=0;i<3;i++) for(int j=0;j<3;j++){
            double[][] minor = new double[2][2];
            int mi=0,mj=0;
            for(int r=0;r<3;r++) for(int c=0;c<3;c++) if(r!=i && c!=j){
                minor[mi][mj] = m[r][c];
                mj++; if(mj==2){ mi++; mj=0; }
            }
            double cof = ((i+j)%2==0?1:-1) * (minor[0][0]*minor[1][1] - minor[0][1]*minor[1][0]);
            adj[j][i] = cof; // transpose cofactor into adjoint
        }
        double[][] inv = new double[3][3];
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) inv[i][j] = adj[i][j] / d;
        return inv;
    }

    public static void print(double[][] m){
        for(double[] row:m){ for(double v:row) System.out.printf("%.4f ", v); System.out.println(); }
    }

    public static void main(String[] args){
        double[][] M2 = randomMatrix(2,2);
        System.out.println("M2"); print(M2);
        System.out.println("det2 = " + det2(M2));
        System.out.println("inv2"); print(inverse2(M2));
        double[][] M3 = randomMatrix(3,3);
        System.out.println("M3"); print(M3);
        System.out.println("det3 = " + det3(M3));
        System.out.println("inv3"); print(inverse3(M3));
    }
}
