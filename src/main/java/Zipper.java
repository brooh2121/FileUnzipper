import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by petrovdy on 16.08.2019.
 */
public class Zipper {

    public void Unzip (String filepath, String dir) {

        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(filepath));
            ZipEntry entry;
            String name;

            while((entry = zis.getNextEntry())!=null) {
                name = entry.getName();
                File newFile = new File(dir + File.separator + name.replace("C:\\",""));
                System.out.println("File unzip: " + newFile + "\n");
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                for (int i = zis.read(); i!=-1; i=zis.read()) {
                    fos.write(i);
                }
                fos.flush();
                zis.closeEntry();
                fos.close();

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
