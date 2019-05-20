/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

    import java.awt.*;
    import javax.swing.*; 

/**
 *
 * @author Kuba
 */

 /** zbiór zmiennych i metod potrzebnych do zbudowania okien menu i gry
  a także do odtwarzania komunikatów o wygranej/przegranej
  */
public class gui{
    /**przycisk play*/
    private static JButton play;
    /**przycisk exit*/
    private static JButton exit;
    /**okno menu*/
    private static JFrame menuWindow;
    /**okno gry*/
    private static JFrame gameWindow;

    protected static JFrame getFrame() {
        return menuWindow;
    } 
    protected static JButton getPlay() {
        return play;
    }
    protected static JButton getExit() {
        return exit;
    }
    protected static JFrame getGameWindow() {
        return gameWindow;
    }    
    /**tworzy okno menu*/    
    protected static void menuWindowCreator() {
        //ta klasa jest potrzebne do pobierania obrazków
        Class<gui> klasa = gui.class;
        Icon icon = new ImageIcon(klasa.getResource("images/torreadorPlaque.png"));
       //Creating the Frame
        menuWindow = new JFrame("TorreadorGame");
        menuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuWindow.setFocusable(true);
        menuWindow.setSize(400,290);
        menuWindow.setLocationRelativeTo(null);
        menuWindow.setResizable(false);
        
        //Creating the panel at bottom and adding components
        JPanel exitPanel = new JPanel();
        JPanel playPanel=new JPanel();  // the panel is not visible in output
        JLabel banner = new JLabel(icon);
        play = new JButton("PLAY");
        exit = new JButton("EXIT");
        play.setPreferredSize(new Dimension(200,100));
        exit.setPreferredSize(new Dimension(200,50));
        playPanel.setBackground(Color.green);
        exitPanel.setBackground(Color.red);
        playPanel.add(play); // Components Added using Flow Layout
        exitPanel.add(exit); // Components Added using Flow Layout  
        
        //Adding Components to the frame.
        menuWindow.getContentPane().add(BorderLayout.CENTER, playPanel);
        menuWindow.getContentPane().add(BorderLayout.SOUTH, exitPanel);
        menuWindow.getContentPane().add(BorderLayout.NORTH, banner);
        menuWindow.setVisible(true);
            
        controller.menuControl control = new controller.menuControl();
        play.addActionListener(control);
        exit.addActionListener(control);

        sound.playSound(1);
    }
    /**tworzy okno gry*/ 
    protected static void gameWindowCreator() {

        gameWindow = new JFrame("TorreadorGame");      
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        gameWindow.setSize(1000,700);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setResizable(false);
        gameWindow.setFocusable(true);
        gameWindow.setVisible(true);
    }

    /**wyświetla komunikat o przegranej*/   
    protected static void youLost(){
        JFrame l = new JFrame("Lost");
        JOptionPane.showMessageDialog(l, "You lost");
    }
    /**wyświetla komunikat o wygranej*/
    protected static void youWon(){
        JFrame l = new JFrame("Won");
        JOptionPane.showMessageDialog(l, "The Winner takes it all!!!");
    }   
}




    

