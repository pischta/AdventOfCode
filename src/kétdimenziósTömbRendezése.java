
import java.util.Arrays;

public class kétdimenziósTömbRendezése {
  public static void main(String[] args) {
    int[][] tömb=new int[5][2];
    int[][] tömb2=new int[5][2];
    int k=0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 2; j++) {
        tömb[i][j]=25-k++ + j*2*k;
        System.out.print(tömb[i][j]+" ");
      }
      System.out.println("");
    }
/*    Arrays.sort(tömb, new java.util.Comparator<int[]>(){
      public int compare(int a[],int b[]){
        return Integer.compare(a[0], b[0]);
      }
    });*/
    Arrays.sort(tömb, (int a[], int b[]) -> Integer.compare(a[0], b[0]));
    System.out.println("");
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(tömb[i][j]+" ");
      }
      System.out.println("");
    }
    System.out.println("");
    tömb2=Arrays.copyOfRange(tömb, 1, 5);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(tömb2[i][j]+" ");
      }
      System.out.println("");
    }
    
  }
}
