package applications;

import entities.ContaBancaria;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import entities.Imprimir;
import entities.Relatorio;
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
public class Executar_Questao_06 {

    public static void insereConta(ContaBancaria c) {
        c.setNum_conta(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Número da Conta: ",
                "Número da Conta", JOptionPane.PLAIN_MESSAGE)));
        c.setSaldo(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o Saldo da Conta: ",
                "Saldo da Conta", JOptionPane.PLAIN_MESSAGE)));
    }

    public static void operacao(ContaBancaria c) {
        int ins = 0, ent = 1, lerInt;
        double valor;
        DecimalFormat fmt = new DecimalFormat("0.00");   
      
        while (ins < ent) {

            lerInt = Integer.parseInt(JOptionPane.showInputDialog(null,"Conta: "+ c.getNum_conta()+ 
                    " | Saldo: "+ fmt.format(c.getSaldo())+
                    "\n\n1- Saque" + "\n2- Depósito" + "\n3- Gerar relatório" + "\n4- Sair!"
                    + "\nSelecione a opção: ", "Menu - Operação", JOptionPane.QUESTION_MESSAGE));
            if (lerInt == 1) {
                valor = Double.parseDouble(JOptionPane.showInputDialog(null, "\nDigite o valor: ",
                        "Menu - Operação > Saque", JOptionPane.QUESTION_MESSAGE));
                c.sacar(valor);
                ins++;
                ent++;
            } else if (lerInt == 2) {
                valor = Double.parseDouble(JOptionPane.showInputDialog(null, "\nDigite o valor: ",
                        "Menu - Operação > Depósito", JOptionPane.QUESTION_MESSAGE));
                c.depositar(valor);
                ins++;
                ent++;
            } else if (lerInt == 3) {
                Relatorio r1 = new Relatorio();
                r1.gerarRelatorio((Imprimir) c);
                ins++;
                ent++;
            } else if (lerInt == 4) {
                ent = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Comando inválido, verifique!",
                        "Alerta!", JOptionPane.PLAIN_MESSAGE);
                ins++;
                ent++;
            }

        }
    }

    public static void main(String[] args) {
        //MENU PRINCIPAL
        int ins = 0, ent = 1, lerInt;
        while (ins < ent) {
            lerInt = Integer.parseInt(JOptionPane.showInputDialog(null, "1- Conta Corrente"
                    + "\n2- Conta Poupança" + "\n3- Sair!" + "\nSelecione a opção: ", "Menu - Executar 01", JOptionPane.QUESTION_MESSAGE));
            if (lerInt == 1) {
                ContaCorrente c = new ContaCorrente();
                insereConta(c);
                operacao(c);

                ins++;
                ent++;
            } else if (lerInt == 2) {
                ContaPoupanca c = new ContaPoupanca();
                insereConta(c);
                operacao(c);

                ins++;
                ent++;
            } else if (lerInt == 3) {
                ent = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Comando inválido, verifique!",
                        "Alerta!", JOptionPane.PLAIN_MESSAGE);
                ins++;
                ent++;
            }

        }

    }
}
