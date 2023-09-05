import java.util.ArrayList;
import java.util.Scanner;

public class Carro
{
    static Scanner scanner = new Scanner(System.in);
    private String modelo;
    private ArrayList<Multa> multas = new ArrayList<>();
    private String placa;

    public Carro(String placa , String modelo)
    {
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getPlaca()
    {
        return placa;
    }

    public String getModelo()
    {
        return  modelo;
    }

     public ArrayList<Multa> getMultas()
     {
         return new ArrayList<Multa>(multas);
     }


    public void registrarMultas(ArrayList<Carro> garagem)
    {
        Multa pontosCarteira = new Multa();
        pontosCarteira.valor=0.0f;
        System.out.printf("Qual a infração do carro %s: ", this.modelo);
        pontosCarteira.infracao = scanner.nextLine();
        multas.add(pontosCarteira);

        System.out.print("Qual o valor da multa: ");
        pontosCarteira.valor = scanner.nextFloat();
        scanner.nextLine();

        multas.add(pontosCarteira);

    }
}


