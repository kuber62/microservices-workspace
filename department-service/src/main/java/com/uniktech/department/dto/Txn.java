package com.uniktech.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Txn {
    private Long txnId;
    private String txnEntity;
    private String txnDetails;
    private Date txnDate;
}
