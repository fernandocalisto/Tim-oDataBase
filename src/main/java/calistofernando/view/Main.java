package calistofernando.view;

import calistofernando.model.Player;
import calistofernando.repository.PlayerDAO_MySQL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayerDAO_MySQL dao = new PlayerDAO_MySQL();
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean ligado = true;

        while (ligado) {
            System.out.println("""
                \n--- Banco de Dados do Timão ---
                1 - Adicionar atleta
                2 - Remover atleta
                3 - Consultar atleta por ID
                4 - Consultar todos os atletas
                0 - Sair
                Opção desejada:""");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                    LocalDate data = LocalDate.parse(scan.nextLine(), dtf);
                    System.out.print("Posição: ");
                    String pos = scan.nextLine();

                    Player p = new Player(nome, data, pos);
                    dao.savePlayer(p);
                }
                case 2 -> {
                    System.out.print("Digite o ID para remover: ");
                    int id = scan.nextInt();
                    dao.deletePlayer(id);
                    System.out.println("Removido!");
                }
                case 3 -> {
                    System.out.print("Digite o ID do atleta: ");
                    int id = scan.nextInt();
                    Player p = dao.getPlayer(id);
                    System.out.println(p != null ? p : "Jogador não encontrado.");
                }
                case 4 -> {
                    List<Player> lista = dao.getAllPlayers();
                    System.out.println("--- Lista de Jogadores ---");
                    lista.forEach(System.out::println);
                }
                case 0 -> {
                    System.out.println("Vai Corinthians! Encerrando...");
                    ligado = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
        scan.close();
    }
}