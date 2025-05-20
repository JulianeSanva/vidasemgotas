
package com.vidaemgotas.dto;

import com.vidaemgotas.model.TipoUsuario;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
