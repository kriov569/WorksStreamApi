// 1.Создай файл со строками вида (x:1,y:5)-(x:2,y:6), описывающими отрезки на плоскости. Можно использовать другой формат.
// 2. Прочитай файл.
// 3. Преврати его в поток строк.
// 4. Найди в нем длину самого длинного отрезка одной конструкцией на потоках.
// 5. Выведи длину в поток вывода.
// 6. Отправь на проверку код.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("str.txt"))) {
            int longestLength = reader.lines()
                    .mapToInt(Main::calculateStrLength)
                    .max()
                    .orElse(0);

            System.out.println("Длина самого длинного отрезка: " + longestLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateStrLength(String str) {
        String[] points = str.split("-");
        String[] startPoint = points[0].substring(1, points[0].length() - 1).split(",");
        String[] endPoint = points[1].substring(1, points[1].length() - 1).split(",");

        int startX = Integer.parseInt(startPoint[0].split(":")[1]);
        int startY = Integer.parseInt(startPoint[1].split(":")[1]);
        int endX = Integer.parseInt(endPoint[0].split(":")[1]);
        int endY = Integer.parseInt(endPoint[1].split(":")[1]);

        return (int) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    }
}