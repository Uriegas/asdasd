import java.util.Stack;
/**Recibe como parametro la notación en postfix
 * [10,2,+]
 * @param postfix
 * @re
 */
public class Tree{
private Nodo Nodex;

    public Nodo Postfix(Stack<Tokenz> post){
        Stack<Nodo> tree;
        tree = new Stack<>();
        for (Tokenz tokenzito : post){
            this.plantar(tokenzito, tree);
        }
        return tree.pop();

    }
    public void plantar(Tokenz tokenzito,Stack<Nodo> pilita){
        this.Nodex = new Nodo(tokenzito);
        if (tokenzito.gettipo() == 1){
            pilita.add(new Nodo(tokenzito));
        }
        switch(tokenzito.toString()){
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                this.Nodex.setRight(pilita.pop());
                try{this.Nodex.setLeft(pilita.pop());}
                catch(Exception e){this.Nodex.setLeft(null);}
                pilita.push(Nodex);
                break;
            case "sqrt":
            case "sin":
            case "cos":
            case "tan":
                this.Nodex = new Nodo(tokenzito);
                this.Nodex.setRight(pilita.pop());
                pilita.push(Nodex);
                break;
        }
    }
    public double opemath(Nodo raiz){
        if (raiz == null){
            return 0.0;
        }
        else if
            (raiz.GoLeft() == null && raiz.GoRight() == null){
                return Double.parseDouble(raiz.gettokenzote().toString());
        }
        double parteIzquierda = opemath(raiz.getLeft());
        double parteDerecha = opemath(raiz.getRight());
        switch(raiz.gettokenzote().toString()){
            case"sin":
            return Math.sin(parteDerecha);
            case"cos":
            return Math.cos(parteDerecha);
            case"tan":
            return Math.sin(parteDerecha);
            case"sqrt":
            return Math.cos(parteDerecha);
            case"+":
            return parteIzquierda+parteDerecha;
            case"-":
            return parteIzquierda-parteDerecha;
            case"*":
            return parteIzquierda*parteDerecha;
            case"^":
            return Math.pow(parteIzquierda,parteDerecha);
            default:
            return Math.pow(parteIzquierda,parteDerecha);
        }
    }

}
