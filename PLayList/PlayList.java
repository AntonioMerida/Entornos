/* CREA UN PROGRAMA QUE SIMULE LA GESTION DE UNA LISTA DE REPRODUCCION. DEBE DE TENER LAS SIGUIENTES FUNCIONES: 
 * - AÑADIR CANCION.
 * - ELIMINAR CANCION.
 * - ORDENAR CANCIONES.
 * - DESORDENAR CANCIONES.
*/

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class song 
{
    String name;
    String artist;
    double duration;
    
    public song(String name, String artist, double duration) 
    {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public String getArtist() 
    {
        return artist;
    }
    
    public double getDuration() 
    {
        return duration;
    }

    @Override

    public String toString()
    {
        return name + " || from " + artist + " || Duration of " + duration;
    }
}

public class PlayList 
{
    public static void main(String[] args) 
    {
        LinkedList<song> playList = new LinkedList<>();

        playList.add(new song("Muerte en hawai", "Calle 13", 3.09));
        playList.add(new song("Atrevete-te-te", "Calle 13", 3.59));
        playList.add(new song("Stolen Dance", "Milky Chance", 5.13));
        playList.add(new song("ThundersTruck", "ACDC", 4.52 ));
        playList.add(new song("Ashes", "Stellar", 2.46));

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add new song");
            System.out.println("2. Swap songs");
            System.out.println("3. Shuffle playlist");
            System.out.println("4. Remove song");
            System.out.println("5. Print playList");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playList = addNewSong(playList);
                    break;
                case 2:
                    if (playList.size() >= 2)
                    {
                        playList = swapSongs(playList);
                    }
                else
                    {
                        System.out.println("Theres no songs enought to do a swap");
                    }
                    break;
                case 3:
                    playList = shufflePlayList(playList);
                    break;
                case 4:
                    if (!playList.isEmpty())
                    {
                        playList = removeSong(playList);
                    }
                    else
                    {
                        System.out.println("There is no song in the playList.");
                    }
                    break;
                case 5:
                    {
                        printPlayList(playList);
                        break;
                    }
                case 0:
                    System.out.println("Exiting the program.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void printPlayList(LinkedList<song> playList)
    {
        for (int i = 1; i <=playList.size(); i++)
        {
            System.out.print(i +  ".  ");
            System.out.println(playList.get(i-1));
        }
        System.out.println("");
        System.out.println("");
    }

    public static LinkedList<song> addNewSong(LinkedList<song> playList)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce song's information.\nName: ");
        String name = scanner.nextLine();

        System.out.print("\nAutor: ");
        String artist = scanner.nextLine();

        System.out.print("\nIntroduce the duration: ");
        double duration = scanner.nextDouble();
        
        scanner.close();
        
        song song_X = new song(name, artist, duration);

        playList.add(song_X);
        return playList;
    }

    public static LinkedList<song> swapSongs (LinkedList<song> playList)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter position of first song to swap: ");
        int m = scanner.nextInt();
        System.out.print("Enter position of second song to swap: ");
        int n = scanner.nextInt();

        scanner.close();

        song x = playList.get(m-1);

        playList.set(m-1, playList.get(n-1));
        playList.set(n-1, x);
        
        printPlayList(playList);

        return playList;
    }

    public static LinkedList<song> shufflePlayList(LinkedList<song> playList) 
    {
        Collections.shuffle(playList);
    
        printPlayList(playList);
    
        return playList;
    }
    

    public static LinkedList<song> removeSong(LinkedList<song> playlist)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter position of song to remove: ");
        int m = scanner.nextInt();

        scanner.close();

        playlist.remove(m -1);

        printPlayList(playlist);

        return playlist;
    }
}
