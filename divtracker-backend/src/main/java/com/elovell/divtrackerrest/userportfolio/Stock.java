package com.elovell.divtrackerrest.userportfolio;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "USER_PORTFOLIO")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK1")
    private Long pk1;
    @Column(name = "SYMBOL")
    private String symbol;
    @Column(name = "SHARES_OWNED")
    private int sharesOwned;
    @Column(name = "USER_PK1")
    private Long userPk1;
    @Column(name = "DTCREATED")
    private LocalDateTime dateCreated;
}
