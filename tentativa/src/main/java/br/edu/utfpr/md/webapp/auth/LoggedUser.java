package br.edu.utfpr.md.webapp.auth;

import br.edu.utfpr.md.webapp.model.Pessoa;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class LoggedUser implements Serializable {
    private Pessoa pessoa;

    public void login(Pessoa p) {
        this.pessoa = p;
    }
    public void logout() {
        this.pessoa = null;
    }
    public boolean isLogged() {
        return this.pessoa != null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
