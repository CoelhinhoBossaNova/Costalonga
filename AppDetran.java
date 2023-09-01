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
        int escolha;
        String resposta;
        char respostaFinal;

        System.out.println("Bem vindo a concessionária 'COSTALONGA CARROS'\n");

        do {
            System.out.println("------Menu de Opções------");
            System.out.println("1 - Novo proprietário");
            System.out.println("2 - Mostra proprietários");
            System.out.println("3 - Sair\n");
            do {
                System.out.print("Digite qual opção você seja seguir: ");
                escolha = scanner.nextInt();
                scanner.nextLine();

            } while (escolha > 3 || escolha < 1);

            switch (escolha)
            {
                case (1):
                    novoProprietario();
                    break;
                case (2):
                    mostraRegistros();
                    break;
                case (3):
                    System.out.println("Saindo do programa");
                    System.exit(0);
            }

            System.out.print("\nVoce deseja sair do programa [S/N]: ");
            resposta = scanner.nextLine().toUpperCase();
            respostaFinal = resposta.charAt(0);

            System.out.print("\n");

        }while(respostaFinal!='S');

        System.out.println("Programa finalizado com sucesso!");
        scanner.close();
    }

    public static void novoProprietario()
    {
        int quantidade;

        System.out.print("Quantos proprietarios deseja adicionar: ");
        quantidade = scanner.nextInt();
        scanner.nextLine();
        quantidade = quantidade==0 ? 1 : quantidade;

        for(int i=0 ; i < quantidade ; i++)
        {
            Proprietario dono = registraProprietario();
            garagem(dono);
        }
    }

    public static void mostraRegistros()
    {

        for (Proprietario proprietario : listaProprietario)
        {
            int aux = 1;

            System.out.printf("\nO nome do proprietário é %s\n",proprietario.nome);
            System.out.printf("O CNH do proprietário é %s\n\n",proprietario.CNH);

            for(Carro carro : proprietario.meusCarros)
            {
                System.out.printf("O caro %d do(a) proprietário(a) é um %s ,com placa %s\n",aux,carro.getModelo(),carro.getPlaca());

                ++aux;

                for(Multa multa : carro.getMultas())
                {
                    System.out.printf("O carro possui uma multa por %s no valor de %.2fR$\n\n",multa.infracao,multa.valor);
                    break;
                }
            }
            System.out.print("-->Pressione 'Enter' para continuar: ");
            scanner.nextLine();
        }
        System.out.print("\nSem mais proprietários!\n");

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
}