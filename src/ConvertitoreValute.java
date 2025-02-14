import java.util.Scanner;

public class ConvertitoreValute {
    //Attributi
    private final static double[] tassiCambio = {1, // EUR a EUR
                                                1.04, // EUR a USD
                                                0.83, // EUR a GBP
                                                159.66}; // EUR a JPY
    private int valPartenza;
    private int valDestinazione;
    private double importo;
    //

    //Getters e Setters
    public int getValPartenza() {
        return valPartenza;
    }
    public void setValPartenza(int valPartenza) {
        this.valPartenza = valPartenza;
    }

    public int getValDestinazione() {
        return valDestinazione;
    }
    public void setValDestinazione(int valDestinazione) {
        this.valDestinazione = valDestinazione;
    }

    public double getImporto() {
        return importo;
    }
    public void setImporto(double importo) {
        this.importo = importo;
    }
    //

    //Metodi
    public static double converti(int valPartenza, int valDestinazione, double importo){
        //Se la valuta di partenza e destinazione è la stessa restituisco l'importo inserito
        if(valPartenza == valDestinazione){
            return importo;
        }else{
            double tassoPartenza = tassiCambio[valPartenza - 1]; //Così richiamo l'indice corretto
            double tassoDestinazione = tassiCambio[valDestinazione - 1];
    
            //Converto l'importo in EURO usandolo come riferimento e poi calcolo il cambio effettivo
            double importoEuro = importo / tassoPartenza;
            double importoConvertito = importoEuro * tassoDestinazione;
            
            return importoConvertito;
        }
    }

    @Override
    public String toString() {
        return "ConvertitoreValute []";
    }
    //

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Scegli la valuta che desideri cambiare: 1 per EUR - 2 per USD - 3 per GBP - 4 per JPY");
        int valPartenza = scan.nextInt();
        System.out.println("Scegli ora in che valuta vuoi cambiarli: 1 per EUR - 2 per USD - 3 per GBP - 4 per JPY");
        int valDestinazione = scan.nextInt();
        System.out.println("Inserisci l'importo da cambiare: ");
        double importo = scan.nextDouble();

        double importoConvertito = ConvertitoreValute.converti(valPartenza, valDestinazione, importo);
        //System.out.println("Importo convertito: " + importoConvertito);

        //Converto il risultato in string e sostutuisco il separatore decimale dal . alla ,
        String risultatoConVirgola = String.format("%.2f", importoConvertito).replace('.', ',');
        //Stampa il risultato con la virgola
        System.out.println("Importo convertito è: " + risultatoConVirgola);
    }
}