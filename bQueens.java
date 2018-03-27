class bQueens{
  private static int N = 8;
  private static int counter = 0;
  public static void main(String[] args){
    N= Integer.parseInt(args[0]);
    int[] Board = new int[N];
    addQueens(Board,0);
    System.out.println(counter);
  }
  static void addQueens(int[] b, int n){
    if (n>= N) {
      //for (int x :b) System.out.print(x+", ");
      //System.out.println();
      counter++;
    } else{
      for ( int i = 0; i<N; i++){
        if (isPlaceOK(b, n, i)){
          b[n] = i;
          addQueens(b,n+1);
        }
      }
    }
  }
  static boolean isPlaceOK(int[] b, int n, int p){
    for (int i = 0; i < n; i++){
      if (b[i]==p||b[i]-i==p-n||b[i]+i==p+n) return false;
    }
    return true;
  }
}
// add dummy comments
