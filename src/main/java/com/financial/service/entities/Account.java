package com.financial.service.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Table(name = "account")
public class Account {
    @Id
    @Column("account_id")
    private Integer accountId;
    @Column("iban")
    private String iban;
    @Column("bic_swift")
    private String bicSwift;
    @Column("client_id")
    private Integer clientId;

}
