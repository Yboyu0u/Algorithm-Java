package Base.generic;

public class GenericPrinter<T> {

    private T material;

    public T getMaterial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }

    public String toString(){
        return  material.toString();
    }

    public static void main(String[] args){
        Powder powder = new Powder();
        GenericPrinter<Powder> powderPrinter= new GenericPrinter<>();
        powderPrinter.setMaterial(powder);
        System.out.println(powderPrinter.toString());
    }

}
