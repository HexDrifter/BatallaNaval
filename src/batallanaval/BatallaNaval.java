package batallanaval;

/**
 * La historia comienza un 21 de mayo de 1879 en la ciudad de Iquique...
 * La Esmeralda, la fragata de la armada Chilena navegaba cerca de la costa
 * Era una mañana tranquila en la Rada de Iquique, se reunieron los cinco buques
 * combatientes... Cobandonga, Huascar, Independencia, Lamar y Esmeralda, con cuyas
 * iniciales se formó la palabra ¡Chile!, a pocas horas del amanecer, el acorazado
 * Huascar sorprendió a toda la tripulación Chilena, el capitan Grau al ver a la
 * distancia los barcos Chilenos, izó la bandera del Huascar, el capitan Pratt
 * rápidamente se vistió para el combate, ciñendose la espada al cinto, todo estaba
 * a punto de ocurrir... No volaba una sola ave por los cielos del enfrentamiento,
 * hasta que de improvisto se escuchó... Se escuchó el primer impacto en la
 * Esmeralda, el capitan Pratt le señala emocionado a sus fieles combatientes su
 * famosa arenga... Muchachos, la contienda es desigual, pero ánimo y valor, nunca
 * se ha riado nuestra bandera ante el enemigo, y espero que esta no sea ésta la
 * ocasión de hacerlo, os aseguro que mientras yo viva, esa bandera flameará en su
 * lugar y si yo muero, mis oficiales sabrán cumplir con su deber... Y es luego de
 * ésto, que un gran espolonazo estremece la fragil esmeralda, y sacandose la gorra,
 * Pratt señala... ¡Al abordaje muchachos! y heroicamente señala sobre la cubierta
 * del Huascar, recibiendo un impacto mortal en la frente... Todos son testigos del
 * valor de un hombre que yace sin vida... El capitan Grau observa la escena en
 * profundo silencio, eran las 11:35 de la mañana, y en un instante y para siempre...
 * El capitan Pratt pasaba a la historia de Chile....
 * 
 * https://www.youtube.com/watch?v=rHYhSvyHx4s&t=533
 * 
 * @author HexDrifter
 */
public class BatallaNaval {
    /**
     *
     *
     */
    
    //Generamos la instancia Juego de la clase Game
    public static Game Juego;
    
    public static void main(String[] args) {
        //Inicializamos la instancia
        Juego = new Game();
        
        //Ejecutamos el método NewGame para crear una nueva partida
        Juego.NewGame();
    }
}
