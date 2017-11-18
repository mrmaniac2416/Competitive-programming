import java.util.*;
class fasterthanflash{
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        s.nextLine();
        while(t--!=0){
            String str=s.nextLine();
            if(str.length()==1){
                System.out.println("-1");
                continue;
            }
            else{
                System.out.println("length greater than 1");
                int ans=0;int cnt=0;
                if(str.charAt(1)!=str.charAt(0)){
                    ans=2;
                    System.out.println("1st character " + str.charAt(0)  + "not equal to 2nd " + str.charAt(1) + " and ans=" + ans);
                }
                else{
                    ans=1;
                    System.out.println("1st character " + str.charAt(0)  + "equal to 2nd " + str.charAt(1) + "and ans=" + ans);
                }
                cnt=Math.max(cnt,ans);
                System.out.println("count = " + cnt);
                for(int i=2;i<str.length();i++){
                    if(ans>1 ){
                        System.out.println("answer greater than 1");
                        if((str.charAt(i)!=str.charAt(i-1)) && (str.charAt(i)!=str.charAt(i-2))){
                            System.out.println( i+ "th charcter " + str.charAt(i)  + " is not equal to the previous two charcters");
                            ans++;
                            System.out.println("ans =" + ans);
                        }
                        else{
                            System.out.println(i+ "th charcter " + str.charAt(i)  + " is equal to either of  the previous two charcters");
                            if((str.charAt(i)!=str.charAt(i-1)) && (str.charAt(i)==str.charAt(i-2)))
                            {
                                System.out.println(i+ "th charcter " + str.charAt(i)  + " is not equal to " + (i-1) + "th" + " and equal to " + (i-2) + "th character");
                                ans=2;
                                System.out.println("ans =" + ans);
                            }

                            else
                            {
                                System.out.println(i+ "th charcter " + str.charAt(i)  + " is equal to " + (i-1) + "th" + " and not equal to " + (i-2) + "th character");
                                ans=1;
                                System.out.println("ans =" + ans);
                            }
                        }
                    }
                    else{
                        System.out.println("ans is less than or equal to  1 ans=" + ans );
                        if(str.charAt(i)!=str.charAt(i-1)){
                            System.out.println( i + "th character " + str.charAt(i) + " is not equal to " + (i-1) + "th character");
                            ans++;
                            System.out.println("ans =" + ans);
                        }
                    }
                    System.out.println(" cnt =" + cnt + " ans= " +  ans);
                    cnt=Math.max(cnt,ans);
                    System.out.println(" cnt = " + cnt);

                }
                if(cnt==1)
                    System.out.println("-1");
                else
                    System.out.println(cnt);
            }
        }
    }
}