package calistofernando.view;

import calistofernando.model.Player;
import calistofernando.repository.PlayerDAO_MySQL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;

public class Main {

    private PlayerDAO_MySQL dao = new PlayerDAO_MySQL();
    private Scanner scan = new Scanner(System.in);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Main() {

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.executar();
    }

    public void executar() {
        boolean ligado = true;

        while (ligado) {
            exibirMenu();
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 -> adicionarAtleta();
                case 2 -> removerAtleta();
                case 3 -> consultarAtleta();
                case 4 -> todosAtletas();
                case 0 -> {
                    System.out.println("Vai Corinthians! Encerrando...");
                    ligado = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
        scan.close();
    }

    private void exibirMenu() {
        System.out.println("""
                \n--- Banco de Dados do Timão ---
                1 - Adicionar atleta
                2 - Remover atleta
                3 - Consultar atleta por ID
                4 - Consultar todos os atletas
                0 - Sair
                Opção desejada:""");
    }

    private void adicionarAtleta() {
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        LocalDate data = LocalDate.parse(scan.nextLine(), dtf);
        System.out.print("Posição: ");
        String pos = scan.nextLine();

        dao.savePlayer(new Player(nome, data, pos));
        System.out.println("Atleta adicionado com sucesso!");
    }

    private void removerAtleta() {
        System.out.print("Digite o ID para remover: ");
        int id = scan.nextInt();
        dao.deletePlayer(id);
        System.out.println("Operação realizada!");
    }

    private void consultarAtleta() {
        System.out.print("Digite o ID do atleta: ");
        int id = scan.nextInt();
        Player p = dao.getPlayer(id);
        System.out.println(p != null ? p : "Jogador não encontrado.");
    }

    private void todosAtletas() {
        List<Player> lista = dao.getAllPlayers();
        System.out.println("--- Lista de Jogadores ---");
        lista.forEach(System.out::println);
    }

}