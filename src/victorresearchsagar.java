/*



public static void Solve() {
        int n = in.nextInt();
        long s = in.nextLong();
        long a[] = new long[n+1];
        long pre[] = new long[n+1];
        for(int i=1;i<=n;i++){
        a[i] = in.nextLong();
        pre[i] = pre[i-1] + a[i];
        }
        HashMap<Long,Long> h = new HashMap<>();
        h.put(0L,1L);
        long answer = 0;
        for(int i=1;i<=n;i++){
        long temp = pre[i] - s;
        if(h.containsKey(temp)){
        answer+=h.get(temp);
        }
        if(!h.containsKey(pre[i])){
        h.put(pre[i], 1L);
        }else{
        h.put(pre[i],h.get(pre[i])+1);
        }
        }
        o.println(answer);
        }
        public static void main(String args[]){
                Solve();
                }



*/
