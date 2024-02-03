package Ping;
import java.io.*;
import java.util.ArrayList;

/**
 * This class is used to save and load the file
 */
@SuppressWarnings("unchecked")
public class Storage {
    private static final String PATH = "./data/duke.txt";
    /**
     * This method is used to save the file
     * @param tasks the list of tasks
     */
    public static void saveFiles(ArrayList<Task> tasks) {
        try {
            File file = new File(PATH);
            File dir = new File("./data");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oot = new ObjectOutputStream(fout);
            oot.writeObject(tasks);
            oot.close();
            fout.close();
        } catch (IOException e) {
            System.out.println("Oops! Something goes wrong!");
        }
    }
    /**
     * This method is used to load the file
     * @return the list of tasks
     */
    public static ArrayList<Task> loadFiles() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(PATH);

        if (!file.exists()) {
            return tasks;
        }

        try {
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
            tasks = (ArrayList<Task>) objInputStream.readObject();
            objInputStream.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println("----------------------------------------------------------");
            System.out.println("No existing file found\n"
                    + "Dont'worry, I already creat an empty list for you\n"
                    + "ChatBot Ping now could be used!"
            );
            System.out.println("----------------------------------------------------------");
        }
        return tasks;
    }
}
