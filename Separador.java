import java.io.StreamTokenizer;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
/**
 * Se encargará de separar
 */
public class Separador {

    String linea;
    private Double ev;

    /**
     * Su entrada es un String en infija que regresará una lista de string 
     * "1 + 3 - 5" lo que hará es separarlo -> "1, +, 3, -, 5"
     * @return la lista de la operación.
     * @throws IOException Excepción de entrada y de salida
     */
    public List<Tokenz> Conversion(String s) throws IOException 
    {
        List<Tokenz> Toseparado = new ArrayList<Tokenz>();
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(QuitarEspacio(s.replace(" ","").toLowerCase())));
        //System.out.println(tokenizer);
        tokenizer.ordinaryChar('/');
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
          switch(tokenizer.ttype) {
            case StreamTokenizer.TT_NUMBER:
              Toseparado.add(new Tokenz(1,String.valueOf((int)tokenizer.nval)));
              break;
            case StreamTokenizer.TT_WORD:
              Toseparado.add(new Tokenz(2,String.valueOf(tokenizer.sval)));
              break;
            default: 
              Toseparado.add(new Tokenz(2,String.valueOf((char)tokenizer.ttype)));
          }
        }
        return Toseparado; 

      }
      /**Aquí se mandará la operación para poder quitar espacio, además de buscar si existe una "x" en el programa 
       * @param Operacion (s)
       * @return La operación ya sustituida (12x + 2 ->x=1  12*1 +2)
      */
      public String QuitarEspacio(String s) {
        String linea;
        Double num1;
        Scanner sc = new Scanner(System.in);
        linea = s.replace("[", "(");
        linea = s.replace("] ", ")");
        linea = s.replace(" ", "");
        if(linea.contains("x")){
          if(this.ev == null){
            System.out.println("Valor de x: " + linea);
            num1 = sc.nextDouble();
            sc.nextLine();
            this.setnum(num1);
          }
          linea = s.replaceAll("(\\d+)x", "$1*" + String.valueOf(getnum()));
          linea = s.replace("x", String.valueOf(this.getnum()));
        }

        return linea;
      }
      /**
       * Se asigna el valor que tendrá la x 
       * @param Valor de la incógnita
       */
      public void setnum(double num){
        this.ev = num;
      }

      /**
       * @return Regresa el valor asignado
       */
      public Double getnum(){
        return this.ev;
      }
      
}
