import java.util.Random;

public class FootballTeamHeights {
    public static int sum(int[] arr){ int s=0; for(int v:arr) s+=v; return s; }
    public static double mean(int[] arr){ return (double)sum(arr)/arr.length; }
    public static int min(int[] arr){ int m=arr[0]; for(int v:arr) if(v<m) m=v; return m; }
    public static int max(int[] arr){ int m=arr[0]; for(int v:arr) if(v>m) m=v; return m; }

    public static void main(String[] args){
        int[] heights = new int[11];
        Random r = new Random();
        for(int i=0;i<11;i++) heights[i] = 150 + r.nextInt(101); // 150..250 inclusive
        System.out.print("Heights (cm): ");
        for(int h:heights) System.out.print(h + " ");
        System.out.println();
        System.out.println("Shortest: " + min(heights));
        System.out.println("Tallest:  " + max(heights));
        System.out.printf("Mean: %.2f cm%n", mean(heights));
    }
}
