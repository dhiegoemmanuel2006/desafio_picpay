package desafio_backend_picpay.desafio.controllers;

import desafio_backend_picpay.desafio.dtos.CreateTranferDTO;
import desafio_backend_picpay.desafio.services.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransferService tService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTranfer(@RequestBody CreateTranferDTO request) throws Exception {
        tService.createTransfer(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
