package Stack;

import java.util.Stack;

public class PreviousSmallerElement {

    public static void previousSmaller(int arr[])
    {
        int n = arr.length;
        int res[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && arr[i] <= st.peek())
            {
                st.pop();
            }

            if(st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();

            st.push(arr[i]);
        }

        for(int x : res)
            System.out.print(x + " ");
    }

    public static void main(String[] args)
    {
        int arr[] = {4,5,2,10,8};

        previousSmaller(arr);
    }
}