package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Guia o agente na direção do alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Buscar extends AlgoritmoMovimentacao {

    private static final char NOME = 's';

    public Buscar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Buscar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        
        Vector3 posicao = agente.posicao;
        Vector3 objetivo = super.alvo.getObjetivo();
        
          output.velocidade = objetivo.sub(posicao).clamp(0.0f, maxVelocidade);
          
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.S;
    }
}
