class Queens{
  static boolean isSolution(int[] A){
    for (int i = 0; i < A.length; i++){
      for (int j = i + 1; j < A.length; j++){
        if (Math.abs(A[i] - A[j]) == j - i) return false;
      }
    }
    return true;
  }
  static void nextPermutation(int[] A){
    int pivot = -1, suc= -1;
    for (int i = A.length-2; i >= 0;i--){
      if (A[i]<A[i+1]){
        pivot = i;
        break;
      }
    }
    if (pivot == -1){
      reverse(A,0);
    }
    else{
        for (int i = A.length-1; i >= 0;i--){
          if (A[i]>A[pivot]){
            suc = i;
            break;
          }
        }

    swap(A,pivot,suc);
    reverse(A,pivot+1);
    }
  }
  static void printArray(int[] P){
      System.out.print("(");
      for(int i=0; i<P.length-1; i++){
         System.out.print(P[i]+", ");
      }
      System.out.println(P[P.length-1]+")");
   }

  static void swap(int[] Q, int i, int j){
      int temp = Q[i];
      Q[i] = Q[j];
      Q[j] = temp;
  }
  static void reverse(int[] T, int i){
      int j=T.length-01;
      while(i<j){
         swap(T, i, j);
         i++;
         j--;
      }
   }
   static int fact(int i){
     if (i == 1) return 1;
     return fact(i-1)*i;
   }
   static void error(){
     System.out.println("Usage: Queens [-v] number");
     System.out.println("Option: -v verbose output, print all solutions");
     System.exit(0);
   }
   public static void main(String[] args){
    boolean verbose = false;
    int input = -1, n = args.length;
    if (n == 1){
      try{
          input=Integer.parseInt(args[0]);
      }catch (NumberFormatException e1){
        error();
      }
    }else if (n==2){
      try{
        if (args[0].equals("-v")){
          verbose = true;
          input=Integer.parseInt(args[1]);
        }
        else error();
      }catch (NumberFormatException e2) {error();}
    }else error();
/*    try{
        input=Integer.parseInt(args[0]);
    }catch(NumberFormatException e1){
        try{
          if (args[0].equals("-v")){
            verbose = true;
            input=Integer.parseInt(args[1]);
          }
          else{
            System.out.println("Usage: Queens [-v] number");
            System.out.println("Option: -v verbose output, print all solutions");
            System.exit(0);
          }
        }catch(NumberFormatException e2){
          System.out.println("Usage: Queens [-v] number");
          System.out.println("Option: -v verbose output, print all solutions");
          System.exit(0);
        }
    }
*/
     int[] ans = new int[input];
     int count = 0;
     for(int i=0; i<input; i++){
       ans[i] = i+1;
     }
     for (int i = 0; i <fact(input);i++){
       if(isSolution(ans)){
         count++;
         if (verbose) printArray(ans);
       }
       nextPermutation(ans);
     }
     System.out.println(input+"-Queens has "+count+" solutions");

   }
}
