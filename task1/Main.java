import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    protected static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        List<String> folders = new ArrayList<>();
        try {
            folders.add("C:\\netology\\Games");
            folders.add("C:\\netology\\Games\\src");
            folders.add("C:\\netology\\Games\\res");
            folders.add("C:\\netology\\Games\\savegames");
            folders.add("C:\\netology\\Games\\temp");
            folders.add("C:\\netology\\Games\\src\\main");
            folders.add("C:\\netology\\Games\\src\\test");
            folders.add("C:\\netology\\Games\\res\\drawables");
            folders.add("C:\\netology\\Games\\res\\vectors");
            folders.add("C:\\netology\\Games\\res\\icons");

            for (String folder : folders) {
                logingMkdir(folder);
            }


            File tempFile = new File("C:\\netology\\Games\\temp", "temp.txt");
            if (tempFile.createNewFile()) {
                log.append("Файл " + tempFile.getName() + " создан\n");
            } else log.append("Ошибка при создани файла "  + tempFile.getName() + " \n");

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
        File folder = new File(path);
        if (folder.mkdir()) {
            log.append("Каталог " + folder.getName() + " создан\n");
        } else log.append("Ошибка при создани каталога " + folder.getName() + " \n");
        if (folder.getName().equals("main")) {
            File f = new File(folder, "Main.java");
            if (f.createNewFile()) {
                log.append("Файл " + f.getName() + " создан\n");
            } else log.append("Ошибка при создани файла "  + f.getName() + " \n");
            File f1 = new File(folder, "Utils.java");
            if (f1.createNewFile()) {
                log.append("Файл " + f1.getName() + " создан\n");
            } else log.append("Ошибка при создани файла "  + f1.getName() + " \n");
        }
    }

}