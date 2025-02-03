package com.sistematransaccional.Logica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class LoginLogic {
    private static String  user;
    private static String password;

    public LoginLogic (String user, String password) {
        LoginLogic.user = user;
        LoginLogic.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isAutorized(){
       String credenciales = this.user + " "+ this.password;
       //CAMBIAR LA DIRECCION SI QUIEREN PROBAR SEGUN SU 
       String filePath = "C:\\Users\\LabP3E005\\Desktop\\Sistema\\src\\com\\sistematransaccional\\Logica\\UsuariosAutorizados.txt";
       
       boolean state =false;
       try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
          String line; 
            while(( line = reader.readLine()) != null){
              if(credenciales.equals(line)){
                  state = true;
              }
          }
        }catch(FileNotFoundException fnfe){
            System.out.println("File not found");
        
        } catch (IOException ex) { 
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }
}
