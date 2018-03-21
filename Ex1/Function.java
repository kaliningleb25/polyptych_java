package Ex1;

/*
Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
Размеры отрезка и параметры задаются в качестве параметров в консоли.
Результат представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие значения функции:

	F(x) = tg(2x) - 3
 */

import java.io.*;

public class Function {
    static int a, b, h;
    BufferedReader in;

    private Function() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a:");
        a = Integer.parseInt(in.readLine());
        System.out.println("Enter b:");
        b = Integer.parseInt(in.readLine());
        System.out.println("Enter h:");
        h = Integer.parseInt(in.readLine());

        if (a > b) {
            throw new IllegalArgumentException("'a' must be less than 'b'");
        }
        if (h > b - a) {
            throw new IllegalArgumentException("'h' must be less than 'b' - 'a'");
        }
    }

    private String func() {
        StringBuilder sb = new StringBuilder();
        sb.append("Argument:\n");
        sb.append("Value of Function:\n");

        for (int x = a; x < b; x+=h) {
            double res = Math.tan(2 * x) - 3;
            sb.append(x);
            sb.append("        ");
            sb.append(res);
            sb.append("\n");
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) throws IOException {
        Function function = new Function();
        System.out.println(function.func());
    }


}
