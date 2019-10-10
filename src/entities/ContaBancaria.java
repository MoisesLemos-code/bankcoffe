package entities;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Moises
 */
public abstract class ContaBancaria {

    protected int num_conta;
    protected double saldo = 0.0;

    public ContaBancaria() {
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {

        if (num_conta >= 0) {
            this.num_conta = num_conta;
        } else {
            JOptionPane.showMessageDialog(null, "Valor inválido para a conta!",
                    "Alerta!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            JOptionPane.showMessageDialog(null, "Valor inválido para o saldo!",
                    "Alerta!", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void transferir(double valor, ContaBancaria c, Banco bank){
        int contaNumero;
        if(valor >= 0){ 
             contaNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "\nDigite o número da conta: ",
                        "Transferir para..", JOptionPane.QUESTION_MESSAGE));
             
            
          ContaBancaria transfer = bank.procurarConta(contaNumero);
        if (transfer != null){
             c.sacar(valor); 
             transfer.depositar(valor);
        }else{
             JOptionPane.showMessageDialog(null, "Conta informada não identificada, verifique!",
                    "Alerta!", JOptionPane.PLAIN_MESSAGE);
        } 
             
        }else{
             JOptionPane.showMessageDialog(null, "Não é possível transferir um valor menor ou igual a zero!",
                        "Falha!", JOptionPane.PLAIN_MESSAGE);
        } 
       
    }

    public abstract void sacar(double valor);

    public abstract void depositar(double valor);
}
