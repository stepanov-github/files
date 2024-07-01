import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    protected static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        List<String> paths = new ArrayList<>();
        try {
            paths.add("C:\\netology\\Games");
            paths.add("C:\\netology\\Games\\src");
            paths.add("C:\\netology\\Games\\res");
            paths.add("C:\\netology\\Games\\savegames");
            paths.add("C:\\netology\\Games\\temp");
            paths.add("C:\\netology\\Games\\src\\main");
            paths.add("C:\\netology\\Games\\src\\test");
            paths.add("C:\\netology\\Games\\res\\drawables");
            paths.add("C:\\netology\\Games\\res\\vectors");
            paths.add("C:\\netology\\Games\\res\\icons");
            paths.add("C:\\netology\\Games\\src\\main\\Main.java");
            paths.add("C:\\netology\\Games\\src\\main\\Utils.java");

            for (String folder : paths) {
                logingMkdir(folder);
            }


            File tempFile = new File("C:\\netology\\Games\\temp", "temp.txt");
            if (tempFile.createNewFile()) {
                log.append("Файл " + tempFile.getName() + " создан\n");
            } else log.append("Ошибка при создани файла " + tempFile.getName() + " \n");

            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write(log.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logingMkdir(String path) throws IOException {
        File f = new File(path);
        if (f.getName().contains(".")) {
            if (f.createNewFile()) {
                log.append("Файл " + f.getName() + " создан\n");
            } else log.append("Ошибка при создани файла " + f.getName() + " \n");
        } else {
            if (f.mkdir()) {
                log.append("Каталог " + f.getName() + " создан\n");

            } else {
                log.append("Ошибка при создани каталога " + f.getName() + " \n");
            }
        }
    }

}