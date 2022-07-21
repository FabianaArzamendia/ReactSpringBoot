package io.company.configuration;

import io.company.entity.User;
import io.company.entity.Wallet;
import io.company.service.UserService;
import io.company.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



@Component
public class ApplicationCommandRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private WalletService walletService;


    @Override
    public void run(String... args) throws Exception {
        Scanner reader = new Scanner(System.in);





       /* userService.createUser(new User("Lola", "Lopez"));
        userService.createUser(new User("Maria", "Dominick"));
        userService.createUser(new User("Ana", "Garcia"));
        userService.createUser(new User("Diana", "Ramirez"));
        userService.createUser(new User("Lorena", "Pix"));*/

       /* walletService.createWallet(new Wallet("BINANCE","12345P","Kucoin"));
        walletService.createWallet(new Wallet("COINBASE","12345F","Bitcoin"));
        walletService.createWallet(new Wallet(" eToro","12345A","Ethereum"));
        walletService.createWallet(new Wallet(" NAGA","12345M","Litecoin"));
        walletService.createWallet(new Wallet("Trezor","12345X","Bitcoin"));*/

       // createOnewallet(reader);


   // }
        /*public void createOnewallet(Scanner reader){

            System.out.println("Name? ");
            String name = reader.nextLine();

            System.out.println("NameCoins? ");
            String nameCoins = reader.nextLine();

            System.out.println("Password? ");
            String password = reader.nextLine();


            walletService.createWallet(new Wallet(name,nameCoins,password));
            walletService.createWallet(new Wallet("BINANCE","12345P","Kucoin"));
            walletService.createWallet(new Wallet("COINBASE","12345F","Bitcoin"));*/

        }












}
