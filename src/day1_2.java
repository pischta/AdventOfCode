
public class day1_2 {

  public static void main(String[] args) {
   String lépésEredeti="L1, R3, R1, L5, L2, L5, R4, L2, R2, R2, L2, R1, L5, R3, L4, L1, L2, R3, R5, L2, R5, L1, R2, L5, R4, R2, R2, L1, L1, R1, L3, L1, R1, L3, R5, R3, R3, L4, R4, L2, L4, R1, R1, L193, R2, L1, R54, R1, L1, R71, L4, R3, R191, R3, R2, L4, R3, R2, L2, L4, L5, R4, R1, L2, L2, L3, L2, L1, R4, R1, R5, R3, L5, R3, R4, L2, R3, L1, L3, L3, L5, L1, L3, L3, L1, R3, L3, L2, R1, L3, L1, R5, R4, R3, R2, R3, L1, L2, R4, L3, R1, L1, L1, R5, R2, R4, R5, L1, L1, R1, L2, L4, R3, L1, L3, R5, R4, R3, R3, L2, R2, L1, R4, R2, L3, L4, L2, R2, R2, L4, R3, R5, L2, R2, R4, R5, L2, L3, L2, R5, L4, L2, R3, L5, R2, L1, R1, R3, R3, L5, L2, L2, R5";
   //String lépésEredeti="R20, R5, R5, R10, L2, L15";
    byte térkép[][]=new byte [500][500];
    for (int i = 0; i < 500; i++) {
      for (int j = 0; j < 500; j++) {
        térkép[i][j]=0;
      }
    }
   int i=0;
   String lépésIrány;
   String erreNéz="észak";
   int x=250,y=250;//Elindulok a térkép közepéről
   String lépésSzám;
   int következőPont;
   boolean jártMárItt=false;

   do{
      if(lépésEredeti.substring(i, i+1).contentEquals(" "))
        i++;
      lépésIrány=lépésEredeti.substring(i, i+1);//az első karakter az irány
      lépésSzám="";
      //System.out.println("lépésszám nullázás után:"+lépésSzám);
      i++;
      while((i<lépésEredeti.length())&&(! lépésEredeti.substring(i, i+1).contentEquals(","))){
        lépésSzám+=lépésEredeti.substring(i, i+1);
        //System.out.println("i: "+i+","+lépésEredeti.substring(i, i+1));
        i++;
      }
      System.out.println("lépés:"+lépésIrány+lépésSzám.trim()+":");
      if(lépésIrány.equals("R")){
        switch(erreNéz){
          case  "észak": erreNéz="kelet";
                         break;
          case    "dél": erreNéz="nyugat";
                         break;
          case  "kelet": erreNéz="dél";
                         break;
          case "nyugat": erreNéz="észak";
                         break;
        }
      }else{
        switch(erreNéz){
          case  "észak": erreNéz="nyugat";
                         break;
          case    "dél": erreNéz="kelet";
                         break;
          case  "kelet": erreNéz="észak";
                         break;
          case "nyugat": erreNéz="dél";
                         break;
        }
      }
      switch(erreNéz){
        case  "észak": 
          következőPont =y+Integer.parseInt(lépésSzám.trim());
          for (int j = y+1; ((j <= következőPont)&&(!jártMárItt)); j++) {
            y=j;
            System.out.println("x,y: "+x+","+y);
            if(térkép[y][x]==1){
              jártMárItt=true;
              
            }
            térkép[y][x]++;
          }
          
                       //y+=Integer.parseInt(lépésSzám.trim());
          break;
        case    "dél": 
          következőPont=y-Integer.parseInt(lépésSzám.trim());
          for (int j = y-1; ((j >= következőPont)&&(!jártMárItt)); j--) {
            y=j;
            System.out.println("x,y: "+x+","+y);
            if(térkép[y][x]==1){
              jártMárItt=true;
              
            }
            térkép[y][x]++;
          }
          //y-=Integer.parseInt(lépésSzám.trim());
          break;
        case  "kelet": 
          //System.out.println("Lépésszám: "+lépésSzám);
          következőPont=x+Integer.parseInt(lépésSzám.trim());
          for (int j = x+1; ((j <= következőPont)&&(!jártMárItt)); j++) {
            x=j;
            System.out.println("x,y: "+x+","+y);
            if(térkép[y][x]==1){
              jártMárItt=true;
              
            }
            térkép[y][x]++;
          }
          //x+=Integer.parseInt(lépésSzám.trim());
          break;
        case "nyugat": 
            következőPont=x-Integer.parseInt(lépésSzám.trim());
            for (int j = x-1; ((j >= következőPont)&&(!jártMárItt)); j--) {
            x=j;
            System.out.println("x,y: "+x+","+y);
            if(térkép[y][x]==1){
              jártMárItt=true;
              
            }
            térkép[y][x]++;
          }
          //x-=Integer.parseInt(lépésSzám.trim());
            break;
      }
      //lépések.add(new day1_1_howManyBlocksAway(lépésIrány,Integer.parseInt(lépésSzám.trim())));
      i++;
    }while((i<lépésEredeti.length())&&(!jártMárItt));
    System.out.println("Itt jártam már: x:"+(x-250)+", y:"+(y-250));
    System.out.println("Ez "+(Math.abs(x-250)+Math.abs(y-250))+" távolságra van.");
  }
}
