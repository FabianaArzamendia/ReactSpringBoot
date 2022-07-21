package io.company.service;


import io.company.entity.Wallet;
import io.company.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.security.PublicKey;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;


    // GET ALL WALLETS
    public Iterable<Wallet> getAllWallet(){
        Iterable<Wallet> wallets = walletRepository.findAll();
        return wallets;
    }

    //CREATE A WALLET
    public Wallet createWallet(Wallet wallet){
        Wallet walletCreated = walletRepository.save(wallet);
        return walletCreated;
    }

    //FIND WALLET BY ID
    public Optional<Wallet> findWalletById(Long id){
        return walletRepository.findById(id);
    }

    //DELETE A WALLET BY ID
    public void deleteWalletById(Long id){

        walletRepository.deleteById(id);
    }

    //UPDATE WALLET  BY ID
    public Wallet updateWallet(Wallet wallet){
        return walletRepository.save(wallet);
    }




}
