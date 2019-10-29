/**
 * Created by petrovdy on 16.08.2019.
 */
public class Main {

    public static void main (String [] args) {

        /*
        Zipper zipper = new Zipper();
        zipper.Unzip("C:\\Users\\petrovdy\\Desktop\\выгрузки для СК\\15.08.19\\ZipperTest\\01.zip","C:\\Users\\petrovdy\\Desktop\\выгрузки для СК\\15.08.19\\ZipperTest");
        */

        try {
            FileWalker fileWalker = new FileWalker();
            fileWalker.fileWalkerForUngzip("C:\\Users\\petrovdy\\Desktop\\выгрузки для СК\\15.08.19\\ZipperTest");
            System.out.println(fileWalker.walkFile("C:\\Users\\petrovdy\\Desktop\\выгрузки для СК\\15.08.19\\ZipperTest"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
