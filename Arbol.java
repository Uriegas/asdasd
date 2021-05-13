public class Arbol {

    Nodo raiz;
    public Arbol() {
        raiz = null;
    }

    public void insertar( int i, Object fruta) {
        Nodo n = new Nodo(i);
        n.contenido = fruta;
        if ( raiz==null ) {
            raiz = n;
        }else {
            Nodo aux = raiz;
            while( aux != null ) {
                n.Padre = aux;
                if ( n.llave >= aux.llave) {
                    aux = aux.derecha;
                }else {
                    aux = aux.izquierda;
                }
            }

            if( n.llave < n.Padre.llave ) {
                n.Padre.izquierda = n;
            }else {
                n.Padre.derecha = n;
            }

        }
    }

    public void recorrer( Nodo n ) {
        if ( n != null ) {
            recorrer(n.izquierda);
            System.out.println("indice " +  n.llave + " fruta " + n.contenido);
            recorrer(n.derecha);
        }
    }

    private class Nodo {
        public Nodo Padre;
        public Nodo derecha;
        public Nodo izquierda;
        public int llave;
        public Object contenido;

        public Nodo (int indice) {
            llave = indice;
            derecha = null;
            izquierda = null;
            Padre=null;
            contenido=null;
        }
    }

}
