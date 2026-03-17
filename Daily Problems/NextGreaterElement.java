package Stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void nextGreater(int arr[])
    {
        int n = arr.length;
        int res[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--)
        {
            while(!st.isEmpty() && arr[i] >= st.peek())
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
        int arr[] = {1,3,2,4};

        nextGreater(arr);
    }
}
