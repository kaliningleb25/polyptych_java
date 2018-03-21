package Ex5;

/*
Создать приложение с 3 потоками для следующей задачи:
		3 работника выполняют следующую работу:
			1-ый копает яму,
			2-ой сажает дерево,
			3-ий подвязывает саженец к кольям.
	Работа идет строго по очереди. Число саженцев задается параметром.
	Выводить на дисплей номер работника и номер саженца.
 */

public class ThreeWorkers {
    public static void main(String[] args) throws InterruptedException {
        Digger digger = new Digger();
        Planter planter = new Planter();
        TieIn tieIn = new TieIn();
        int seedlingCount = 0;

        while (true) {
            Thread fst = new Thread(digger);
            fst.start();

            Thread snd = new Thread(planter);
            snd.start();

            Thread thd = new Thread(tieIn);
            thd.start();

            Thread.sleep(500);
            System.err.println("Саженец #:" + seedlingCount++);
            Thread.sleep(1000);
        }
    }
}

class Digger implements Runnable{

    @Override
    public void run() {
        System.out.println("1");
    }
}

class Planter implements Runnable{

    @Override
    public void run() {
        System.out.println("2");
    }
}

class TieIn implements Runnable{

    @Override
    public void run() {
        System.out.println("3");
    }
}
