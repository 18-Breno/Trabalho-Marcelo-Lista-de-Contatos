import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeContatosConsole {
    private static ArrayList<Contato> listaContatos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Lista de Contatos ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Editar Contato");
            System.out.println("3. Excluir Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Ligar para Contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    editarContato();
                    break;
                case 3:
                    excluirContato();
                    break;
                case 4:
                    listarContatos();
                    break;
                case 5:
                    ligarParaContato();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void adicionarContato() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o celular: ");
        String celular = scanner.nextLine();
        Contato contato = new Contato(nome, celular);
        listaContatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void editarContato() {
    listarContatos();
    
    if (listaContatos.isEmpty()) {
        System.out.println("A lista de contatos está vazia.");
        return;
    }

    System.out.print("Digite o índice do contato que deseja editar: ");
    int indice = scanner.nextInt();
    scanner.nextLine(); // consumir a quebra de linha

    if (indice >= 0 && indice < listaContatos.size()) {
        System.out.print("Digite o novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o novo celular: ");
        String celular = scanner.nextLine();

        Contato contato = listaContatos.get(indice);
        contato.setNome(nome);
        contato.setCelular(celular);

        System.out.println("Contato atualizado com sucesso!");
    } else {
        System.out.println("Índice inválido. Tente novamente.");
    }
}


    private static void excluirContato() {
        listarContatos();
        System.out.print("Digite o índice do contato que deseja excluir: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // consumir a quebra de linha
        if (indice >= 0 && indice < listaContatos.size()) {
            listaContatos.remove(indice);
            System.out.println("Contato deletado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

   private static void listarContatos() {
    System.out.println("\n--- Contatos ---");
    for (int i = 0; i < listaContatos.size(); i++) {
        System.out.println("Índice: " + i + " - " + listaContatos.get(i));
    }
}
 
    private static void ligarParaContato() {
        listarContatos();
        System.out.print("Digite o índice do contato para ligar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // consumir a quebra de linha
        if (indice >= 0 && indice < listaContatos.size()) {
            System.out.println("Ligando para " + listaContatos.get(indice).getNome() + "...");
        } else {
            System.out.println("Índice inválido.");
        }
    }
}
