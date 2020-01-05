import java.util.Random;
import java.util.Scanner;

public class Main extends Thread {
    public static int arreglo[];
	private static Scanner valor;
   
	//Crea un arreglo de largo n. RETORNA: randomNum
    public static int randomFill(int n){

        Random rand = new Random();
        int randomNum = rand.nextInt(n*10 +1) +1;
        return randomNum;
    }
    //Crea un arreglo de largo n. RETORNA: randomNum
    public static int[] crear_arreglo_desordenado( int n){
        int[] arreglo = new int[n];
        for(int i=0;i<n;i++)
        {
            arreglo[i] = randomFill(n);
        }
        return arreglo;


    }

//http://puntocomnoesunlenguaje.blogspot.com/2012/12/java-quicksort.html
    public static void quicksort(int A[], int izq, int der) {

        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la busqueda de izquierda a derecha
        int j=der; // j realiza la busqueda de derecha a izquierda
        int aux;

        while(i<j){            // mientras no se crucen las busquedas
            while(A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
            while(A[j]>pivote) j--;         // busca elemento menor que pivote
            if (i<j) {                      // si no se han cruzado
                aux= A[i];                  // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }
        A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1) {
        	Thread1 tIzq=new Thread1();
            tIzq.run(A, izq, j-1); // ordenamos subarray izquierdo
        }
        if(j+1 <der) {
        	Thread1 tDer=new Thread1();
            tDer.run(A, j+1, der); // ordenamos subarray derecho
        }
    }
    

    public static class Thread1 extends Thread{
    	public void run(int[] arreglo, int menor, int mayor) {
    		quicksort(arreglo, menor, mayor);
    	}

    }
    
    
    public static void main(String[] args) {
        //int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
   
        System.out.println ("Por favor introduzca el Largo del Arreglo:");
        valor = new Scanner(System.in);
        int largo = valor.nextInt();

		arreglo = crear_arreglo_desordenado(largo);
        Thread1 t1=new Thread1();
        System.out.println(java.util.Arrays.toString(arreglo));
        t1.run(arreglo, 0, largo-1);
        System.out.println(java.util.Arrays.toString(arreglo));
    }
}
