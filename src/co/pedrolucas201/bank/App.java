package co.pedrolucas201.bank;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("0001");

        while (true){
            System.out.println("O que deseja fazer? (C) = Cria Conta | (E) = Sair ");
            String op = scanner.nextLine();

            if (op.equals("C")){
                System.out.println("Digite seu nome: ");
                String name = scanner.nextLine();
                System.out.println(name);
                Account account = santander.generateAccount(name);
                santander.insetAccount(account);

                operateAccount(account);
            }else if (op.equals("E")){
                break;
            }else {
                System.out.println("Comando inválido.");
            }
        }

        List<Account> accountList = santander.getAccounts();
        for (Account cc: accountList){
            System.out.println(cc);
        }
        santander.outputTotal();
    }

    static void operateAccount(Account account){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("O que deseja fazer? | (D) = Deposito | (S) = Saque | (E) = Sair da Conta");
            String op = scanner.nextLine();

            if (op.equals("D")) {
                System.out.println("Qual valor deseja depositar? ");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar? ");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Saldo insuficiente para operação.");
                }
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente!!");
            }

            scanner = new Scanner(System.in);

        }
    }
}
