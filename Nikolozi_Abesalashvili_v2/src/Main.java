import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        File btuDocuments = new File("C:\\Users\\user\\Desktop\\BTU_DOCUMENTS");

        while(true) {
            System.out.println("შემოიტანე საძიებო სიტყვა: ");
            String userWord;
            userWord = inputMechanism.next();

            Runnable thread = new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        final int[] numberOfFiles = {0};
                        String[] fileFilter = btuDocuments.list(new FilenameFilter() {
                            @Override
                            public boolean accept(File dir, String name) {
                                if(name.toLowerCase().contains(userWord.toLowerCase())) {
                                    numberOfFiles[0]++;
                                }
                                return name.toLowerCase().contains(userWord.toLowerCase());
                            }
                        });

                        for(String name: fileFilter) {
                            System.out.println(name);
                        }
                        try {
                            System.out.println(numberOfFiles[numberOfFiles.length - 1]);
                            Thread.sleep(3000);
                        }catch(InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            };

            Thread secondThread = new Thread(thread);
            secondThread.start();

        }

    }
}
