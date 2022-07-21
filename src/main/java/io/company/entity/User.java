package io.company.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
@Entity(name = "User")
@Table(name = "USER_TABLE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long userId;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;



    @OneToMany(mappedBy = "userId" , cascade = CascadeType.ALL)
    private List<Wallet> wallets = new ArrayList<Wallet>();



    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }




   public void addWallet(Wallet wallet) {

        this.getWallets().add(wallet);

        if (wallet.getUserId() != null) {

            wallet.getUserId().getWallets().remove(wallet);

            wallet.setUserId(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", wallets=" + wallets +
                '}';
    }
}
