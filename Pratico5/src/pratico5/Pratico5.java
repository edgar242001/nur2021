/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratico5;


public class Cliente extends JFrame {


    public Cliente() {
        setBounds(600, 300, 280, 400);
        LaminaMarcoCliente milamina = new LaminaMarcoCliente();
        add(milamina);
        setVisible(true);


    }

}
