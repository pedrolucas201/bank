package co.pedrolucas201.bank;

import java.util.Random;
import java.util.Scanner;

public class Account {
    private static final int MAX_LENGHT = 12;

    private String ag;
    private String cc;
    private String name;

    private double balance;
    private Log logger;

    public Account(String ag, String cc, String name){
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    public void setName(String name){
        if (name.length() > MAX_LENGHT){
            this.name = name.substring(0, MAX_LENGHT);
        } else {
            this.name = name;
        }
    }

    public void deposit(double value){
        balance += value;
        logger.out("DEPOSITO - R$ " + value + ": Sua conta é agora de $" + balance);
    }
    public boolean withDraw(double value){
        if (balance < value){
            logger.out("SAQUE - R$ " + value + ": Seu saldo atual é de: " + balance);
            return false;
        }
        balance -= value;
        logger.out("SAQUE - R$" + value + ": Sua conta é agora de $" + balance);
        return true;
    }

    @Override
    public String toString() {
        String result = "A conta de: " + this.name + " | Ag: " + this.ag + " | CC: " + this.cc + " | tem o extrado final de: " + balance;
        return result;
    }
}
