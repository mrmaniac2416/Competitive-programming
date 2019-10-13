import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long a[] = new long[n + 1];
        for(int i=1;i<n+1;i++){
            a[i] = scan.nextLong();
        }

        while(true){
            int l = 1;
            int r = 2;
            int tl = 1;
            int tr = 2;
            int flag = 0;
            System.out.println("tl:" + " " + tl + " " + "tr:" + tr + " r: " + r  + " l:" + l +" "  + "flag:" + flag +" ");
            while(tl<n){
                if(a[tl]>a[tl+1]){
                    long temp = a[tl];
                    a[tl] = a[tl+1];
                    a[tl+1] = temp;
                    tl = tl + 2;
                    r = tr;
                    tr = tr + 2;
                    flag = 1;
                    System.out.println("tl:" + " " + tl + " " + "tr:" + tr + " r: " + r  + " l:" + l +" "  + "flag:" + flag +" ");
                }
                else if(flag == 1){
                    break;
                }
                else if(flag == 0){
                    tl = tl + 1;
                    l = tl;
                    tr = tr + 1;
                    r = tr;
                    System.out.println("tl:" + " " + tl + " " + "tr:" + tr + " r: " + r  + " l:" + l +" " + "flag: "+  flag + " " );
                }
            }
            if(flag ==1)
            {
                System.out.println(l + " " + r);
                System.out.println("tl:" + " " + tl + " " + "tr:" + tr + " r: " + r  + " l:" + l +" " + "flag: "+  flag + " " );

            }
            else
                break;
        }

    }

}