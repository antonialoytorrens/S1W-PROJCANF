/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.utilitats;

/**
 *
 * @author antonialoy
 */
public abstract class Validacions {
    public static boolean validaCadena(String cadena) {
        return cadena != null && !"".equals(cadena.trim());
    }

    public static boolean validaInt(Integer i) {
		return (i != null && i > 0);
    }
    
    public static boolean validaDouble(double d) {
		return (d > 0);
    }
}
