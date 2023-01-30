import java.util.*;
import java.io.*;
public class moocrypt{
   public static int N;
   public static char[][] puzzle;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("moocrypt.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocrypt.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int row=Integer.parseInt(s.nextToken()), col=Integer.parseInt(s.nextToken());
      puzzle=new char[row][col];
      HashSet<Character> hs=new HashSet<>();
      for(int i=0;i<row;i++){
         s=new StringTokenizer(br.readLine());
         String line=s.nextToken();
         for(int k=0;k<col;k++){
            puzzle[i][k]=line.charAt(k);
            hs.add(puzzle[i][k]);
         }    
      }
      
      int max=0;
      if(hs.size()>1&&row>=3&&col>=3){
         for(char M:hs){
            for(char O:hs){
               if(O==M)
                  continue;
               max=Math.max(max,findMoo(M,O));
            }
         }  
      }
      
      //System.out.println(max);
      pw.println(max);
      pw.close();
   }
    
   public static int findMoo(char M, char O){
      int count=0;
      for(int i=0;i<puzzle.length;i++){
         for(int k=0;k<puzzle[i].length;k++){
            if(puzzle[i][k]==M){
               //right
               if(k<=puzzle[i].length-3){
                  boolean isMoo=true;
                  for(int j=1;j<3;j++){
                     if(puzzle[i][k+j]!=O){
                        isMoo=false;
                     }
                  }
                  if(isMoo)count++;
               }
               //left
               if(k>=2){
                  boolean isMoo=true;
                  for(int j=1;j<3;j++){
                     if(puzzle[i][k-j]!=O){
                        isMoo=false;
                     }
                  }
                  if(isMoo)count++;
               }
               //down
               if(i<=puzzle.length-3){
                  boolean isMoo=true;
                  for(int j=1;j<3;j++){
                     if(puzzle[i+j][k]!=O){
                        isMoo=false;
                     }
                  }
                  if(isMoo)count++;
               }
               //up
               if(i>=2){
                  boolean isMoo=true;
                  for(int j=1;j<3;j++){
                     if(puzzle[i-j][k]!=O){
                        isMoo=false;
                     }
                  }
                  if(isMoo)count++;
               }
               //right down
               if(k<=puzzle[i].length-3&&i<=puzzle.length-3){
                  boolean isMoo=true;
                  for(int j=1;j<3;j++){
                     if(puzzle[i+j][k+j]!=O){
                        isMoo=false;
                     }
                  }
                  if(isMoo)count++;
               }
               //right up
               if(k<=puzzle[i].length-3&&i>=2){
                  boolean isMoo=true;
                  for(int j=1;j<3;j++){
                     if(puzzle[i-j][k+j]!=O){
                        isMoo=false;
                     }
                  }
                  if(isMoo)count++;
               }
               //left up
               if(k>=2&&i>=2){
                  boolean isMoo=true;
                  for(int j=1;j<3;j++){
                     if(puzzle[i-j][k-j]!=O){
                        isMoo=false;
                     }
                  }
                  if(isMoo)count++;
               }
               //left down
               if(k>=2&&i<=puzzle.length-3){
                  boolean isMoo=true;
                  for(int j=1;j<3;j++){
                     if(puzzle[i+j][k-j]!=O){
                        isMoo=false;
                     }
                  }
                  if(isMoo)count++;
               }
            }
         }
      }
      return count;
   }
}