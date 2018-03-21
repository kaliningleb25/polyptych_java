package Ex2;

/*
1) Создать приложение с 2 классами - Book, Shoe  и  интерфейсом Product.
		Интерфейс содержит метод whoAmI, который будет реализован в имплементирующих классах.
	2) Определить новый интерфейс Present, расширяющий интерфейс Product и содержащий  метод itCanBePresented(),
	который может возвращать строку.
	3) Объявить 2 новых класса (например Toy, Picture), реализующих  интерфейс Present.
	4) В приложении создать массив объектов Product - (Book, Shoe, Toy, Picture), состоящий из количества элементов, заданного параметром.
	5) Найти в массиве те объекты, которые реализуют интерфейс Present и выполнить для них метод itCanBePresented().

	Вывод должен содержать названия всех продуктов из массива, затем только тех продуктов, которые реализуют интерфейс Present.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static private final Product[] ALL_PRODUCTS = new Product[]{new Book(), new Shoe(), new Toy(), new Picture()};

    public static void main(String[] args) throws IOException {
        int cnt = getCountOfProducts();
        Product[] products = new Product[cnt];
        Random rnd = new Random();
        List<Present> presents = new ArrayList<>();



        for (int i = 0; i < products.length; i++) {
            products[i] = ALL_PRODUCTS[rnd.nextInt(ALL_PRODUCTS.length)]; // Insert into products random product
            products[i].whoAmI();
            if (products[i] instanceof Present) {       // insert into presents product if it implements Present
                presents.add((Present) products[i]);
            }
        }

        for (Present present : presents) {
            System.out.println(present.itCanBePresented());
        }


    }

    private static int getCountOfProducts() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter count of products:");

        return Integer.parseInt(in.readLine());
    }
}
