import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задание 1.1
        System.out.println("Задание 1.1 - создание точек");
        Point point1 = new Point(2.5, 3.7);
        Point point2 = new Point(-1.0, 4.2);
        Point point3 = new Point(0, -5.8);

        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);

        // Задание 2: Создание трех имен
        System.out.println("Задание 1.2 - создание имен");
        Name name1 = new Name("", "Клеопатра", "");
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name name3 = new Name("Маяковский", "Владимир", "");

        System.out.println("Имя 1: " + name1);
        System.out.println("Имя 2: " + name2);
        System.out.println("Имя 3: " + name3);

        System.out.println("\nЗадание 2.1 - линии");

        // 1. Линия 1 с началом в т. {1;3} и концом в т.{23;8}
        // Создаем точки отдельно, как сущности
        Point line1Start = new Point(1, 3);
        Point line1End = new Point(23, 8);
        Line line1 = new Line(line1Start, line1End);
        System.out.println("Линия 1: " + line1);

        // 2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25
        Point line2Start = new Point(5, 10);
        Point line2End = new Point(25, 10);
        Line line2 = new Line(line2Start, line2End);
        System.out.println("Линия 2: " + line2);

        // 3. Линия 3, которая начинается там же, где начинается линия 1,
        // и заканчивается там же, где заканчивается линия 2
        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println("Линия 3: " + line3);

        // 4. Изменение координаты первой и второй линий через их точки
        System.out.println("\nИзменение координат линий 1 И 2 ");

        line1.getStart().setX(0);
        line1.getStart().setY(0);
        line1.getEnd().setX(20);
        line1.getEnd().setY(5);

        line2.getStart().setX(0);
        line2.getStart().setY(15);
        line2.getEnd().setX(30);
        line2.getEnd().setY(15);

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);

        // 5. Изменяем координаты первой линии так, чтобы не изменились координаты третьей линии
        System.out.println("\nИзменение линии 1");

        Point newLine1Start = new Point(10, 10);
        Point newLine1End = new Point(30, 30);
        line1.setStart(newLine1Start);
        line1.setEnd(newLine1End);

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 3: " + line3);


        System.out.println("\nЗадание 3.3 - города");

        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");
        City cityE = new City("E");
        City cityF = new City("F");

        // A -> B(5), F(1), D(6)
        cityA.addPath(cityB, 5);
        cityA.addPath(cityF, 1);
        cityA.addPath(cityD, 6);

        // B -> A(5), C(3)
        cityB.addPath(cityA, 5);
        cityB.addPath(cityC, 3);

        // F -> B(1), E(2)
        cityF.addPath(cityB, 1);
        cityF.addPath(cityE, 2);

        // C -> B(3), D(4)
        cityC.addPath(cityB, 3);
        cityC.addPath(cityD, 4);

        // D -> C(4), E(2), A(6)
        cityD.addPath(cityC, 4);
        cityD.addPath(cityE, 2);
        cityD.addPath(cityA, 6);

        // E -> F(2), D(2)
        cityE.addPath(cityF, 2);
        cityE.addPath(cityD, 2);

        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);
        System.out.println(cityE);
        System.out.println(cityF);

        System.out.println("\nЗадание 5 - обновленные города");
        //  Создание города только с названием
        City simpleCity = new City("А");
        System.out.println("1. Город только с названием: " + simpleCity);

        //  Создание города с названием и готовым набором связей
        List<City> connectedCities = new ArrayList<>();
        List<Integer> costs = new ArrayList<>();

        // Добавляем связи
        connectedCities.add(cityB);
        costs.add(10);
        connectedCities.add(cityC);
        costs.add(15);

        // Создаем город с готовыми связями
        City advancedCity = new City("А", connectedCities, costs);
        System.out.println("2. Город с готовыми связями: " + advancedCity);



        System.out.println("\nЗадание 5.5 - дроби");
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);
        Fraction f4 = new Fraction(5, 6);
        Fraction f5 = new Fraction(2);

        System.out.println("Созданные дроби:");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f4 = " + f4);
        System.out.println("f5 = " + f5);

        // 2. Примеры
        System.out.println("\nПримеры операций:");

        // Сложение дробей
        Fraction sumResult = f1.add(f2);
        System.out.println(Fraction.operationToString(f1, "+", f2, sumResult));

        // Вычитание дробей
        Fraction minusResult = f3.minus(f4);
        System.out.println(Fraction.operationToString(f3, "-", f4, minusResult));

        // Умножение дробей
        Fraction multiplyResult = f1.multiply(f2);
        System.out.println(Fraction.operationToString(f1, "*", f2, multiplyResult));

        // Деление дробей
        Fraction divResult = f3.div(f4);
        System.out.println(Fraction.operationToString(f3, "/", f4, divResult));

        // Операции с целыми числами
        System.out.println(Fraction.operationToString(f1, "+", 2, f1.add(2)));
        System.out.println(Fraction.operationToString(f2, "-", 1, f2.minus(1)));
        System.out.println(Fraction.operationToString(f3, "*", 3, f3.multiply(3)));
        System.out.println(Fraction.operationToString(f4, "/", 2, f4.div(2)));

        // 4. Вычисление f1.sum(f2).div(f3).minus(5)
        System.out.println("\nВычисление f1.add(f2).div(f3).minus(5):");
        Fraction complexResult = f1.add(f2).div(f3).minus(5);
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f1.add(f2) = " + f1.add(f2));
        System.out.println("f1.add(f2).div(f3) = " + f1.add(f2).div(f3));
        System.out.println("f1.add(f2).div(f3).minus(5) = " + complexResult);


    }
}

