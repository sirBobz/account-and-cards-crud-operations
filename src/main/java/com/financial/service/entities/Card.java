package com.financial.service.entities;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "cardAlias cannot be empty")
    private String cardAlias;
    @Column("account_id")
    @NotNull(message = "accountId cannot be empty")
    private Integer accountId;
    @Column("card_type")
    @NotNull(message = "cardType cannot be empty")
    private String cardType;
}
