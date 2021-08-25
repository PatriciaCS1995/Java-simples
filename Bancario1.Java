Classe Conta

package sistemabancosimples;

public class Conta {
private int numeroConta;
private Cliente cliente;
private double saldo;

//Trabalhando com encapsulamento
//Numero de conta gerado pelo sistema. 
//Saldo zerado
public Conta(Cliente cliente) {
    this.numeroConta = 123;
    this.cliente = cliente;
    this.saldo = 0; 
}

//Depósito na conta e imprime resultado.
public void deposito(double valorDeposito) {
    this.saldo += valorDeposito;
    System.out.println("Deposito realizado com sucesso." + "\n"
            + "Saldo atual R$ " + this.saldo + "\n");
}

//Para saque na conta e imprime resultado.
//Também verifica se há saldo suficiente para tal transação.
public void saque(double valorSaque) {
    
    if(this.saldo >= valorSaque){
        this.saldo -= valorSaque;
        System.out.println("Saque realizado com sucesso!" + "\n"
                + "Saldo atual R$ " + this.saldo + "\n");
    } else {
        System.out.println("Saldo insuficiente!" + "\n"
                + "Saldo disponível R$ " + this.saldo + "\n");
    }  
}

//Impressão de infos ao usuário.
public int getNumeroConta() {
    return numeroConta;
}

public Cliente getCliente() {
    return cliente;
}

public double getSaldo() {
    return saldo;
}
}

Classe Cliente

package sistemabancosimples;

public class Cliente {

private String nome;
private String cpf;

public Cliente() {
    
}

//Mantive Getters e Setters pois o usuário irá informar tais infos.

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getCpf() {
    return cpf;
}

public void setCpf(String cpf) {
    this.cpf = cpf;
}
}

Classe Main

package sistemabancosimples;

import java.util.Scanner;

public class CaixaEletronico {

public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    Cliente cliente = new Cliente();
    Conta conta = new Conta(cliente);
    
    System.out.println("Informe seu nome: ");
    String nome = scanner.nextLine();
    
    System.out.println("Informe seu CPF: ");
    String cpf = scanner.nextLine();
    
    conta.getCliente().setNome(nome);
    conta.getCliente().setCpf(cpf);
    
    //Imprimir as infos da conta para o Usuário
    System.out.println("Cliente: " + conta.getCliente().getNome() + "\n"
                     + "CPF: " + conta.getCliente().getCpf() + "\n"
                     + "Numero Conta: " + conta.getNumeroConta() + "\n"
                     + "Saldo: " + conta.getSaldo() + "\n");
    
    conta.deposito(150);
    conta.saque(100);
    
}
}