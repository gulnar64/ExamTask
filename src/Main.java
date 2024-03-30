import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException, CustomNumberException, ClassNotFoundException {
        Main main = new Main();
        //TODO
        main.task5();
        // main.task2("C:\\Users\\User\\IdeaProjects\\ExamJava");
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