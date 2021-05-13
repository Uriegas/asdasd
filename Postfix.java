import java.util.Stack;
import java.util.List;

/**
 * Convierte de infija a Postfija
 * Por ejemplo: [1.0, "+", 2.0] -> [1.0, 2.0,"+"]
 * @param  La lista de tokens infija
 * @return Retorna una lista de manera postfija
 * 
 */

public class Postfix{

    public Stack<Tokenz> ConversionPost(List<Tokenz> infija) {
        Stack<Tokenz> tokensa = new Stack<Tokenz>();
        Stack<Tokenz> Auxilito = new Stack<Tokenz>();

        for(int i = 0; i < infija.size(); i++){
            if(infija.get(i).gettipo() == 1){
                tokensa.add(infija.get(i));
            }

            if(infija.get(i).toString().equals("!")){
                tokensa.add(infija.get(i));
               
            }
            else if(infija.get(i).toString().equals("sin") || infija.get(i).toString().equals("tan") || infija.get(i).toString().equals("cos") || infija.get(i).toString().equals("sqrt")){
                Auxilito.add(infija.get(i));

            }
            else if(infija.get(i).toString().equals("+") || infija.get(i).toString().equals("-") || infija.get(i).toString().equals("*") || infija.get(i).toString().equals("/")){
                if(!Auxilito.isEmpty()){
                    do{
                        tokensa.add(Auxilito.pop());
                        if (Auxilito.isEmpty()){

                        }
                    }while(Auxilito.peek().getjera() >= infija.get(i).getjera());    
                tokensa.add(Auxilito.pop());

                }
                tokensa.add(infija.get(i));

            }
            else if(infija.get(i).toString().equals("^") ){
                if (!Auxilito.isEmpty()){
                    while(Auxilito.peek().getjera() >infija.get(i).getjera()){
                        tokensa.add(Auxilito.pop());
                        if(Auxilito.isEmpty()){
 
                        }
                    }
                }
                Auxilito.add(infija.get(i));
            }
            else if(infija.get(i).toString().equals("(")){
                Auxilito.add(infija.get(i));

            }
            else if(infija.get(i).toString().equals(")")){
                while(!Auxilito.peek().toString().equals("(")){
                    Auxilito.pop();
                    if(!Auxilito.isEmpty() && (Auxilito.peek().toString().equals("sin") || Auxilito.peek().toString().equals("cos") || Auxilito.peek().toString().equals("tan") || Auxilito.peek().toString().equals("sqrt"))){
                        tokensa.add(Auxilito.pop());
 
                     }
                }
            }              
        }
        while(!Auxilito.isEmpty())
            tokensa.add(Auxilito.pop());    
        return tokensa;
        
    }
}

