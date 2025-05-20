
package com.vidaemgotas.service;

import com.vidaemgotas.config.JwtService;
import com.vidaemgotas.dto.JwtResponse;
import com.vidaemgotas.dto.LoginRequest;
import com.vidaemgotas.model.Doador;
import com.vidaemgotas.model.Instituicao;
import com.vidaemgotas.repository.DoadorRepository;
import com.vidaemgotas.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private DoadorRepository doadorRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtResponse autenticar(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String senha = loginRequest.getSenha();

        switch (loginRequest.getTipoUsuario()) {
            case DOADOR -> {
                Doador doador = doadorRepository.findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("Doador não encontrado"));
                if (!passwordEncoder.matches(senha, doador.getSenha())) {
                    throw new RuntimeException("Senha inválida");
                }
                return new JwtResponse(jwtService.generateToken(doador.getEmail()));
            }
            case INSTITUICAO -> {
                Instituicao instituicao = instituicaoRepository.findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("Instituição não encontrada"));
                if (!passwordEncoder.matches(senha, instituicao.getSenha())) {
                    throw new RuntimeException("Senha inválida");
                }
                return new JwtResponse(jwtService.generateToken(instituicao.getEmail()));
            }
            default -> throw new RuntimeException("Tipo de usuário inválido");
        }


    }
}
