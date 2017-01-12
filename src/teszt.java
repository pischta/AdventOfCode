/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pt
 */
public class teszt {
  public static void main(String[] args) {
    boolean a=false;
    int b=0;
    for (int i = 1; (i < 10)&&(!a); i++) {
      if(i==5)
        a=true;
      b=i;
    }
    System.out.println("b:"+b);
  }
}
