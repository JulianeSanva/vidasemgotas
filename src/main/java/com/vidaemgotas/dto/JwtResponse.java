
package com.vidaemgotas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String tipo = "Bearer";

    // ✅ Construtor com argumento para o token
    public JwtResponse(String token) {
        this.token = token;
        this.tipo = "Bearer";
    }

    // ✅ Construtor padrão (necessário para serialização, se usar)
    public JwtResponse() {
    }

    // ✅ Getters e Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
