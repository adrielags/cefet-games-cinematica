/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Adriel
 */
public class Chegar extends AlgoritmoMovimentacao {
        private static final char NOME = 'a';
        private float raio = 30f;
        private float timeToTarget= 0.2f;

    public Chegar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Chegar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 posicao = new Vector3(agente.posicao);
        Vector3 objetivo = new Vector3(super.alvo.getObjetivo());
        
        output.velocidade = objetivo.sub(posicao).clamp(0.0f, maxVelocidade);
        
        if(output.velocidade.len() < raio){     
            output.velocidade.setZero();
            return output;
        }
        
        output.velocidade = output.velocidade.scl(1/timeToTarget);
        
        if(output.velocidade.len() > maxVelocidade){
            output.velocidade = output.velocidade.nor().scl(maxVelocidade); 
        }
        agente.olharNaDirecaoDaVelocidade(output.velocidade);
        output.rotacao = 0;     
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.A;
    }
    
}
