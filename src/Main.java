import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menu;
        ArrayList<String> tarefas = new ArrayList<>();
        do {
            System.out.println("\n#### MENU ####");
            System.out.println("1. Adicionar nova tarefas");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Atualizar tarefas");
            System.out.println("4. Remover tarefas");
            System.out.println("5. Sair\n");

            Scanner entrada = new Scanner(System.in);
            menu = entrada.nextInt();

            switch (menu) {
                case 1:
                    adicionarTarefa(tarefas);
                    break;
                case 2:
                    listarTarefas(tarefas);
                    break;
                case 3:
                    atualizarTarefa(tarefas);
                    break;
                case 4:
                    removerTarefa(tarefas);
                    break;
            }
        }
        while (menu != 5 && menu < 5);
    }

    public static ArrayList adicionarTarefa(ArrayList tarefas){
        System.out.print("Qual tarefa deseja adicionar? ");
        Scanner scan = new Scanner(System.in);
        tarefas.add(scan.nextLine());
        return tarefas;
    }

    public static void listarTarefas(ArrayList tarefas){
        System.out.println("Tarefas: \n");
        for(int i = 0; i < tarefas.size(); i++){
            System.out.println((i+1) + ". " + tarefas.get(i));
        }
    }

    public static void atualizarTarefa(ArrayList tarefas){

        System.out.print("Digite o número da tarefa que deseja atualizar: ");
        Scanner atualizar = new Scanner(System.in);
        try {
            int indexTarefa = (atualizar.nextInt() - 1);
            atualizar.nextLine();
            System.out.println("Digite a nova tarefa: ");
            String novaTarefa = atualizar.nextLine();
            tarefas.set(indexTarefa, novaTarefa);
        }
        catch(IndexOutOfBoundsException erroForaDoLimite){
            System.out.println("Digite um número válido! ");
        }
        System.out.println("\nTarefa atualizada! ");
    }

    public static void removerTarefa(ArrayList tarefas){
        System.out.println("Digite o número da tarefa a ser removida: ");
        Scanner remover = new Scanner(System.in);
        int removerTarefa = (remover.nextInt()-1);
        tarefas.remove(removerTarefa);
        System.out.println("Tarefa removida! ");
    }
}