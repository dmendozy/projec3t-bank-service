package com.bank.bank.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public Bank(){
        super();
    }

}
