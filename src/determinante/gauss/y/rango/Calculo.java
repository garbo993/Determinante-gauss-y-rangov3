
package determinante.gauss.y.rango;

import java.util.ArrayList;
import javax.swing.JTextField;

public class Calculo {
    int c=0 ;
    double matriz[][];
    int signo = 1;

    public double[][] Calcular(int tamaño, ArrayList<JTextField> array) {
       Generarmatriz(tamaño, array);
       while(!verficarcero() ){
           hacerceros();
       }
       return matriz;
    }

  

    private void Generarmatriz(int tamaño, ArrayList<JTextField> array) {
       matriz = new double[tamaño][tamaño];
       int index=0;
       c=c+2;
       for(int i=0;i<tamaño;i++){
           c=c+2;
           for(int j=0;j<tamaño;j++){
               matriz[i][j]= Integer.parseInt(array.get(index).getText());
               index++;
              c=c+2;
           }
       }
    }

    private boolean verficarcero(){
        
        boolean valor = false;
       // c=c+3;
        for(int i=0;i<matriz.length;i++){
         //   c=c+5;
          for(int j=i+1; j<matriz.length;j++){
           //   c=c+5;
              if (matriz[j][i] ==0){
                  valor = true;
             //     c=c+1;
              }
              else{
               //   c=c+1;// revisar booleano 
                  return false;
              }
          }
        }
        return valor;
    }

   
    private void hacerceros() {
        //c=c+3;
        for(int i=0;i<matriz.length-1;i++){
           // c=c+6;
            //matriz[i] = hacerpivote(matriz[i],i);
            for(int j=i+1;j<matriz.length;j++){
                matriz[j] = restarnumero(matriz[j],matriz[i],i);
           //     c=c+6;
            }
        }
        
    }

  
    private double[] restarnumero(double[] arreglo, double[] restar,int pos) {
        double factor = (arreglo[pos]*-1)/restar[pos];
        c=c+8;//*
        for(int i=0;i<arreglo.length;i++){
            arreglo[i] += (factor*restar[i]);
            c=c+7;
        }
        return arreglo;
    }

    public double Determinante() {
        double det=1;
        c=c+3;
        for(int i=0;i<matriz.length;i++){
            det *= matriz[i][i];
            c=c+6;
        }
        return det;
    }
 
    public int  contador(){
        return c;
    }
    
    public int formula(int tamaño, ArrayList<JTextField> array ){
        int n = tamaño ;
        int form = 21*n^2-31*n+((32*(n)^3-159*(n)^2+223*n-96) / 6)+10 ;
        
        return form;
    }
}
/*  private void imprimirmatriz() {
        c=c+2;
        for(int i=0;i<matriz.length;i++){
            c=c+4;
           for(int j=0;j<matriz.length;j++){
               System.out.print(matriz[i][j]+" ");
               c=c+2;
           }
            System.out.println("");
       }
    }*/
 /*private boolean Verificardiagonal() { 
        for(int i=0;i<matriz.length;i++){
            if(matriz[i][i]==0){
                for(int j=0;j<matriz.length;j++){
                    int temp = matriz [i][j];
                }
            }
        }
    }*/
 /* private double[] hacerpivote(double[] arreglo,int pos) {
        
        double div = arreglo[pos];
        c=c+4;
        for(int i=0;i<arreglo.length;i++){
            arreglo[i] /= div;
           c=c+5;
        }
        return arreglo;
    }
*/