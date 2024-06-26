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