import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by petrovdy on 15.08.2019.
 */
public class UnZipExample {


    public static void main (String [] args) throws  Exception{

        String zipFile = "C:\\Users\\petrovdy\\Desktop\\выгрузки для СК\\15.08.19\\15.08.19.zip";
        String outputFolder =  "C:\\Users\\petrovdy\\Desktop\\выгрузки для СК\\15.08.19";

        byte [] buffer = new byte[1024];
        try {
            File folder = new File(outputFolder);
            if(!folder.exists()) {
                folder.mkdir();
            }

        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));

        ZipEntry ze = zis.getNextEntry();

        while(ze!=null) {
            String filename = ze.getName();
            File newFile = new File (outputFolder + File.separator + filename);
            System.out.println("File unzip:" + newFile.getAbsoluteFile());

            new File(newFile.getParent()).mkdirs();
            FileOutputStream fos = new FileOutputStream(newFile);

            int length;

            while((length = zis.read(buffer)) > 0) {
                fos.write(buffer,0,length);
            }

            fos.close();
            ze = zis.getNextEntry();

        }
        zis.closeEntry();
        zis.close();

        System.out.println("Done");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}