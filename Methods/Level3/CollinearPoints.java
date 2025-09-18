public class CollinearPoints {

    public static boolean collinearByArea(int x1,int y1,int x2,int y2,int x3,int y3){
        double area = 0.5 * (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2));
        return Math.abs(area) < 1e-9;
    }

    public static boolean collinearBySlope(int x1,int y1,int x2,int y2,int x3,int y3){
        // Compare (y2-y1)/(x2-x1) and (y3-y2)/(x3-x2) without dividing to avoid division by zero
        return (long)(y2 - y1)*(x3 - x2) == (long)(y3 - y2)*(x2 - x1);
    }

    public static void main(String[] args){
        int x1=2,y1=4,x2=4,y2=6,x3=6,y3=8;
        System.out.println("By area collinear? " + collinearByArea(x1,y1,x2,y2,x3,y3));
        System.out.println("By slope collinear? " + collinearBySlope(x1,y1,x2,y2,x3,y3));
    }
}
