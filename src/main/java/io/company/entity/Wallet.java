package io.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.company.entity.User;
import lombok.*;
import javax.persistence.*;



@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity(name = "Wallet")
@Table(name = "WALLET_TABLE")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID" )
    private long id;

    @Column(name="Name")
    private String name;

    @Column(name="NameCoins")
    private String nameCoins;

    @Column(name="PASSWORD")
    private String password;







    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID")
    private User userId;




    public Wallet(String name, String nameCoins ,String password) {

        this.name = name;
        this.nameCoins = nameCoins;
        this.password = password;

    }


    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameCoins='" + nameCoins + '\'' +
                ", password='" + password + '\'' +

                '}';
    }
}
