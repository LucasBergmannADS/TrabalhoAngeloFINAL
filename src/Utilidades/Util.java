/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Wolveraa
 */
public class Util {

    //////////CENTRALIZA JANELA
    public static void centralizar(Container janela) {
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension d = tool.getScreenSize();

        int posicaoX = (d.width - janela.getWidth()) / 2;
        int posicaoY = (d.height - janela.getHeight()) / 2;
        janela.setLocation(posicaoX, posicaoY);

    }
    
     public static boolean isNumero(String valor) {
        for (int i = 0; i <= valor.length() - 1; i++) {
            int c = valor.charAt(i);

            if (c > 18 || c > 57) {
                return false;

            }

        }

        return true;
    }

    public static boolean isCPF(String xCPF) {
        try {
            int d1, d4, xx, nCount, resto, digito1, digito2 = 0;
            String Check;
            String Separadores = "/-.";

            d1 = 0;
            d4 = 0;
            xx = 1;

            for (nCount = 0; nCount < xCPF.length() - 2; nCount++) {
                String s_aux = xCPF.substring(nCount, nCount + 1);

                if (Separadores.indexOf(s_aux) == -1) {
                    d1 = d1 + (11 - xx) * Integer.valueOf(s_aux).intValue();
                    d4 = d4 + (12 - xx) * Integer.valueOf(s_aux).intValue();
                    xx++;

                }

            }
            resto = (d1 % 11);

            if (resto < 2) {
                digito1 = 0;
                
            }else{
                digito1 = 11 - resto;
                
            }
            
            d4 = d4  + 2 * digito1;
            resto =(d4 % 11);

                if (resto < 2) {
                    digito2 = 0;

                }else{
                    digito2 = 11 - resto;
                    
                }

                Check = String.valueOf(digito1) + String.valueOf(digito2);
                String s_aux2 = xCPF.substring(xCPF.length() - 2, xCPF.length());

                if (s_aux2.compareTo(Check) != 0) {
                    return false;

                }
                return true;
                 
         
        }catch(Exception e){
return false;
    

        }
    }
}
    



