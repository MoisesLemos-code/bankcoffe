/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications.menu_entities;

import static applications.Executavel_Main.itensDoSubMenu;
import entities.Banco;
import entities.ContaBancaria;
import entities.Imprimir;
import entities.Relatorio;
import javax.swing.JOptionPane;

/**
 *
 * @author Moises
 */
public class SelecionarConta {

    public void SelectConta(Banco bank) {

        int c2 = 0, in = 0, en = 1, numero = 0;
        double valor = 0.0;

        numero = Integer.parseInt(JOptionPane.showInputDialog(null, 
                 "\n\nDigite o número da conta: ",
                "Selecionar Conta", JOptionPane.QUESTION_MESSAGE));
        ContaBancaria c = bank.procurarConta(numero);

        if (c != null) {

            while (in < en) {

                c2 = Integer.parseInt(JOptionPane.showInputDialog(null, itensDoSubMenu()
                        + "\n\nDigite o comando: ",
                        "..> Selecionar Conta > Operações", JOptionPane.QUESTION_MESSAGE));
                if (c2 == 1) { //1- Depositar
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null,  "\n\nDigite o valor: ",
                            "..> Operações > Depositar", JOptionPane.QUESTION_MESSAGE));
                    c.depositar(valor);
                    in++;
                    en++;
                } else if (c2 == 2) { //2- Sacar
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null, "\n\nDigite o valor: ",
                            "..> Operações > Sacar", JOptionPane.QUESTION_MESSAGE));
                    c.sacar(valor);
                    in++;
                    en++;
                } else if (c2 == 3) { //3- Transferir
                     valor = Double.parseDouble(JOptionPane.showInputDialog(null, "\n\nDigite o valor: ",
                            "..> Operações > Tranferir", JOptionPane.QUESTION_MESSAGE));
                    c.transferir(valor, c, bank);
                    in++;
                    en++;
                } else if (c2 == 4) { //4- Gerar relatório
                    Relatorio r1 = new Relatorio();
                    r1.gerarRelatorio((Imprimir) c);
                    in++;
                    en++;
                } else if (c2 == 5) { //5- Retornar ao menu anterior
                    en = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Comando inválido, verifique!",
                            "Alerta!", JOptionPane.PLAIN_MESSAGE);
                    in++;
                    en++;
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Conta não identificada, verifique!",
                    "Alerta!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
