package com.financial.service.entities;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "iban cannot be empty")
    private String iban;
    @Column("bic_swift")
    @NotNull(message = "bicSwift cannot be empty")
    private String bicSwift;
    @Column("client_id")
    @NotNull(message = "clientId cannot be empty")
    private Integer clientId;

}
