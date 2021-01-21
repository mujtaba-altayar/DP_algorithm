package genratingjob;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class Genratingjob {

    static void getjob() {
        Scanner scan = new Scanner(System.in);
        int size, prange, qrange, numfiles;
        System.out.println("Enter The Number Of Files");
        numfiles = scan.nextInt();
        System.out.println("Enter The Number Of Jobs in Each File");
        size = scan.nextInt();
        System.out.println("Enter The Range Of Process Time");
        prange = scan.nextInt();
        System.out.println("Enter The Range Of Delivery Time");
        qrange = scan.nextInt();
        JobsGenerate Newjobs = new JobsGenerate(size, prange, qrange, numfiles);
        try {
            Newjobs.GenJobs();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String getpath() {
        String filename = "";
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            filename = chooser.getSelectedFile().getAbsolutePath();
        }
        return filename;
    }

    public static void main(String[] args) throws IOException {
        //
//        int i;
//        System.out.println("1- to create a files ");
//        System.out.println("2- to select a files ");
//        i = scan.nextInt();
         getjob();
//        File file = new File(getpath());
//        ReadingFromFile read = new ReadingFromFile(file);
//        read.readToArray();

    }
}
