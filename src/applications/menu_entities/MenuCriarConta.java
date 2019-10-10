/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications.menu_entities;

import entities.Banco;
import entities.ContaBancaria;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import javax.swing.JOptionPane;

/**
 *
 * @author Moises
 */
public class MenuCriarConta {

    public void menuCriarConta(Banco bank) {

        int ins = 0, ent = 1, lerInt = 0;
        while (ins < ent) {
            lerInt = Integer.parseInt(JOptionPane.showInputDialog(null, "1- Conta Corrente"
                    + "\n2- Conta Poupança" + "\n3- Retornar ao menu anterior" + "\n\nSelecione a opção: ", "Menu > Criar conta", JOptionPane.QUESTION_MESSAGE));
            if (lerInt == 1) {
                ContaBancaria c = new ContaCorrente();
                bank.inserir(c);
                ins++;
                ent++;
            } else if (lerInt == 2) {
                ContaBancaria c = new ContaPoupanca();
                bank.inserir(c);
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
