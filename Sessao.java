package exemploRedeSocial;

import java.time.LocalDateTime;
import java.util.List;

public class Sessao {
    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Sessao(Usuario usuario) {
        this.usuario = usuario;
        this.inicio = LocalDateTime.now();
        this.fim = null;
    }
    

    // Getters
    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    // Método para encerrar a sessão
    public void encerrarSessao() {
        this.fim = LocalDateTime.now();
    }
 // Método para listar postagens do usuário na sessão
    public void listarPostagens() {
        List<String> postagens = usuario.listaPostagens();
        for (String postagem : postagens) {
            System.out.println(postagem);
        }
    }

    // Método para incluir postagem
    public void incluirPostagem(String postagem) {
        usuario.novaPostagem(postagem);
    }

    // Método para criar amizade
    public void criarAmizade(String nomeNovoAmigo) throws Exception {
        Usuario amigo = encontrarUsuario(nomeNovoAmigo);
        if (amigo != null) {
            usuario.criarAmizade(amigo);
        } else {
            throw new Exception("Usuário não encontrado para criar amizade!");
        }
    }

    // Método para desfazer amizade
    public void desfazerAmizade(String nomeExAmigo) throws Exception {
        Usuario exAmigo = encontrarUsuario(nomeExAmigo);
        if (exAmigo != null) {
            usuario.destruirAmizade(exAmigo);
        } else {
            throw new Exception("Usuário não encontrado para desfazer amizade!");
        }
    }

    // Método para encerrar sessão
    public void deslogar() {
        // Aqui você pode realizar as operações necessárias para encerrar a sessão
        // Por exemplo, remover a sessão da lista de sessões ativas
    }

    // Método privado para encontrar um usuário na lista de usuários
    private Usuario encontrarUsuario(String nome) {
        for (Usuario u : listaUsuarios) {
            if (u.getNome().equals(nome)) {
                return u;
            }
        }
        return null;
    }
}
