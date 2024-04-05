package src;

import java.util.Scanner;

import src.Models.*;

public class Main {
    public static void main(String[] args) {
        Scanner IN = new Scanner(System.in);
        // Variáveis necessárias para cadastro de User
        int id = 1;
        String nome_usuario;
        String email;
        String senha;
        String confirma;
        String contato;
        String cep;
        String estado;
        String cidade;
        String rua;
        String numero;
        String complemento;

        System.out.print("Informe seu nome de usuário: ");
        nome_usuario = IN.next();
        System.out.print("Informe seu e-mail de cadastro: ");
        email = IN.next();
        do {
            System.out.print("Informe sua senha: ");
            senha = IN.next();
            System.out.print("Confirme sua senha: ");
            confirma = IN.next();
            if (!senha.equals(confirma)) {
                System.out.println("As senhas são diferentes, preencha novamente.");
            } else {
                System.out.println("Senha salva!");
            }
        } while (!senha.equals(confirma));
        System.out.print("Informe algum contato (pode ser e-mail ou telefone): ");
        contato = IN.next();
        System.out.println("Para finalizar seu cadastro, preencha as informações sobre seu endereço.");
        System.out.print("Informe seu CEP: ");
        cep = IN.next();
        System.out.print("Informe seu estado: ");
        estado = IN.next();
        System.out.print("Informe sua cidade: ");
        cidade = IN.next();
        System.out.print("Informe sua nome rua: ");
        rua = IN.next();
        System.out.print("Informe o número da sua casa (caso não tenha número, preencha com -): ");
        numero = IN.next();
        System.out.print("Informe um complemento (caso não tenha, preencha com -): ");
        complemento = IN.next();

        Endereco endereco = new Endereco(cep, estado, cidade, rua, numero, complemento);
        User user = new User(id, nome_usuario, email, senha, contato, endereco);

        System.out.println("Informações cadastradas!");
        
        System.out.println("Nome de usuário: " + user.getNome_usuario());

        IN.close();
    }
}
