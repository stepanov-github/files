import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            GameProgress gp1 = new GameProgress(90, 5, 3, 134.47);
            GameProgress gp2 = new GameProgress(80, 7, 5, 276.89);
            GameProgress gp3 = new GameProgress(65, 8, 8, 453.13);

            saveGame("C:\\netology\\Games\\savegames\\save1.dat", gp1);
            saveGame("C:\\netology\\Games\\savegames\\save2.dat", gp2);
            saveGame("C:\\netology\\Games\\savegames\\save3.dat", gp3);

            List<String> files = new ArrayList<>();
            files.add("C:\\netology\\Games\\savegames\\save1.dat");
            files.add("C:\\netology\\Games\\savegames\\save2.dat");
            files.add("C:\\netology\\Games\\savegames\\save3.dat");

            zipFiles("C:\\netology\\Games\\savegames\\save.zip", files);

            File dir = new File("C:\\netology\\Games\\savegames");
            if (dir.isDirectory()) {
                for (File item : dir.listFiles()) {
                    if (!item.getName().contains(".zip")) {
//                        item.delete();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void saveGame(String path, GameProgress gp) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(gp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zipFiles(String archivePath, List<String> files) throws FileNotFoundException {
        try (ZipOutputStream zout = new ZipOutputStream(new
                FileOutputStream(archivePath))) {
            File dir = new File(archivePath).getParentFile();

            if (dir.isDirectory()) {
                for (File item : dir.listFiles()) {
                    if (!item.getName().contains(".zip")) {
                        try (FileInputStream fis = new FileInputStream(item)) {
                            ZipEntry entry = new ZipEntry(item.getName());
                            zout.putNextEntry(entry);
                            byte[] buffer = new byte[fis.available()];
                            fis.read(buffer);
                            zout.write(buffer);
                            zout.closeEntry();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}