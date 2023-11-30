package exemploRedeSocial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<String> listaPostagens;
    private List<Usuario> amigos; // Lista de amigos

    // Construtor
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.listaPostagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public List<String> getListaPostagens() {
        return listaPostagens;
    }

    public void setListaPostagens(List<String> listaPostagens) {
        this.listaPostagens = listaPostagens;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    // ... (mesmo que o código anterior)

    // Método para adicionar nova postagem à lista de postagens
    public void novaPostagem(String postagem) {
        listaPostagens.add(postagem);
    }

    // Método para retornar a lista de postagens do usuário
    public List<String> listaPostagens() {
        return listaPostagens;
    }

    // Método para criar amizade entre este usuário e seu amigo
    public void criarAmizade(Usuario amigo) throws Exception {
        if (this.amigos.contains(amigo)) {
            throw new Exception("Amizade já existe!");
        } else {
            this.amigos.add(amigo);
            amigo.amigos.add(this); // Criar amizade inversa
        }
    }

    // Método para destruir amizade entre este usuário e seu amigo
    public void destruirAmizade(Usuario amigo) throws Exception {
        if (!this.amigos.contains(amigo)) {
            throw new Exception("Essa amizade não existe!");
        } else {
            this.amigos.remove(amigo);
            amigo.amigos.remove(this); // Remover amizade inversa
        }
    }
    private static List<Sessao> sessoes = new ArrayList<>();

    // Método estático para criar uma nova sessão
    public static void logar(Usuario usuario) {
        Sessao novaSessao = new Sessao(usuario);
        sessoes.add(novaSessao);
        System.out.println("Sessão iniciada para o usuário: " + usuario.getNome());
    }

    // Método estático para encerrar uma sessão
    public static void deslogar(Sessao sessao) {
        sessao.encerrarSessao();
        System.out.println("Sessão encerrada para o usuário: " + sessao.getUsuario().getNome());
    }

    // Método estático para autenticar um usuário
    public static void autenticar(List<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome de usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                logar(usuario);
                return;
            }
        }
        System.out.println("Usuário ou senha incorretos!");
    }

    // Outros métodos existentes...

    // Método estático para incluir uma postagem na lista de postagens do usuário da sessão
    public static void incluirPostagem(Sessao sessao) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a postagem: ");
        String postagem = scanner.nextLine();
        sessao.getUsuario().novaPostagem(postagem);
    }

    // Método estático para listar as postagens do usuário da sessão
    public static void listarPostagens(Sessao sessao) {
        List<String> postagens = sessao.getUsuario().listaPostagens();
        System.out.println("Postagens do usuário " + sessao.getUsuario().getNome() + ":");
        for (String postagem : postagens) {
            System.out.println(postagem);
        }
    }

    // Método para criar amizade entre usuários
    public void criarAmizade(String nomeDoAmigo) throws Exception {
        // Lógica para encontrar o usuário pelo nome e criar a amizade
    }

    // Método para desfazer amizade entre usuários
    public void desfazerAmizade(String nomeDoExAmigo) throws Exception {
        // Lógica para encontrar o usuário pelo nome e desfazer a amizade
    }
}


