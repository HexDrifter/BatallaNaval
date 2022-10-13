package batallanaval;

/**
 *
 * @author HexDrifter
 */
public class GameBoard {
    
    /**
     * Se crea una matriz de tipo char, todo esto con el fin de hacer
     * mas gráfico el juego, es mas fácil visualizar letras que números
     * también crearemos una variable gameOver para definir cuando el jugador
     * se quedó sin barcos
     */
    public char Matriz[][];
    public boolean gameOver;
    
    /**
     * El constructor inicializará la matriz definiendo el tamaño de 10 x 10,
     * también inicializará en false el atributo gameOver y por último
     * convertirá todas las casillas en el símbolo de la virguilla
     */
    public GameBoard(){
        Matriz = new char[10][10];
        gameOver = false;
        TurnToSea();
    }
    
    /**
     * Recorre la matriz completa cambiando los caracteres por la virguilla
     * (tilde de la eñe) la cual asemeja al oceano
     */
    private void TurnToSea(){
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                Matriz[i][j] = '~';
            }
        }
    }
    
    /**
     * Ésta función se utiliza para mostrar la matriz, o sea el tablero
     * tiene algunas decoraciones al rededor, se pretendía que el usuario
     * escribiera las coordenadas en una sola línea de texto, por ejemplo
     * A1 B2 C4
     */
    public void Show(){
        System.out.print("\t");
        for (int i=0;i<10;i++){
            System.out.print((char)(i + 65) + " ");
        }
        System.out.println("");
        for (int i=0;i<10;i++){
            System.out.print((i+1) + "\t");
            for (int j=0;j<10;j++){
                System.out.print(Matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    /**
     * Recibe coordenadas x e y, un tamaño y una orientación, retorna tipo
     * boleano para confirmar la correcta colocación del barco
     * @param x
     * @param y
     * @param size
     * @param isHorizontal
     * @return 
     */
    public boolean InsertShip(int x, int y, int size, boolean isHorizontal){
        System.out.println("Insertando Barco");
        if(isHorizontal == true){
            if((x + size) < 10){
                for(int i = 0;i<=size;i++){
                    if(Matriz[x+i][y]=='B'){
                        System.out.println("Ya hay un barco en la coordenada dada");
                        return false;
                    }
                }
                for(int i =0;i<=size;i++){
                    Matriz[x+i][y] = 'B';
                }
                    return true;
            }
            else{
                System.out.println("El barco se sale del tablero");
                return false;
            }
        }
        else{
            if((y + size) < 10){
                for(int i = 0;i<=size;i++){
                    if(Matriz[x][y+i]=='B'){
                        System.out.println("Ya hay un barco en la coordenada dada");
                        return false;
                    }
                }
                for(int i =0;i<=size;i++){
                    Matriz[x][y+i] = 'B';
                }
                    return true;
            }
            else{
                System.out.println("El barco se sale del tablero");
                return false;
            }
        }
    }
    /**
     * Misma función que la anterior, pero simplificada debido a que
     * se trata de un barco de tamaño 1, no es necesario seleccionar la
     * orientación
     * @param x
     * @param y
     * @return 
     */
    public boolean InsertShip(int x, int y){
        System.out.println("Insertando Barco");
        if(Matriz[x][y]=='B'){
            System.out.println("Ya hay un barco en la coordenada dada");
            return false;
        }
        else{
            Matriz[x][y] = 'B';
            return true;
        }
    }
    
    /**
     * Se comprueba si existe un barco en las coordenadas, de ser así retorna
     * true indicando que hubo impacto, esto sirve para volver a disparar
     * @param x
     * @param y
     * @return 
     */
    public boolean Attack(int x, int y){
        if(Matriz[x][y]=='B'){
            Matriz[x][y] = '#';
            System.out.println("Barco impactado, vuelva a tirar");
            return true;
        }
        else{
            System.out.println("Falló el disparo");
            return false;
        }
    }
    
    /**
     * Se verifica la cantidad de barcos a flote, si el jugador se queda sin
     * barcos, el jugador pierde
     */
    public void VerifyBoard(){
        int contador = 0;
        for(int i = 0; i<10;i++){
            for(int j = 0; j<10;j++){
                if(Matriz[i][j]=='B'){
                    contador++;
                }
            }
        }
        if(contador == 0){
            System.out.println("Toda la flota ha sido eliminada");
            this.gameOver = true;
        }
        else{
            System.out.println(this.gameOver);
            this.gameOver = false;
        }
    }
    
    /**
     * A este punto ya estoy cansado de comentar línea por linea si que los
     * comentarios solo resumen lo que hace cada método
     */
}
