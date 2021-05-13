import java.io.IOException;
public class Tokenz {
    //Atributos
    private int tipo;
    private Simbolo simbo = new Simbolo();
    private Valor valor = new Valor();


    /**
     * Saber el tipo que es, operador u operando
     * @return 
     */
    public int gettipo() {
        return this.tipo;
    }
    /** Construye un operador según el tipo ingresado
     * @param ca el "+,-,/,cos,tan,sin,*,/..."
     * @param tipo la
    */
    public Tokenz(int tipo, String ca) throws IOException{
        this.tipo = tipo;
        int jera = 0;
        if (this.tipo == 1){
            this.valor.setvalor(Double.parseDouble(ca));
        }
        else{
            jera = Jerarquia(ca);
            this.simbo.setsimbo(jera, ca);
        }
    }
    /** Regresará un número para representar la jerarquia de cada operación
     * Siendo así, del menor al mayor
     * @param Recibe el operando que se debe evaluar
     */
    public int Jerarquia(String simbo){
        System.out.println(simbo);
        if(simbo.equals("sin") || simbo.equals("cos")|| simbo.equals("tan")){
            return 4;
        }
        else if(simbo.equals("sqrt") || simbo.equals("^")){
            return 3;
        }
        else if(simbo.equals("/") || simbo.equals("*")){
            return 2;
        }
        else if(simbo.equals("+") || simbo.equals("-")){
            return 1;
        }
        else if(simbo.equals("(") || simbo.equals(")")){
            return 0;
        }    
        else if(!simbo.equals("sin") || !simbo.equals("cos") || !simbo.equals("tan") || !simbo.equals("sqrt") || !simbo.equals("^") || !simbo.equals("/") || !simbo.equals("*") || !simbo.equals("+") || !simbo.equals("-") || !simbo.equals("(") || !simbo.equals(")")){
            System.out.println("Error");
        }
        return -1;                            
    }
    public String toString(){
        if(this.tipo == 1){
            return this.valor.toString();
        }
        else{
            return this.simbo.toString();
        }
    }
    public int getjera() {
        return 0;
    }        
}