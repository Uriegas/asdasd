public class Simbolo {
    private int j;
    private String sim;


    public Simbolo() {
        j = 0;
        sim = "";
    }

    public Simbolo(int j, String sim) {
        setsimbo(j, sim);
    }

    public int getjera(){
        return j;
    }

    public void setsimbo(int je, String simb) {
        j = je;
        sim = simb;

    }
    public String toString(){
        return sim;
    }
}
