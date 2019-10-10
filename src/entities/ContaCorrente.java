package entities;

import java.text.DecimalFormat;
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
public class ContaCorrente extends ContaBancaria implements Imprimir {

    protected double taxaDeOperacao = 0.01;

    public ContaCorrente() {
    }

    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public void sacar(double valor) {
        double calc;
        calc = this.saldo * taxaDeOperacao;
        if (valor <= this.saldo) {
            this.saldo -= valor + calc;
            JOptionPane.showMessageDialog(null, "Saque efetuado!",
                    "Mensagem!", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo para saque indiponível!",
                    "Alerta!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void depositar(double valor) {
        double calc;
        calc = this.saldo * taxaDeOperacao;
        this.saldo += valor - calc;
        JOptionPane.showMessageDialog(null, "Depósito efetuado!",
                "Mensagem!", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void mostrarDados() {
        DecimalFormat fmt = new DecimalFormat("0.00");
        JOptionPane.showMessageDialog(null, "Número da Conta: " + this.num_conta + "\n"
                + "Saldo: " +"R$"+ fmt.format(this.saldo),
                "Dados da Conta Corrente", JOptionPane.PLAIN_MESSAGE);
    }

}
