import java.io.File;

/**
 * Created by petrovdy on 16.08.2019.
 */
public class FileWalker {

    private int count = 0;

    public void fileWalkerForUngzip (String filepath) {
        File file = new File(filepath);
        File [] listFiles = file.listFiles();

        for (File listFile : listFiles) {
            if(listFile.isDirectory()) {
                fileWalkerForUngzip(listFile.getPath());
            }else if(!listFile.isDirectory() && listFile.getAbsolutePath().matches("(.*).zip")){
                Zipper zip = new Zipper();
                zip.Unzip(listFile.getAbsolutePath(),listFile.getParent());
            }
        }
    }

    public int walkFile (String filepath) {
        File file = new File(filepath);
        File [] listFiles = file.listFiles();

        for (File listFile : listFiles) {
            if(listFile.isDirectory()) {
                walkFile(listFile.getPath());
            }else if (!listFile.isDirectory() && !listFile.getAbsolutePath().matches("(.*).zip")){
                count++;
            }
        }
        return count;
    }
}
