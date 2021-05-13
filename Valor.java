public class Valor {
    private double va;


    public Valor(){
        setvalor(0.0);
    }

    public void setvalor(double va) {
        this.va = va;
    }

    public Valor(double va){
        setvalor(va);
    }
    public double getvalor(){
        return this.va;
    }

    public String toString(){
        return String.valueOf(this.va);
    }

}
