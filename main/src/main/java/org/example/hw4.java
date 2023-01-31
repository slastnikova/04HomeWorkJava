package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

//1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
//2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
//3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
//4.Отсортировать по возрасту используя дополнительный список индексов.//
public class hw4 {
    public static void main(String[] args) {
        // Создать текстовый файл потом его считать.

        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String text = "";
        try {
//            FileWriter fileWriter = new FileWriter("bd.sql",true);
//            fileWriter.append("Hello word");
//            fileWriter.flush();
//            fileWriter.close();

            FileReader fileReader = new FileReader("file.txt");

            while (fileReader.ready()) {
                text += (char) fileReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] str = text.split("\n");
        boolean booleanGender;
        for (int i = 0; i < str.length; i++) {
            String[] sb = str[i].split(" ");
            family.add(sb[0]+ " ");
            name.add(sb[1].charAt(0) + ".");
            soname.add(sb[2].charAt(0) + ".");
            age.add(Integer.valueOf(sb[3]));
            booleanGender = (sb[4] == "M" ? true : false);
            gender.add(sb[4].equals("Ж") ? true : false);
            index.add(i);
        }
        index.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < index.size(); i++) {

            System.out.printf(family.get(index.get(i)));
            System.out.printf(name.get(index.get(i)));
            System.out.printf(soname.get(index.get(i)));
            System.out.printf(age.get(index.get(i)).toString());
            System.out.printf((gender.get(index.get(i)) ? " M" : " Ж"));
            System.out.println();
        }

        System.out.println(age);

    }
}
