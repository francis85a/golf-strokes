package edu.teamrocket.golfstrokes;

import java.util.Arrays;
import java.util.List;

import edu.teamrocket.golfstrokes.estrategias.*;



/**
 * Examen de Programación: Sistema de Puntuación de Golf
 * 
 * Desarrollar un sistema que calcule las puntuaciones de un partido de golf
 * siguiendo las modalidades "Stroke Play" y "Stableford".
 * 
 * REQUISITOS:
 * 
 * 1. Implementar las siguientes clases:
 *    - Player: almacena iniciales, handicap, score y puntos Stableford
 *    - ScoreCard: gestiona hasta 4 jugadores (A, B, C, D), lista de hoyos y campo
 *    - Hole: representa un hoyo con su número y par
 *    - StrokePlay: implementa la modalidad de juego stroke play (suma de golpes)
 *    - Stableford: implementa la modalidad de juego Stableford (puntos según diferencia con el par)
 *    - StablefordSystem: enum que representa los diferentes resultados posibles
 * 
 * 2. Implementar el patrón Strategy para las modalidades de juego mediante:
 *    - Interfaz GolfPlay
 *    - Clase ComputeCard que aplica la estrategia seleccionada
 * 
 * 3. Sistema de puntuación Stableford:
 *    - Double Bogey (≥2 sobre par): -3 puntos
 *    - Bogey (1 sobre par): -1 punto
 *    - Par: 0 puntos
 *    - Birdie (1 bajo par): 2 puntos
 *    - Eagle (2 bajo par): 5 puntos
 *    - Albatross (3 bajo par): 8 puntos
 * 
 * 4. Requisitos técnicos:
 *    - Usar Optional para la gestión de jugadores
 *    - Implementar el principio Open/Closed
 *    - Utilizar Streams para el procesamiento de datos
 * 
 * El código siguiente muestra el comportamiento esperado del sistema.
 * La salida por consola debe coincidir con los comentarios indicados.
 */
public class App {

    public static void main(String[] args) {

        /*
         * Crea el torneo reutilizando la clase Course proporcionada.
         */
        Course augusta  = new Course(); 
        
        /*
         * Crea el jugador/a A.
         * Reutiliza la clase Course para añadir el registro de recorrido
         * del jugador A con sus golpes en cada hoyo.
         */
        Byte[] coursePlayerA = {4, 5, 3, 4, 4, 4, 4, 3, 5, 5, 4, 4, 3, 4, 4, 3, 4, 4}; // 71
        Player playerA = new Player("MJ", (byte) 0);
        augusta.addPlayerCourse(playerA, coursePlayerA);

        /*
         * Crea el jugador/a B.
         * Reutiliza la clase Course para añadir el registro de recorrido
         * del jugador B con sus golpes en cada hoyo.
         */
        Byte[] coursePlayerB = {4, 5, 3, 4, 4, 4, 5, 3, 5, 5, 4, 4, 3, 5, 4, 3, 4, 4}; // 73
        Player playerB = new Player("JS", (byte) 0);
        augusta.addPlayerCourse(playerB, coursePlayerB);

        /*
         * Crea la clase ScoreCard
         * y añade a la tarjeta los jugadores A y B
         * Establece en la tarjeta el Course "Augusta".
         */
        ScoreCard scoreCard = new ScoreCard();
        scoreCard.setPlayerA(playerA);
        scoreCard.setPlayerB(playerB);
        scoreCard.setPlayersCourse(augusta);

        /*
         * Calcula el total strokes de los jugadores
         * en la modalidad stroke play.
         * Crea la modalidad de juego StrokePlay.
         * En esta modalidad el total de strokes 
         * de un jugador es la suma total de golpes
         * de su recorrido.
         * Implementa el patron strategy.
         * Crea la clase ComputeCard que reciba la tarjeta
         * y la modalidad o estrategia de juego y calcule
         * el total de strokes de cada jugador.
         * Toda la lógica se encuentra en la clase StrokePlay.
         */
        GolfPlay strokePlay = new StrokePlay();
        ComputeCard computeStrokePlay = new ComputeCard(scoreCard, strokePlay);

        /*
         * Guarda en la tarjeta el total de strokes
         * de cada jugador.
         */
        computeStrokePlay.compute();
        /*
         * Muestra por CLI iniciales, strokes y stableford points (0)
         * de cada jugador.
         */
        System.out.println("\n\t ##### STROKE PLAY #####");
        System.out.println(playerA);
        System.out.println("\nCourse A:\s" + Arrays.toString(scoreCard.getPlayerCourse(playerA)));
        System.out.println(playerB);
        System.out.println("\nCourse B:\s" + Arrays.toString(scoreCard.getPlayerCourse(playerB)));


        /*
         * Crea la colección de hoyos
         * y añadelos a la tarjeta.
         * Para cada hoyo se indica su par.
         */
        Byte[] whiteYardsPar = {4, 5, 3, 4, 4, 4, 4, 3, 5, 5, 4, 4, 3, 4, 4, 3, 4, 4}; // 71
        scoreCard.addHoles(whiteYardsPar);
        /*
         * Muesta en CLI el total de hoyos de la tarjeta.
         */
        System.out.println("\n\t ##### HOYOS #####");
        System.out.println("\nNumero de hoyos: " + scoreCard.getNumHoles()); // 18
        System.out.println("\nhole - par");
        scoreCard.getHoles().forEach(System.out::println);

        /*
         * 
         * Crea un tipo enumerado para el sistema Stableford.
         * 
         * Los valores del enumerado representan los diferentes resultados 
         * posibles en golf con sus puntos correspondientes en el sistema Stableford:
         * 
         * DOUBLE_BOGEY: -3 puntos, 2 o más golpes sobre par
         * BOGEY: -1 punto, 1 sobre par
         * PAR: 0 puntos
         * BIRDIE: 2 puntos, 1 bajo par
         * EAGLE: 5 puntos, 2 bajo par
         * ALBATROSS: 8 puntos, 3 bajo par
         * 
         * En este sistema, gana el jugador que sume mas puntos.
         */
        System.out.println("\n\t ##### STABLEFORD SYSTEM #####");
        System.out.println("\nBirdie: " + StablefordSystem.BIRDIE.getPoints()); // 2
        System.out.println("Eagle: " + StablefordSystem.BOGEY.getPoints());  // -1
        System.out.println();
        List.of(StablefordSystem.values()).forEach(System.out::println);

        /*
         * Calcula los puntos que obtienen los jugadores A y B
         * en la modalidad Stableford.
         * Implementa el patron strategy.
         * Crea la modalidad de juego Stableford.
         * La clase ComputeCard recibe la tarjeta
         * y la modalidad o estrategia de juego StableFordPlay 
         * y calcula los puntos de cada jugador.
         * Toda la lógica se encuentra en la clase Stableford.
         */
        GolfPlay stablefordPlay = new Stableford();
        ComputeCard computeStableford = new ComputeCard(scoreCard, stablefordPlay);
        computeStableford.compute();
        /*
         * Muestra en CLI los puntos totales
         * de los jugadores A y B
         */
        System.out.println("\n\t ##### STABLEFORD POINTS  #####");
        System.out.println(playerA); // points: 0
        System.out.println(playerB); // points: -2

        /*
         * Crea el jugador C y añadelo a la tarjeta.
         */

        Byte[] coursePlayerC = {2, 2, 2, 4, 5, 6, 7, 3, 5, 5, 4, 4, 3, 4, 4, 3, 4, 4}; // 71 strokes, 8 points
        Player playerC = new Player("Meeseeks", (byte) 0);
        scoreCard.setPlayerC(playerC);

        /* Añade su recorrido a Course.
         * Reutiliza la clase Course.
         */
        augusta.addPlayerCourse(playerC, coursePlayerC);

        /*
         * Calcula su total de strokes segun la modalidad Stroke Play
         * y sus puntos según la modalidad Stableford.
         * Muestra el jugador por consola.
         */
        computeStrokePlay.compute();
        computeStableford.compute();
        
        System.out.println(playerC); // total points: 8
    }

}