package exemploRedeSocial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    private static List<Sessao> listaSessoes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("---- Tela Inicial ----");
            System.out.println("1. Novo Usuário");
            System.out.println("2. Remover Usuário");
            System.out.println("3. Logar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    try {
                        novoUsuario();
                    } catch (Exception e) {
                        System.out.println("Erro ao criar novo usuário: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        removerUsuario();
                    } catch (Exception e) {
                        System.out.println("Erro ao remover usuário: " + e.getMessage());
                    }
                    break;
                case 3:
                    logar();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void novoUsuario() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, email, senha);
        listaUsuarios.add(novoUsuario);
        System.out.println("Novo usuário criado com sucesso!");
    }

    private static void removerUsuario() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome de usuário a remover: ");
        String nomeUsuario = scanner.nextLine();

        Usuario usuarioARemover = null;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                usuarioARemover = usuario;
                break;
            }
        }

        if (usuarioARemover != null) {
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            // Confirmar a exclusão do usuário
            System.out.print("Tem certeza que deseja remover este usuário? (S/N): ");
            String confirmacao = scanner.nextLine().toUpperCase();
            if (confirmacao.equals("S")) {
                // Excluir todas as amizades do usuário
                for (Usuario amigo : usuarioARemover.getAmigos()) {
                    amigo.destruirAmizade(usuarioARemover);
                }

                // Excluir todas as sessões do usuário
                for (Sessao sessao : listaSessoes) {
                    if (sessao.getUsuario().equals(usuarioARemover)) {
                        listaSessoes.remove(sessao);
                    }
                }

                // Remover o usuário da lista
                listaUsuarios.remove(usuarioARemover);
                System.out.println("Usuário removido com sucesso!");
            } else {
                System.out.println("Operação de remoção cancelada.");
            }
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }

    private static void logar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome de usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNome().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                Sessao novaSessao = Sessao.logar(usuario);
                listaSessoes.add(novaSessao);
                
                // Ir para o menu da sessão
                menuSessao(novaSessao);
                return;
            }
        }

        System.out.println("Usuário ou senha incorretos.");
    }

    private static void menuSessao(Sessao sessao) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("---- Menu de Sessão ----");
            System.out.println("1. Listar Postagens");
            System.out.println("2. Criar Postagem");
            System.out.println("3. Criar Amizade");
            System.out.println("4. Desfazer Amizade");
            System.out.println("0. Menu Anterior");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    sessao.listarPostagens();
                    break;
                case 2:
                    System.out.print("Digite a nova postagem: ");
                    String novaPostagem = scanner.nextLine();
                    sessao.incluirPostagem(novaPostagem);
                    System.out.println("Postagem criada com sucesso!");
                    break;
                case 3:
                    System.out.print("Nome do novo amigo: ");
                    String nomeNovoAmigo = scanner.nextLine();
                    try {
                        sessao.criarAmizade(nomeNovoAmigo);
                        System.out.println("Amizade criada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao criar amizade: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Nome do ex-amigo: ");
                    String nomeExAmigo = scanner.nextLine();
                    try {
                        sessao.desfazerAmizade(nomeExAmigo);
                        System.out.println("Amizade desfeita com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao desfazer amizade: " + e.getMessage());
                    }
                    break;
                case 0:
                    sessao.deslogar();
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    }
}
