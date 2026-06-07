import br.com.dio.dao.UserDAO;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;

import java.awt.*;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class Main {

    // tempo do video 35:10

    private final static UserDAO dao = new UserDAO();


    private final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while(true){
            System.out.println("Seja bem vindo ao cadastro de usuários, selecione a operação desejada.");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values()[userInput -1];
            switch (selectedOption){
                case SAVE -> {
                    var user = dao.save(requestToSave());
                    System.out.printf("Usuário salvo %s", user);
                }
                case UPDATE -> {
                    var user = dao.save(requestToUpdate());
                    System.out.printf("Usuário Atualizado %s", user);
                }
                case DELETE -> {
                    dao.delete(requestId());
                    System.out.println("Usuário Excluido");
                }
                case FIND_BY_ID -> {
                    var id = requestId();
                    var user = dao.findById(requestId());
                    System.out.printf("Usuário do ID %s:", id);
                    System.out.println(user);
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários Cadastrados");
                    System.out.println("=======Inicio=======");
                    users.forEach(System.out::println);
                    System.out.println("========Fim=========");
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    private static long requestId(){
        System.out.println("Informe o identificador do usuário.");
        return scanner.nextLong();
    }

    private static UserModel requestToSave(){
        System.out.println("Informe nome do usuário");
        var name = scanner.next();
        System.out.println("Informe email do usuário");
        var email = scanner.next();
        System.out.println("Informe data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(0 , name, email, birthday);

    }
    private static UserModel requestToUpdate(){
        System.out.println("Informe o identificador do usuário");
        var id = scanner.nextLong();
        System.out.println("Informe nome do usuário");
        var name = scanner.next();
        System.out.println("Informe email do usuário");
        var email = scanner.next();
        System.out.println("Informe data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel( id, name, email, birthday);

    }
}