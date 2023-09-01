import java.util.ArrayList;
import java.util.Scanner;

public class Proprietario
{
    String nome;
    ArrayList<Carro> meusCarros = new ArrayList<Carro>();
    String CNH;

    public Proprietario(String nome, String CNH)
    {
        this.nome = nome;
        this.CNH = CNH;
    }

    public void registraCarro(Scanner scanner)
    {
        int qtCarros;

        System.out.printf("Qual a quantidade de carros do(a) %s (min:1): ",nome);
        qtCarros = scanner.nextInt();
        scanner.nextLine();

        qtCarros = qtCarros==0 ? 1:qtCarros;

        for(int i = 0 ; i < qtCarros ; i++)
        {
            String modelo;
            String placa = GeradorPlacas.getPlaca();

            System.out.printf("Qual o modelo do carro %d do(a) %s: ",i+1,nome);
            modelo = scanner.nextLine();
            Carro carro = new Carro(placa,modelo);
            meusCarros.add(carro);
            carro.registrarMultas(meusCarros);

        }

    }
}
