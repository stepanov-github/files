# Задача 3: Загрузка (со звездочкой *)

## Реализация

### Класс 'Main'
```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {

        openZip("C:\\netology\\Games\\savegames\\save.zip", "C:\\netology\\Games\\savegames");
        System.out.println(openProgress("C:\\netology\\Games\\savegames\\save1.dat").toString());;

    }

    public static void openZip(String path, String folder) {
        try (ZipInputStream zis = new ZipInputStream(new
                FileInputStream(path))) {
            ZipEntry entry;
            String name;
            while ((entry = zis.getNextEntry()) != null) {
                name = folder + "\\" + entry.getName(); // получим название файла
                // распаковка
                FileOutputStream fout = new FileOutputStream(name);
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fout.write(c);
                }
                fout.flush();
                zis.closeEntry();
                fout.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static GameProgress openProgress(String path) {
        GameProgress gameProgress = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameProgress;
    }
}
```

### Класс 'GameProgress'
```java
import java.io.Serializable;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = -2608611281895680623L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}

```
