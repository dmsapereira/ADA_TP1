import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static void buildDrones(BufferedReader in, Drone drone, int nRents) throws IOException {
        for (int i = 0; i < nRents; i++) {
            String line = in.readLine();
            String info[] = line.split(" ");
            drone.addRental(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Drone drone;

        int iterations = Integer.parseInt(in.readLine());

        for(int i = 0 ; i < iterations; i ++){

            int nRents = Integer.parseInt(in.readLine());

            drone = new Drone(nRents);

            buildDrones(in , drone, nRents);

            System.out.println(drone.fillList());
        }

    }
}