package com.mfms.medicalclinicapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfms.medicalclinicapi.Dtos.UserDto;
import com.mfms.medicalclinicapi.Entities.UserEntity;
import com.mfms.medicalclinicapi.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/post")
    public ResponseEntity<UserEntity> postMethodName(@RequestBody  UserDto entity) {
        var userModel = new UserEntity();
        BeanUtils.copyProperties(entity, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }

    @GetMapping("/get")
    public ResponseEntity<List<UserEntity>> getAll() {
        List<UserEntity>users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }
    
    @PutMapping("/put")
    public ResponseEntity<Object> changeAll(@PathVariable(value = "id") Long id, @RequestBody UserEntity userEntity){
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Não encontrado");
        }
        var entity = user.get();
        BeanUtils.copyProperties(user, entity);
        return  ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userEntity)); 
    }
    
}
