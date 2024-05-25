import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Create File objects for the audio files
        File file1 = new File("Gully Dreams - Hanu Dixit.wav");
        File file2 = new File("Dance Of The Gypsies - Hanu Dixit.wav");
        File file3 = new File("Indecision - Dyalla.wav");

        // Obtain audio input streams from the audio files
        AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(file1);
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
        AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);

        // Get audio clips for playing the audio streams
        Clip clip1 = AudioSystem.getClip();
        Clip clip2 = AudioSystem.getClip();
        Clip clip3 = AudioSystem.getClip();

        // Open the audio clips with the corresponding audio streams
        clip1.open(audioStream1);
        clip2.open(audioStream2);
        clip3.open(audioStream3);

        String response = "";

        // Main loop to process user input until the user decides to quit
        while (!response.equals("Q")) {
            // Display the menu options to the user
            System.out.println("P1 = Play Song1, P2 = Play Song2, P3 = Play Song3, S = Stop, R = Reset, Q = Quit");
            System.out.print("Enter your choice: ");

            // Read user input and convert it to uppercase
            response = scanner.next();
            response = response.toUpperCase();

            // Process user input using a switch statement
            switch (response) {
                case ("P1"): // Play the first audio file
                    clip1.start();
                    break;
                case ("P2"): // Play the second audio file
                    clip2.start();
                    break;
                case ("P3"): // Play the third audio file
                    clip3.start();
                    break;
                case ("S"): // Stop all audio files
                    clip1.stop();
                    clip2.stop();
                    clip3.stop();
                    break;
                case ("R"): // Reset playback position of all audio files to the beginning
                    clip1.setMicrosecondPosition(0);
                    clip2.setMicrosecondPosition(0);
                    clip3.setMicrosecondPosition(0);
                    break;
                case ("Q"): // Close all audio clips and quit the program
                    clip1.close();
                    clip2.close();
                    clip3.close();
                    break;
                default: // Handle invalid input
                    System.out.println("Not a valid response");
                    break;
            }
        }

        // Farewell message when the program exits
        System.out.println("Byeeeeeeeeeeeeeee :)");
    }
}
