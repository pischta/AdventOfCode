
import java.util.Arrays;

public class súlyozottRendezésPróba {
  public static void main(String[] args) {
    int[][] tömb=new int[][]{{1,3},
      {2,3},
      {3,4},
      {4,5},
      {5,4},
      {6,4}};
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(tömb[i][j]+" ");
      }
      System.out.println("");
    }
    Arrays.sort(tömb, new java.util.Comparator<int[]>(){
      public int compare(int a[],int b[]){
        return Integer.compare(b[1], a[1]);
      }
    });
    System.out.println("Rendezés után:");
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(tömb[i][j]+" ");
      }
      System.out.println("");
    }
  }
}
