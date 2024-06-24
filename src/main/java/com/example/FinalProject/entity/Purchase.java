package com.example.FinalProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Purchase")
@ToString(exclude = "usersAccount")

public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //private Auction auction;
    private UsersAccount user;
    private Double amount;
    //@ManyToOne
  //  @JoinColumn(name="auction_id")
    //private Auction auction;


    @OneToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
    @ManyToOne
    @JoinColumn(name = "usersAccount_id")
    private UsersAccount usersAccount;

}
