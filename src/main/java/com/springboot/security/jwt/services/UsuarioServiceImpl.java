package com.springboot.security.jwt.services;

import com.springboot.security.jwt.repository.UsuarioRepository;
import com.springboot.security.jwt.entity.Usuario;
import com.springboot.security.jwt.entity.dto.UsuarioDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepo;


    public Usuario findById(Long id){
        Optional<Usuario> obj = userRepo.findById(id);
        return obj.orElseThrow();
    }


    public Page<Usuario> getUser(int page, int size) {
        return userRepo.findAll(PageRequest.of(page, size));
    }


    public Usuario postUser(UsuarioDTO userDTO, String role) {
        Usuario user = (role.equals("ROLE_ADMINISTRADOR")) ? userDTO.addAdmin(userDTO) : userDTO.addTreasurer(userDTO);
        return userRepo.save(user);
    }


    public Usuario getUser(String username) {
        return userRepo.findByUsername(username).get();
    }

    @Override
    public Usuario findById() {
        return null;
    }

}





//@Service
//@RequiredArgsConstructor
//@Transactional
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepo;
//
//    @Override
//    public Page<User> getUser(int page, int size) {
//        return userRepo.findAll(PageRequest.of(page, size));
//    }
//
//    @Override
//    public User postUser(UserDTO userDTO, String role) {
//        User user = (role.equals("STAFF")) ? userDTO.addStaff(userDTO) : userDTO.addCostumer(userDTO);
//        return userRepo.save(user);
//    }
//
//    @Override
//    public User getUser(String username) {
//        return userRepo.findByUsername(username).get();
//    }
//
//}
