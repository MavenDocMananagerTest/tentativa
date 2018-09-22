package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.webapp.auth.LoggedUser;
import br.edu.utfpr.md.webapp.auth.Public;
import br.edu.utfpr.md.webapp.model.Pessoa;
import javax.inject.Inject;

@Controller
@Path("/auth")
public class AuthController {

    @Inject
    private Validator validator;
    @Inject
    private LoggedUser loggedUser;
    @Inject
    private Result result;

    @Get(value = {"", "/"})
    public void login() {

    }

    @Public
    @Post
    public void autenticar(Pessoa p) {
        try {
            if (p.getLogin().equals("admin") && p.getSenha().equals("1234")) {
                p.setNome("Administrador do sistema");
                this.loggedUser.login(p);
                this.result.redirectTo("/");
            } else {
                validator.add(new SimpleMessage("invalid", "Login e/ou Senha inválidos!"));
            }
        } catch (NullPointerException ex) {
            validator.add(new SimpleMessage("invalid", "Login e/ou Senha inválidos!"));
        }
        validator.onErrorForwardTo(this).login();
    }
}
