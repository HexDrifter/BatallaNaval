package batallanaval;

//Importamos Scanner para poder leer desde el teclado las coordenadas
import java.util.Scanner;

/**
 *
 * @author HexDrifter
 */
public class Game {
    
    /**
     * Creamos dos objetos de la clase GameBoard, los cuales corresponden al
     * jugador 1 y jugador 2 respectivamente
     */
    public GameBoard j1;
    public GameBoard j2;
    
    // Creamos un objeto de tipo Scanner para leer el input del teclado
    Scanner sc = new Scanner(System.in);
    
    /**
     * Creamos las variables fila y columna para las coordenadas, también
     * crearemos la variable endGame para definir el final del juego
     */
    private int fila, columna;
    private boolean endGame;
    
    /**
     * Creamos el constructor e inicializamos endGame en false
     */
    public void Game(){
        endGame = false;
    }
    
    /**
     * El método NewGame se encarga de inicializar a los jugadores 1 y 2 con sus
     * tableros respectivos, posteriormente se seleccionará la dificultad fácil
     * y finalmente se iniciará el juego en un ciclo repetitivo hasta que exista
     * un ganador
     */
    public void NewGame(){
        j1 = new GameBoard();
        j2 = new GameBoard();
        
        EasyMode();
        GameLoop();
    }
    
    /**
     * EasyMode se encarga de posicionar los barcos en el tablero, para la
     * dificultad fácil los barcos de cada bando son, 1 barco de 3 casillas,
     * 2 barcos de 2 casillas y 3 barcos de 1 casilla
     */
    public void EasyMode(){

        
        System.out.println("Para el jugador 1");
        SelectShipPosition(2,j1);
        SelectShipPosition(1,j1);
        SelectShipPosition(1,j1);
        SelectBoatPosition(j1);
        SelectBoatPosition(j1);
        SelectBoatPosition(j1);
        j1.Show();
        System.out.println("Para el jugador 2");
        SelectShipPosition(2,j2);
        SelectShipPosition(1,j2);
        SelectShipPosition(1,j2);
        SelectBoatPosition(j2);
        SelectBoatPosition(j2);
        SelectBoatPosition(j2);
        j2.Show();
    }
    
    /**
     * GameLoop, en resumen se encarga de jugar la partida, siguiendo las reglas
     * del juego, si un jugador acierta con un disparo vuelve a jugar, hasta que
     * falle el disparo, finalmente se contarán cuantos barcos quedan a flote,
     * el jugador que se quede sin barcos pierde
     */
    public void GameLoop(){
        /**
         * Se crea la variable turn, que corresponden al turno de cada
         * jugador, al ser solo dos jugadores, podemos usar el boleano para
         * alternar entre dos estados, también se crea la variable stillAttack
         * para continuar disparando mientras se logre acertar barcos
         */
        
        boolean turn = true;
        boolean stillAttack;
        do{
            /**
             * El primer ciclo do while es para mantener el loop del juego,
             * mientras que el ciclo if se utiliza para ejecutar el código para
             * ambos jugadores alternado entre ellos
             */
            if(turn){
                System.out.println("Turno Jugador 1");
                do{
                    /**
                     * En éste ciclo do while se solicita que el jugador escriba
                     * las coordenadas para atacar, mientras acierte volverá a
                     * jugar
                     */
                    System.out.println("Ingrese un valor para Fila entre 1 y 10");
                    fila = verifyValue();
                    System.out.println("Ingrese un valor para Columna entre 1 y 10");
                    columna = verifyValue();
                    stillAttack = j2.Attack(fila, columna);
                    j2.VerifyBoard();
                    if(j2.gameOver) stillAttack = false;
                }while(stillAttack);
                //con esta línea de código se pasará el turno al otro jugador
                turn = false; 
                j2.Show();
            }
            else{//el caso else es el mismo código pero para el jugador 2
                System.out.println("Turno Jugador 2");
                do{
                    System.out.println("Ingrese un valor para Fila entre 1 y 10");
                    fila = verifyValue();
                    System.out.println("Ingrese un valor para Columna entre 1 y 10");
                    columna = verifyValue();
                    stillAttack = j1.Attack(fila, columna);
                    j1.VerifyBoard();
                    if(j1.gameOver) stillAttack = false;
                }while(stillAttack);
                turn = true;
                j1.Show();
            }
            
            /**
             * En estas sentencias se verifica si algún jugador pierde
             */
            if(j1.gameOver == true){
                System.out.println("Jugador 1 Pierde");
                endGame = true;
            }
            if(j2.gameOver == true){
                System.out.println("Jugador 2 Pierde");
                endGame = true;
            }
        }while(!endGame);
        System.out.println("Partida Finalizada");
    }
    
    /**
     * En la función verifyValue se solicita ingresar un valor entre 1 y 10,
     * si el valor dado se escapa de ese rango se reitera que se vuelva a
     * ingresar el valor, así hasta que pueda dar un valor de retorno,
     * finalmente por cardinalidad el valor disminuirá en 1 para adaptarse
     * @return valor numérico
     */
    
    public int verifyValue(){
        int numValue;
        do{
            numValue = sc.nextInt();
            if(numValue >10 || numValue <1)
                System.out.println("Intente nuevamente");
        }while(numValue >10 || numValue <1);
        numValue--;
        return numValue;
    }
    
    /**
     * Esta función se utiliza para seleccionar entre las dos posibles
     * orientaciones, por defecto se seleccionará horizontal
     * @return 
     */
    public boolean setOrientation(){
        System.out.println("Seleccione una orientación para el barco");
        System.out.println("1 para Horizontal, 2 para vertical");
        switch(sc.nextInt()){
            case 1:
                return false;
            case 2:
                return true;
            default:
                return false;
        }
    }
    
    /**
     * Esta función recibe un tamaño de barco disminuido en 1, como también
     * un objeto del tipo GameBoard, también se solicitará coordenadas y
     * consultará la orientación en la que se desea colocar el barco, si
     * el barco se sale del tablero o intersecta con otro barco, se volverá
     * a preguntar por otra posición y orientación
     * @param size
     * @param Player 
     */
    public void SelectShipPosition(int size, GameBoard Player){
        boolean errorInsert, orientation;
        System.out.println("Ingrese Coordenadas para el Barco de tamaño " + (size+1));
        Player.Show();
        do{
            System.out.println("Ingrese un valor para Fila entre 1 y 10");
            fila = verifyValue();
            System.out.println("Ingrese un valor para Columna entre 1 y 10");
            columna = verifyValue();
            orientation = setOrientation();
            errorInsert = Player.InsertShip(fila, columna, size, orientation);
            if(!errorInsert) System.out.println("Intente Nuevamente");
        }while(!errorInsert);
    }
    
    /**
     * Ésta función hace lo mismo que la anterior, pero con un tamaño de barco
     * de solo una casilla y sin necesidad de consultar la orientación
     * @param Player 
     */
    public void SelectBoatPosition(GameBoard Player){
        boolean errorInsert;
        System.out.println("Ingrese Coordenadas para el Barco de tamaño 1");
        Player.Show();
        do{
            System.out.println("Ingrese un valor para Fila entre 1 y 10");
            fila = verifyValue();
            System.out.println("Ingrese un valor para Columna entre 1 y 10");
            columna = verifyValue();
            errorInsert = Player.InsertShip(fila, columna);
            if(!errorInsert) System.out.println("Intente Nuevamente");
        }while(!errorInsert);
    }
}
