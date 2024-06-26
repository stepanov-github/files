# Задача 1: Установка

## Реализация

### Класс 'Main'
```java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            StringBuilder log = new StringBuilder();
            File games = new File("C:\\netology\\Games");
            File src = new File("C:\\netology\\Games\\src");
            File res = new File("C:\\netology\\Games\\res");
            File savegames = new File("C:\\netology\\Games\\savegames");
            File temp = new File("C:\\netology\\Games\\temp");
            File main = new File("C:\\netology\\Games\\src\\main");
            File test = new File("C:\\netology\\Games\\src\\test");
            File drawables = new File("C:\\netology\\Games\\res\\drawables");
            File vectors = new File("C:\\netology\\Games\\res\\vectors");
            File icons = new File("C:\\netology\\Games\\res\\icons");
            File mainFile = new File(main, "Main.java");
            File utilsFile = new File(main, "Utils.java");
            File tempFile = new File(temp, "temp.txt");
            log = logingMkdir(games, log);
            log = logingMkdir(src, log);
            log = logingMkdir(res, log);
            log = logingMkdir(savegames, log);
            log = logingMkdir(temp, log);
            log = logingMkdir(main, log);
            log = logingMkdir(test, log);
            log = logingMkdir(drawables, log);
            log = logingMkdir(vectors, log);
            log = logingMkdir(icons, log);
            log = logingCreateNewFile(mainFile, log);
            log = logingCreateNewFile(utilsFile, log);
            log = logingCreateNewFile(tempFile, log);
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write(log.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder logingMkdir(File file, StringBuilder str) {
        if (file.mkdir()) {
            str.append("Каталог " + file.getName() + " создан\n");
        } else str.append("Каталог " + file.getName() + " не создан\n");
        return str;
    }

    public static StringBuilder logingCreateNewFile(File file, StringBuilder str) throws IOException {
        if (file.createNewFile()) {
            str.append("Файл " + file.getName() + " создан\n");
        } else str.append("Файл " + file.getName() + " не создан\n");
        return str;
    }
}
```

