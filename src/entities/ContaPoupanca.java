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
public class ContaPoupanca extends ContaBancaria implements Imprimir {

    protected double limite = 0.50;

    public ContaPoupanca() {
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        double creditoLimite;
        creditoLimite = this.saldo + (this.saldo * limite);
        if (valor <= creditoLimite) {
            this.saldo -= valor;
            JOptionPane.showMessageDialog(null, "Saque efetuado!",
                    "Mensagem!", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo para saque indiponível!",
                    "Alerta!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        JOptionPane.showMessageDialog(null, "Depósito efetuado!",
                "Mensagem!", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void mostrarDados() {
        DecimalFormat fmt = new DecimalFormat("0.00");

        JOptionPane.showMessageDialog(null, "Número da Conta: " + this.num_conta + "\n"
                + "Saldo: " +"R$"+ fmt.format(this.saldo),
                "Dados da Conta Poupança", JOptionPane.PLAIN_MESSAGE);
    }

}
