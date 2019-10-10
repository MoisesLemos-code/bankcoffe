/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Moises
 */
public class Banco implements Imprimir {

    List<ContaBancaria> lista = new ArrayList<>();

    public void inserir(ContaBancaria c) {
        int num = 0;
        double valor = 0.0;

        num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Número da Conta: ",
                "Número da Conta", JOptionPane.PLAIN_MESSAGE));
        valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o Saldo da Conta: ",
                "Saldo da Conta", JOptionPane.PLAIN_MESSAGE));
        c.setNum_conta(num);
        c.setSaldo(valor);
        lista.add(c);
        JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso!",
                "Sucesso!", JOptionPane.PLAIN_MESSAGE);
    }

    public void remover(ContaBancaria c) {

        lista.remove(c);
        JOptionPane.showMessageDialog(null, "Conta removida com sucesso!",
                "Sucesso!", JOptionPane.PLAIN_MESSAGE);
    }

    public ContaBancaria procurarConta(int numConta) {

        for (ContaBancaria cc : lista) {

            if (cc.getNum_conta() == numConta) {
                return cc;
            }
        }

        return null;
    }

    @Override
    public void mostrarDados() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat fmt = new DecimalFormat("0.00");
        int inc = 1;
        for (ContaBancaria c : lista) {
            //Imprimir tudo junto
            sb.append("---- Conta nº" + inc + " ----\n");
            sb.append("Numero da Conta: " + c.getNum_conta());
            sb.append("\nSaldo: " + "R$" + fmt.format(c.getSaldo()));
            sb.append("\n------------------------\n");
            inc++;
        }
        //Imprimir!!
        JOptionPane.showMessageDialog(null, sb.toString(), "RELATÓRIO GERAL DE CONTAS BANCÁRIAS",
                JOptionPane.PLAIN_MESSAGE);

    }
}
