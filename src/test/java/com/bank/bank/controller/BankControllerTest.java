package com.bank.bank.controller;

import com.bank.bank.model.Bank;
import com.bank.bank.repository.BankRepository;
import com.bank.bank.service.BankService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = BankController.class)
@Import(BankService.class)
public class BankControllerTest {

    @MockBean
    BankRepository repository;

    @Autowired
    private WebTestClient webClient;

    final private static Map<String, Bank> bankMap = new HashMap<>();

    @BeforeAll
    public static void setup() {
        bankMap.put("test", new Bank("1", "Banco 1", null));
    }

    @Test
    public void testCreateBank() {
        Mockito
                .when(repository.save(bankMap.get("test"))).thenReturn(Mono.just(bankMap.get("test")));

        webClient.post()
                .uri("/banks")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bankMap.get("test")))
                .exchange()
                .expectStatus().isOk();
        Mockito.verify(repository, Mockito.times(1)).save(bankMap.get("test"));

    }


    @Test
    public void testGetBankById() {
        Mockito
                .when(repository.findById(bankMap.get("test").bankId))
                .thenReturn(Mono.just(bankMap.get("test")));

        webClient.get()
                .uri("/banks/{id}", bankMap.get("test").bankId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Bank.class)
                .isEqualTo(bankMap.get("test"));
        Mockito.verify(repository, Mockito.times(1)).findById(bankMap.get("test").bankId);
    }

    @Test
    public void testUpdateBank() {
        Mockito
                .when(repository.findById(bankMap.get("test").bankId))
                .thenReturn(Mono.just(bankMap.get("test")));

        webClient.put()
                .uri("/banks/{id}", bankMap.get("test").bankId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bankMap.get("test")))
                .exchange()
                .expectStatus().isOk();
        Mockito.verify(repository, Mockito.times(1)).save(bankMap.get("test"));
    }

    @Test
    public void testDeleteBank() {
        Mockito
                .when(repository.deleteById(bankMap.get("test").bankId))
                .thenReturn(Mono.empty());

        webClient.delete()
                .uri("/banks/{id}", bankMap.get("test").bankId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Bank.class)
                .isEqualTo(null);
        Mockito.verify(repository, Mockito.times(1)).deleteById(bankMap.get("test").bankId);

    }
}
