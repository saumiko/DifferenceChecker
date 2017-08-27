/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textcomparison;

/**
 *
 * @author Dhruba
 */
public class TextComparison {

    /**
     * @param args the command line arguments
     */
    static boolean[] vis = new boolean[1000];
    static char[][] b = new char[1000][1000];
    static String mainDoc = "‘‘হ্যাঁ, মামা, ভাইস চ্যান্সেলর। তুমি এত রাগছো কেন! এ রকম একজন মানুষ কি ভাইস চ্যান্সেলর হতে পারে না?’’";
    static String ocrDoc = "'.হঁা, মামা, ভাইস চ্যান্সেলর । তুমি এত রাগছো কেন া. এ রকম একজন মানুষ কি ভাইস চ্যান্সেলর হতে পারে না .? ,";
    static int[][] c = new int[1000][1000];
    public static void main(String[] args) {
        // TODO code application logic here
        mainDoc= mainDoc.replaceAll(" ","");
        ocrDoc = ocrDoc.replaceAll(" ","");
       int i,j,k,m,n;
        for(i=1;i<=mainDoc.length() ; i++){
            for(j=1;j<=ocrDoc.length();j++){
                if(mainDoc.charAt(i-1)==ocrDoc.charAt(j-1)){
                    c[i][j]= c[i][j] +1;
                    b[i][j] = 'c';
                    vis[i-1] = true;
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j]='u';
                }
                else{
                    c[i][j]=c[i][j-1];
                    b[i][j]='l';
                }
            }
        }
        for(i=0;i<mainDoc.length();i++){
            if(!vis[i])
                System.out.println(mainDoc.charAt(i));
        }
        
    }    
}
