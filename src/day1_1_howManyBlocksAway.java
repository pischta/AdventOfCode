public class day1_1_howManyBlocksAway {
  public static void main(String[] args) {
   String lépésEredeti="L1, R3, R1, L5, L2, L5, R4, L2, R2, R2, L2, R1, L5, R3, L4, L1, L2, R3, R5, L2, R5, L1, R2, L5, R4, R2, R2, L1, L1, R1, L3, L1, R1, L3, R5, R3, R3, L4, R4, L2, L4, R1, R1, L193, R2, L1, R54, R1, L1, R71, L4, R3, R191, R3, R2, L4, R3, R2, L2, L4, L5, R4, R1, L2, L2, L3, L2, L1, R4, R1, R5, R3, L5, R3, R4, L2, R3, L1, L3, L3, L5, L1, L3, L3, L1, R3, L3, L2, R1, L3, L1, R5, R4, R3, R2, R3, L1, L2, R4, L3, R1, L1, L1, R5, R2, R4, R5, L1, L1, R1, L2, L4, R3, L1, L3, R5, R4, R3, R3, L2, R2, L1, R4, R2, L3, L4, L2, R2, R2, L4, R3, R5, L2, R2, R4, R5, L2, L3, L2, R5, L4, L2, R3, L5, R2, L1, R1, R3, R3, L5, L2, L2, R5";
   int i=0;
   String lépésIrány;
   String erreNéz="észak";
   int x=0,y=0;
   String lépésSzám;
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
        case  "észak": y+=Integer.parseInt(lépésSzám.trim());break;
        case    "dél": y-=Integer.parseInt(lépésSzám.trim());break;
        case  "kelet": x+=Integer.parseInt(lépésSzám.trim());break;
        case "nyugat": x-=Integer.parseInt(lépésSzám.trim());break;
      }
      //lépések.add(new day1_1_howManyBlocksAway(lépésIrány,Integer.parseInt(lépésSzám.trim())));
      i++;
    }while(i<lépésEredeti.length());
    System.out.println("x:"+x+", y:"+y);
  }
}
