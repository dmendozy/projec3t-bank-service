package com.bank.bank.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@Document(collection = "banks")
public class Bank {
    @Id
    public String bankId;
    public String name;
    public List<String> customerId;

    public Bank(){
        super();
    }

}
