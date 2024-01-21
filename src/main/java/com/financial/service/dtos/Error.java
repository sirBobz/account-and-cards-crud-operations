package com.financial.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private String statusCode;
    private String statusMessage;
    private String errorCode;
    private Object detailedErrorMessage;
    private String timestamp;

}
