package Stack;

public class TwoStacksOneArray {

    int size = 10;
    int arr[] = new int[size];

    int i = -1;
    int j = size;

    void push1(int x)
    {
        if(i < j - 1)
        {
            i++;
            arr[i] = x;
        }
        else
            System.out.println("Overflow");
    }

    void push2(int x)
    {
        if(i < j - 1)
        {
            j--;
            arr[j] = x;
        }
        else
            System.out.println("Overflow");
    }

    int pop1()
    {
        if(i >= 0)
            return arr[i--];

        System.out.println("Underflow");
        return -1;
    }

    int pop2()
    {
        if(j < size)
            return arr[j++];

        System.out.println("Underflow");
        return -1;
    }

    public static void main(String[] args)
    {
        TwoStacksOneArray s = new TwoStacksOneArray();

        s.push1(5);
        s.push1(10);

        s.push2(100);
        s.push2(200);

        System.out.println(s.pop1());
        System.out.println(s.pop2());
    }
}