/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications.menu_entities;

import entities.Banco;
import entities.ContaBancaria;
import javax.swing.JOptionPane;

/**
 *
 * @author Moises
 */
public class RemoverConta {

    public void removerConta(Banco bank) {
        int ins = 0, ent = 1, numero = 0;

        numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Número da Conta: ",
                "Remover conta bancária", JOptionPane.PLAIN_MESSAGE));
        
        ContaBancaria c = bank.procurarConta(numero);
        
         if (c != null) {
                bank.remover(c);
         }else{
              JOptionPane.showMessageDialog(null, "Conta não identificada, verifique!",
                    "Alerta!", JOptionPane.PLAIN_MESSAGE);
         }
    }
}
