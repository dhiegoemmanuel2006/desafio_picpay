package desafio_backend_picpay.desafio.controllers;

import desafio_backend_picpay.desafio.dtos.CreateUserDTO;
import desafio_backend_picpay.desafio.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
@RequiredArgsConstructor
public class UsersController { //falta adicionar as responses para documentação da API
    private final UserService uService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO request) throws Exception{
        uService.createUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
