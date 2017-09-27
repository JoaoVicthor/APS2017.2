/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model;

import quizenem.controller.ControladorJogo;

/**
 *
 * @author joaov
 */
public class Partida {
    private int[] perguntasJahFeitas = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private int[] rodada  = {1,1};
    
    public void avancarRodada(){
        if(rodada[0] < 3 && rodada[1] < 4){
            if(rodada[1] < 4){
                rodada[1]++;
            }
            else{
                rodada[0]++;
                rodada[1] = 1;
            }
        }
        else{
            finalizarPartida();
        }
    }
    
    public void adicionarPerguntaFeita(int i){
        perguntasJahFeitas[(rodada[0]-1)*4 +  rodada[1]] = i;
    }
    
    public boolean checarPergunta(int i){
        for(int l = 0; l++ <= 11;){
            if(i == perguntasJahFeitas[l]){
                return true;
            }
        }
        return false;
    }
    
}
