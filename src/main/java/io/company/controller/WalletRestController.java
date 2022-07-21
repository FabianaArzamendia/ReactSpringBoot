package io.company.controller;


import io.company.entity.Wallet;
import io.company.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

//CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("api")
public class WalletRestController {

    @Autowired
    WalletService walletService;

    //CRUD GET ALL WALLETS
    @RequestMapping(path = "wallets",  method = RequestMethod.GET)
    public ResponseEntity<Iterable<Wallet>> getAllWallets(){
        var headers = new HttpHeaders();
        headers.add("ResponseGet","findAll books executed");
        headers.add("version", "1.0 Api Rest Wallet Object");
        return ResponseEntity.accepted().headers(headers).body(walletService.getAllWallet());
    }

    //FIND WALLET BY ID
   //@GetMapping("getWallet")
    @RequestMapping(path = "getwallet",  method = RequestMethod.GET)
    public ResponseEntity<Wallet> findWalletById(Long id){
        var headers = new HttpHeaders();
        headers.add("ResponseGet","Find wallet by id");
        Optional<Wallet> walletFound = walletService.findWalletById(id);
        if(walletFound.isPresent()){
            return ResponseEntity.accepted().headers(headers).body(walletFound.get());
        }else{
            return ResponseEntity.notFound().headers(headers).build();
        }
    }
    //CRUD CREATE A WALLET
     @RequestMapping(path="addWallet", method = RequestMethod.POST)
       public ResponseEntity<Wallet> addWallet(@RequestBody Wallet wallet){
        //use Headers and ResponseEntity
        var headers = new HttpHeaders();
        headers.add("ResponseCreateWallet","Save Wallet executed");
        //headers.add("version", "1.0 Api Rest Wallet Object");

        Wallet walletCreate = walletService.createWallet(wallet);
        if(walletCreate != null){
            headers.add("Executed Output","Wallet created");
            return ResponseEntity.accepted().headers(headers).body(walletCreate);

        }else{
            headers.add("Executed Output", "Wallet not created");
            return ResponseEntity.internalServerError().headers(headers).build();
        }

    }
    //CRUD DELETE
     @DeleteMapping("deleteWallet/{id}")
     // @RequestMapping(path ="deleteWallet/{id}",  method = RequestMethod.DELETE)
    public  ResponseEntity<Wallet> deleteWallet(@PathVariable  Long id){
        //with Headers and ResponseEntity
        HttpHeaders headers = new HttpHeaders();
        headers.add("Operation", "deleteWallet");

        Optional<Wallet> walletfound = walletService.findWalletById(id);
        boolean isWallet = walletfound.isPresent();
        if(isWallet){
            walletService.deleteWalletById(id);
            headers.add("OperationStatus","deleted");
            return  ResponseEntity.accepted().headers(headers).body(walletfound.get());

        }else{
            headers.add("OperationStatus","not deleted, not found");
            return ResponseEntity.notFound().headers(headers).build();
        }

    }



    //CRUD UPDATE
    //@PutMapping("/updateWallet/{id}")
    @RequestMapping(path = "/updateWallet/{id}",  method = RequestMethod.PUT)
    public ResponseEntity<Wallet> updateWallet(@PathVariable Long id, @RequestBody Wallet wallet){
        String responseUpdate ="";
        var headers = new HttpHeaders();
        headers.add("ResponseUpdate", "updateBook executed");

        Optional<Wallet> walletFound = walletService.findWalletById(id);

        if(walletFound.isPresent()){
            return ResponseEntity.accepted().headers(headers).body(walletFound.get());
        }else{
            return ResponseEntity.notFound().headers(headers).build();

        }
    }

}
