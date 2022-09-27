import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int SIZE = 8;
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotatedColors = new int[SIZE][SIZE];
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        for (int row = 0; row < SIZE; row++) {
            for (int cell = 0; cell < SIZE; cell++) {
                colors[row][cell] = random.nextInt(256);
            }
        }

        matrix(colors);
        while (true) {
            System.out.println(
                            """
                            Введите угол поворота (кратный 90°) или введите 'end'
                            Знаком '-' или '+' можно задать направление вращения
                            """
            );
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            int menu = Integer.parseInt(input);
            switch (menu) {
                case +90, -270 -> {
                    for (int row = 0; row < rotatedColors.length; row++) {
                        for (int cell = 0; cell < rotatedColors[row].length; cell++) {
                            rotatedColors[row][cell] = colors[SIZE - 1 - cell][row];
                        }
                    }
                    matrix(rotatedColors);
                }
                case +180, -180 -> {
                    for (int row = 0; row < rotatedColors.length; row++) {
                        for (int cell = 0; cell < rotatedColors[row].length; cell++) {
                            rotatedColors[row][cell] = colors[SIZE - 1 - row][SIZE - 1 - cell];
                        }
                    }
                    matrix(rotatedColors);
                }
                case +270, -90 -> {
                    for (int row = 0; row < rotatedColors.length; row++) {
                        for (int cell = 0; cell < rotatedColors[row].length; cell++) {
                            rotatedColors[row][cell] = colors[cell][SIZE - 1 - row];
                        }
                    }
                    matrix(rotatedColors);
                }
                default -> System.out.println("На этот угол матрицу повернуть невозможно");
            }
        }
    }

    public static void matrix(int[][] SIZE) {
        for (int[] row : SIZE) {
            for (int cell : row) {
                System.out.format("%4d", cell);
            }
            System.out.println();
        }
    }
}