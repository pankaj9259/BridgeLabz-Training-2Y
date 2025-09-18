import java.util.Random;

public class MatrixOperationsBasic {

    public static int[][] randomMatrix(int r,int c){
        Random rand = new Random();
        int[][] m = new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) m[i][j] = rand.nextInt(10);
        return m;
    }

    public static int[][] add(int[][] a,int[][] b){
        int r=a.length,c=a[0].length; int[][] out=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) out[i][j]=a[i][j]+b[i][j];
        return out;
    }

    public static int[][] subtract(int[][] a,int[][] b){
        int r=a.length,c=a[0].length; int[][] out=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) out[i][j]=a[i][j]-b[i][j];
        return out;
    }

    public static int[][] multiply(int[][] a,int[][] b){
        int r=a.length, c=b[0].length, common=a[0].length;
        int[][] out=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) for(int k=0;k<common;k++) out[i][j]+=a[i][k]*b[k][j];
        return out;
    }

    public static void print(int[][] m){
        for(int[] row:m){ for(int v:row) System.out.print(v+" "); System.out.println(); }
    }

    public static void main(String[] args){
        int[][] A = randomMatrix(2,3);
        int[][] B = randomMatrix(2,3);
        System.out.println("A"); print(A);
        System.out.println("B"); print(B);
        System.out.println("A+B"); print(add(A,B));
        System.out.println("A-B"); print(subtract(A,B));
        int[][] C = randomMatrix(3,2);
        System.out.println("A*C"); print(multiply(A,C));
    }
}
