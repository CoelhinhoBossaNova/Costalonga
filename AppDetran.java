import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class AppDetran
{
    public static ArrayList<Proprietario> listaProprietario = new ArrayList<Proprietario>();
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args)
    {
        //Deletar depois
        GeradorPlacas placa = new GeradorPlacas();

        for(int i = 0 ; i < 2 ; i++)
        {
            Proprietario dono = registraProprietario();
            garagem(dono);
        }


        for (Proprietario proprietario : listaProprietario)
        {
            System.out.println(proprietario.nome);
            System.out.println(proprietario.CNH);

            for (Carro carro : proprietario.meuCarro)
            {
                System.out.println(carro.modelo);
            }
        }

        System.exit(0);


        int escolha;

        System.out.println("Bem vindo a concessionária 'COSTALONGA CARROS'\n");

        System.out.println("------Menu de Opções------");
        System.out.println("1 - Novo proprietário");
        System.out.println("2 - Adicionar informações");
        System.out.println("3 - Busca");
        System.out.println("4 - Sair\n");

        do {
            do {
                System.out.print("Digite qual opção você seja seguir: ");
                escolha = scanner.nextInt();
                scanner.nextLine();

            } while (escolha > 4 || escolha < 1);


            switch (escolha) {
                case (1):
                    //ADD proprietario

                    break;
                case (2):
                    //Adicionar informações
                    break;
                case (3):
                    //Busca
                    break;
                case (4):
                    System.out.println("Saindo do programa");
                    System.exit(0);
            }
        }while(true);
    }

    public static Proprietario registraProprietario()
    {

        System.out.print("Digite o nome do proprietário: ");
        String nome = scanner.nextLine();

        String CNH = String.format("ES%d",1000+random.nextInt(1000)+random.nextInt(26));
        System.out.printf("A CNH do(a) %s é %s\n" , nome , CNH);

        Proprietario dono = new Proprietario(nome,CNH);

        listaProprietario.add(dono);

        return dono;
    }
    public static void garagem(Proprietario motorista)
    {
        motorista.registraCarro(scanner);

    }

    //multa fazer


}