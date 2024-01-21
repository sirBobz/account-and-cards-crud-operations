package com.financial.service.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "card")
public class Card {
    @Id
    @Column("card_id")
    private Integer cardId;
    @Column("card_alias")
    private String cardAlias;
    @Column("account_id")
    private Integer accountId;
    @Column("card_type")
    private String cardType;
}
