import java.io.*;
import java.text.ChoiceFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, CustomNumberException, ClassNotFoundException {
        Main main = new Main();
        //TODO
        main.task12();
        // main.task2("C:\\Users\\User\\IdeaProjects\\ExamJava");
    }

    private void task12() {
        LocalDate birthDate = LocalDate.of(2000, 3, 30);
        LocalDate now = LocalDate.now();
        int age = now.getYear() - birthDate.getYear();
        if (now.isBefore(LocalDate.of(now.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth())))
            age--;
        System.out.println(age);
    }

    private void task11() {
        LocalDate localDate = LocalDate.now();
        System.out.println(ChronoUnit.DAYS.between(localDate, LocalDate.of(localDate.getYear(), 12, 31)));
    }

    private void task10() {
        Scanner sc = new Scanner(System.in);
        String dayOfweek = sc.next();
        LocalDate localDate = LocalDate.now();
        while (!dayOfweek.equalsIgnoreCase(localDate.getDayOfWeek().name())) {
            localDate = localDate.plusDays(1);
        }
        System.out.println(localDate);
    }

    private void task9() {
        List<Integer> list = List.of(11, 15, 77, 15, 111);
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                System.out.println("Palindrome deyil");
                return;
            }
        }
        System.out.println("Palindromedur");
    }

    private void task8() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(17, "Esma"));
        personList.add(new Person(17, "Shamil"));
        personList.add(new Person(27, "Gulnar"));
        Map<Integer, List<Person>> map = new HashMap<>();
        for (Person person : personList) {
//            List<Person> personList1 = new ArrayList<>();
//            personList1.add(person);
            map.computeIfAbsent(person.getAge(), k -> new ArrayList<>()).add(person);
//            map.put(person.getAge(),personList1);
        }
        System.out.println(map);
    }

    private void task7() {
        List<Integer> list2 = List.of(11, 15, 77, 6, 8);
        List<Integer> list1 = new ArrayList<>(list2);
        list1.add(11);
        list1.add(5);
        list1.add(7);
        list1.add(6);
        list1.add(8);
        System.out.println(list1);
        for (int i = 0; i < list1.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list1.size(); j++) {
                if (list1.get(minIndex) > list1.get(j))
                    minIndex = j;
            }
            int minElement = list1.get(minIndex);
            list1.set(minIndex, list1.get(i));
            list1.set(i, minElement);
        }
        System.out.println("Sorted list: " + list1);
    }

    private void task6() {
        List<Integer> list1 = List.of(11, 5, 7, 6, 8);
        List<Integer> list2 = List.of(11, 15, 77, 6, 8);
        List<Integer> listCommon = new ArrayList<>();
        for (Integer element : list1) {
            if (list2.contains(element))
                listCommon.add(element);
        }
        System.out.println(listCommon);
    }

    private void task5() throws IOException, ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i <= 10; i++)
            studentList.add(new Student("student " + i, i * 3, i * 10));
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\ExamJava\\students.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentList);

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\ExamJava\\students.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Student> readStudentList = (List<Student>) objectInputStream.readObject();
        int sum = 0;
        for (Student student : readStudentList)
            sum += student.getGrade();
        System.out.println("Orta qiymet: " + sum / readStudentList.size());
        if (true) ;
        else System.out.println("else");
    }

    private void task4() {
        System.out.println(DateTimeUtils.diffDate(LocalDate.of(2017, 06, 5), LocalDate.now()));
        System.out.println(DateTimeUtils.parse("2017/08*16", "yyyy/MM*dd"));
        System.out.println(DateTimeUtils.format(LocalDate.of(2017, 06, 5), "dd/yyyy-MM"));
    }

    private void task3() {
        Queue<Integer> queue = new PriorityQueue<>();

        Thread thread1 = new MyThread1(queue);
        Thread thread2 = new MyThread2(queue);
        thread1.start();
        thread2.start();
    }

    private void task2(String path) throws IOException {
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                task2(file.getPath());
            }
            if (file.getName().contains(".java")) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                int cnt = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    cnt++;
                    if (line.contains("//TODO")) {
                        System.out.println(file.getName() + " faylda " + cnt + " setirde TODO var");
                    }
                }
            }
        }
    }

    private void task1() throws IOException, CustomNumberException {
        FileReader fileReader = new FileReader("C:\\Users\\User\\IdeaProjects\\ExamJava\\data.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int sum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            try {
                Integer i = Integer.parseInt(line);
                sum += i;
            } catch (NumberFormatException ex) {
                CustomNumberException customNumberException = new CustomNumberException("Bu setir - " + line + " integer deyil");
                System.out.println(customNumberException.getMessage());
            }
        }
        System.out.println("sum: " + sum);
    }
}