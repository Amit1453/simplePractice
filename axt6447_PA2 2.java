//Amit Thing 
//1001556447
//03-31-2020
//java  (run on  terminal (mac)
import java.util.Scanner;
import java.io.File;

public class netid_PA2 {
    public static long getSizeOfDirectory(final File directory) {
        if (directory == null || directory.exists() == false) {
            System.out.println("Invalid directory");
            return 0;
        }

        // Get all files in the current directory
        final File allFiles[] = directory.listFiles();

        // Loop over the list of all the files and directories
        long directorySize = 0;
        for (final File file : allFiles) {
            if (file.isDirectory()) {
                // Calculate the size of the sub-directory
                directorySize += getSizeOfDirectory(file);
            } else {
                // Get the size of the file and add to the current directory size
                long fileSize = file.length();
                directorySize += fileSize;
            }
        }
        return directorySize;
    }

    public static void main(String[] args) {
        // Read directory name from the standard input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the directoryName: ");
        String directoryName = sc.next();

        // Create a File type from the directoryName
        final File directory = new File(directoryName);

        if (directory.exists() == false) {
            System.out.println("Invalid directory");
            return;
        }

        // Get the size of the directory in Bytes
        long directorySize = getSizeOfDirectory(directory);

        // Convert the size of the directory from Bytes to KiloBytes
        double directorySizeInKB = directorySize/1000.0;
        System.out.println("Size of the directory: " + directoryName + " is: "
                + String.format("%.2f", directorySizeInKB) + "KB");
    }
}
