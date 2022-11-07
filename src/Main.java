import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        //1часть
        List<String> books = new ArrayList<>();
        books.add("Сказки");
        books.add("Баллады");
        books.add("Притчи");
        books.add("Азбука");
        books.add("Словарь");
        books.add("Геометрия");
        List<ArrayList<String>> ret = getShelves(books);
        ret.forEach(System.out::println);


        //2 часть
        try {
            testException(5);
            testException(-112);
        } catch (MyException ex1) {
            System.out.println(ex1);
        }
    }

    //считаем число книг на каждую полку
    public static int getBooks(int books, int shelves) {
        int oneShelf = books / shelves;
        if (oneShelf * shelves < books)
            oneShelf++;
        return oneShelf;
    }

    //сортируем и кладем последовательно на полки
    public static List<ArrayList<String>> getShelves(List<String> books) {
        books = books.stream()
                .sorted()
                .collect(Collectors.toList());
        List<ArrayList<String>> shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }
        int ind = 0;
        int shelfInd = 0;

        while (ind < books.size()) {
            int perShelf = getBooks(books.size() - ind, shelves.size() - shelfInd);
            for (int i = 0; i < perShelf; i++) {
                shelves.get(shelfInd).add(books.get(ind));
                ind++;
            }
            shelfInd++;
        }
        return shelves;
    }

    //задание метод проверки числа на минус, выбрасываем свое предупреждение
    static void testException(int x) throws MyException {
        if (x < 0) {
            throw new MyException(x);
        } else {
            System.out.println("all ok");
        }
    }
}