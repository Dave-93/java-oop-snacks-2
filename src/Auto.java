public class Auto {
    //Attributi
    private final int numeroTelaio;
    
    private static int contatoreAuto = 0;
    
    private final String modello;
    //

    //Costruttore
    public Auto(String modello){
        this.numeroTelaio = ++contatoreAuto;//Assegna un numero di telaio univoco e incrementa il contatore
        this.modello = modello;
    }
    //

    //Getters
    public int getNumeroTelaio() {
        return numeroTelaio;
    }

    public static int getContatoreAuto() {
        return contatoreAuto;
    }

    public String getModello() {
        return modello;
    }  
    //

    @Override 
    public String toString() {
        return "Auto modello " + getModello() + ", con telaio " + getNumeroTelaio();
    }

    public static void main(String[] args) {
        Auto a1 = new Auto("Punto");
        Auto a2 = new Auto("Giulia");
        Auto a3 = new Auto("Defender");
        Auto a4 = new Auto("Renegade");
        Auto a5 = new Auto("Panda");
        Auto a6 = new Auto("Zafira");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);

        System.out.println("Il numero di auto create è " + getContatoreAuto());
    }
}