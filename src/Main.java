import br.com.dio.dao.UserDAO;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;

import java.awt.*;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class Main {

    private final static UserDAO = new UserDAO();

    private final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Seja bem vindo ao cadastro de usuários, selecione a operação desejada.");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Buscar por identificador");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");
        var userInput = scanner.nextInt();

        while(true){
            var selectedOption = MenuOption.values()[userInput -1];
            switch (selectedOption){
                case SAVE -> {

                }
            }
        }
    }

    private static UserModel requestUserInfo(){
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
}