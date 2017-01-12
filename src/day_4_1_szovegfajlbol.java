
//import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day_4_1_szovegfajlbol {
  
  public static int[][] súlyozottRendezés(int[][] tömb, int dimenzió,String irány){
    if(irány.equals("csökkenő"))
      Arrays.sort(tömb, (int a[], int b[]) -> Integer.compare(b[dimenzió], a[dimenzió]));
    else
      Arrays.sort(tömb, (int a[], int b[]) -> Integer.compare(a[dimenzió], b[dimenzió]));
    return tömb;
  }

  public static int[] egyChksumMeghatározása(int aktGyakoriságNdx, int[][] előfordulások){
    int[] vissza=new int[2];
    return vissza;
  }

  public static String számoltChecksumToString(int[] számoltCheckSum){
    String sztringVissza="";
    for (int i = 0; i < számoltCheckSum.length; i++) {
      sztringVissza=sztringVissza.concat(Character.toString((char)(számoltCheckSum[i])));
    }
    return sztringVissza;
  }
  
  public static void main(String[] args) throws IOException {
    /*String kódok="aaaaa-bbb-z-y-x-123[abxyz]"+
            "a-b-c-d-e-f-g-h-987[abcde]"+
            "not-a-real-room-404[oarel]"+
            "totally-real-room-200[decoy]";*/
    String kódok;
    final Charset ENCODING = StandardCharsets.UTF_8;
    //hosszúSztingPróba text = new hosszúSztingPróba();
    Path path = Paths.get("/home/pt/NetBeansProjects/day_4_1_kodok.txt");
    List<String> lines = Files.readAllLines(path, ENCODING);


    int idSum=0;
    String egySor;
    int id;
    String checksum;
    String roomCode;
    int[][] előfordulások=new int[123][2];//97-122-ig hasznalom: char  a-z. A 45-ot is, az a '-'
    int aktGyakoriságNdx;
    int[] számoltChecksum=new int[5];
    int egyformákElső;
    int egyformákUtolsó;
    int i=0;
    try (Scanner scanner =  new Scanner(path, ENCODING.name())){
      while (scanner.hasNextLine()){
        //egy sor kinyerése
        egySor=String.valueOf(scanner.nextLine());
        i++;
        for (int j = 0; j < 123; j++) {
          //itt a 0-ás indexű oszlop a saját sorának számát kapja meg, ami a karakterkód.
          //Ez azért kell, mert a rendezésnél már a sorszám és a karakterkód nem fog megegyezni
          //mivel ezt a tombot rendezem később, ezért minden egyes sor feldolgozásánál inicializálni kell
          előfordulások[j][0]=j;
          előfordulások[j][1]=0;//ki kell nulláznom ezt is
        }
        //részSztingek meghatározása
        roomCode=egySor.split("\\d+\\[.+\\]")[0];
        id=Integer.decode(egySor.substring(egySor.lastIndexOf("-")+1,egySor.lastIndexOf("[")));
        checksum=egySor.substring(egySor.lastIndexOf("[")+1, egySor.lastIndexOf("]"));
        for (int j = 0; j < 5; j++) {//kinullázom a számoltChecksum tömböt
          számoltChecksum[j]=0;
        }
        for (int j = 0; j < roomCode.length(); j++) {//megszámolom, melyik karakter hányszor fordul elő
          előfordulások[roomCode.charAt(j)][1]++;
        }
        előfordulások[45][1]=0;//ennek (a '-'-nak) a gyakorisága nem érdekel, sőt, bekavarna
        //Az előfordulások kiválogatása:
        //lerendezem a tömböt előfordulások gyakorisága szerint. Csökkenőbe kell!!
        előfordulások=súlyozottRendezés(előfordulások, 1,"csökkenő");
        aktGyakoriságNdx=0;//most ez a leggyakoribb elem, mert csökkenőbe rendeztem
        int checksumNdx=0;
        do{
          //megnézem, hogy több egyforma gyakoriságú van-e
          egyformákElső=aktGyakoriságNdx;
          egyformákUtolsó=aktGyakoriságNdx;
          while((aktGyakoriságNdx<előfordulások.length-1)&&(előfordulások[aktGyakoriságNdx][1]==előfordulások[aktGyakoriságNdx+1][1])){
            egyformákUtolsó=++aktGyakoriságNdx;
          }
          System.out.println("egyformákElső:"+egyformákElső+"egyformákUtolsó:"+egyformákUtolsó);
          if (egyformákElső!=egyformákUtolsó) {
            //ha az egyformákElső és az egyformákUtolsó nem egyezik, akkor több egyforma is van, melyeket le kell rendezni
            int[][] részTömb= Arrays.copyOfRange(előfordulások, egyformákElső, egyformákUtolsó+1);
            részTömb= súlyozottRendezés(részTömb, 0,"növekvő");
            //a résztömbből annyi elemet használok fel max, amennyi még kell a checksumba
            int ndx=0;
            while(checksumNdx<5 && ndx<részTömb.length){
              számoltChecksum[checksumNdx++]=részTömb[ndx++][0];
            }
            aktGyakoriságNdx++;
          }else
            számoltChecksum[checksumNdx++]=előfordulások[aktGyakoriságNdx++][0];
        }while(checksumNdx<5);

        if((számoltChecksumToString(számoltChecksum)).equals(checksum))
          idSum+=id;
        //Ha több egyforma előfordulási gyakoriság van, ezeket külön le kell rendezni:
          //Mivel erre van rendezve, addig lépkedek, amíg ugyanolyan gyakoriságot találok
          //legrosszabb eset legyen: 60 teljesen különböző karakter, azaz mindegyiknek egy a gyakorisága
          //Ehhez kell egy 60x2-es tömb, amibe töltöm ezeket a karaktereket, és előfordulásait
          //Ezt a tömböt lerendezem növekvőbe
          //Attól függően, mennyi karakter kell még a checksumhoz, az első n-t beleteszem az általam generált checksumba
        //Ha kell még a checksumba karakter, akkor folytatom a következő legggyakoribb karakterrel
      }
      System.out.println("Helyes kódok id-inek összege:"+idSum);
      System.out.println("sorok száma:"+i);
    }
  }
}
