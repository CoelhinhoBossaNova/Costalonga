import java.util.ArrayList;
import java.util.Scanner;

public class Proprietario
{
    String nome;
    ArrayList<Carro> meuCarro = new ArrayList<Carro>();
    String CNH;

    // Construtor para inicializar um proprietário
    public Proprietario(String nome, String CNH)
    {
        this.nome = nome;
        this.CNH = CNH;
    }

    public void registraCarro(Scanner scanner)
    {
        int qtCarros;

        System.out.printf("Qual a quantidade de carros do(a) %s (min:1): ",this.nome);
        qtCarros = scanner.nextInt();
        scanner.nextLine();

        qtCarros = qtCarros==0 ? 1:qtCarros;

        for(int i = 0 ; i < qtCarros ; i++)
        {
            Carro garagem = new Carro();

            System.out.printf("Digite o nome do carro do(a) %s: ", this.nome);
            garagem.modelo = scanner.nextLine();
            meuCarro.add(garagem);

        }

    }
}
