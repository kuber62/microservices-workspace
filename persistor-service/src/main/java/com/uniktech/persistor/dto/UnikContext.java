package com.uniktech.persistor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnikContext {
    private String requestTopic;
    private String requestMessage;
}
