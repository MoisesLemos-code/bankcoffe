/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import applications.menu_entities.MenuCriarConta;
import applications.menu_entities.RemoverConta;
import applications.menu_entities.SelecionarConta;
import entities.Banco;
import javax.swing.JOptionPane;

/**
 *
 * @author Moises
 */
public class Executavel_Main {

    public static String itensDoMenu() {
        StringBuilder menu = new StringBuilder();
        String text;
        //Construindo opções do menu principal
        menu.append("1- Criar conta");
        menu.append("\n2- Selecionar conta");
        menu.append("\n3- Remover conta");
        menu.append("\n4- Gerar relatório");
        menu.append("\n5- Finalizar");

        text = menu.toString();

        return text;
    }

    public static String itensDoSubMenu() {
        StringBuilder subMenu = new StringBuilder();
        String text;
        // ---- Sub menu
        subMenu.append("1- Depositar");
        subMenu.append("\n2- Sacar");
        subMenu.append("\n3- Transferir");
        subMenu.append("\n4- Gerar relatório");
        subMenu.append("\n5- Retornar ao menu anterior");

        text = subMenu.toString();

        return text;
    }

    public static void main(String[] args) {
        int ini = 0, fim = 1, command = 0;
          Banco bank = new Banco();
        //Menu principal!
        while (ini < fim) {
  
            command = Integer.parseInt(JOptionPane.showInputDialog(null, itensDoMenu()
                    + "\n\nDigite o comando: ",
                    "Banco da Nova", JOptionPane.INFORMATION_MESSAGE)); 
               
            if (command == 1) { //Criar conta
                MenuCriarConta menu = new MenuCriarConta();
                menu.menuCriarConta(bank);
                ini++;
                fim++;
            } else if (command == 2) { //Selecionar Conta
                SelecionarConta sc = new SelecionarConta();
                sc.SelectConta(bank);
                ini++;
                fim++;
            } else if (command == 3) {
                RemoverConta rc = new RemoverConta();
                rc.removerConta(bank);
                ini++;
                fim++;
            } else if (command == 4) { //Relatório geral
                bank.mostrarDados();
                ini++;
                fim++;
            } else if (command == 5 ) { //Sair
                fim = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Comando inválido, verifique!",
                        "Alerta!", JOptionPane.PLAIN_MESSAGE);
                ini++;
                fim++;
            }

        }

    }
}
