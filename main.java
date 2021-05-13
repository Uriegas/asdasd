import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
public class main{

    public static void main (String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String linea;
        boolean comprobar = false;
        List<Tokenz> res = new ArrayList<Tokenz>();
        Stack<Tokenz> post;
        Tree tree;
        Nodo raiz;
        do{
        System.out.println("Introduzca: ");
        linea = sc.nextLine();
        if (linea.equals("!exit")){
            comprobar = true;
            break;
        }
        //Separar
        Separador Operacion = new Separador();
        res = Operacion.Conversion(linea);
        //System.out.println(res);

        //Convertir a postfija
        Postfix postfix = new Postfix();
        post = postfix.ConversionPost(res);
        System.out.println(post);
        //tree
        tree = new Tree();
        raiz = tree.Postfix(post);
        }while(comprobar == false);
    }
    
}
        /*
        Scanner sc = new Scanner(System.in);
        String linea;
        boolean comprobar = false;
        do{
         System.out.println("Introduzca: ");
         linea = sc.nextLine();
         if (linea.equals("!exit")){
            comprobar = true;
         }
         else{
                 Conversion operacion = new Conversion();
                operacion.prefijo(linea);

                String resultado = Conversion.prefijo(linea).toString();
                System.out.println(linea);
                System.out.println(resultado);
                //System.out.println(CalculadoraB.respuesta(resultado));
         }
        }while(comprobar == false);
        */