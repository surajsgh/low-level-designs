import java.text.SimpleDateFormat;
import java.util.*;

class BookMyShow {
    ArrayList<Theater> theaters;
    static Map<String, ArrayList<Show>> moviesMap;

    public BookMyShow(ArrayList<Theater> theaters) {
        this.theaters = theaters;
        moviesMap = new HashMap<>();
        generateMovieMap();
    }

    public static ArrayList<Show> searchShows(String movie) {
        if (moviesMap.containsKey(movie)) {
            return moviesMap.get(movie);
        }
        return null;
    }

    private void generateMovieMap() {
        for (Theater theater : theaters) {
            ArrayList<Show> shows = theater.getShows();
            for (Show show : shows) {
                if (show != null) {
                    if (moviesMap.containsKey(show.getMovie().getName())) {
                        moviesMap.get(show.getMovie().getName()).add(show);
                    } else {
                        ArrayList<Show> list = new ArrayList<>();
                        list.add(show);
                        moviesMap.put(show.getMovie().getName(), list);
                    }
                }
            }
        }

    }
}

public class Main {
    public static void main(String[] args) {
        GuestUser dharam = new GuestUser("Dharam");
        RegisteredUser suraj = new RegisteredUser("Suraj");
        RegisteredUser ganesh = new RegisteredUser("Ganesh");

        Movie ironMan = new Movie("Ironman", Language.ENGLISH, Genre.ACTION);
        Movie golmaal = new Movie("Golmaal", Language.HINDI, Genre.COMEDY);
        Movie drishyam = new Movie("Drishyam", Language.HINDI, Genre.DRAMA);
        Movie titanic = new Movie("Titanic", Language.ENGLISH, Genre.ROMANCE);

        Theater nexus = new Theater("Nexus mall", "kormangala", 60);
        Theater vega = new Theater("Vega mall", "BTM", 120);

        Show firstShow = null;
        Show secondShow = null;
        Show thirdShow = null;
        Show fourthShow = null;
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");

        try {
            String dateInString = "Friday, Jun 7, 2020 09:00:00 AM";
            Date date = formatter.parse(dateInString);
            firstShow = new Show(date, ironMan, nexus);

            dateInString = "Friday, Jun 7, 2020 11:00:00 AM";
            date = formatter.parse(dateInString);
            secondShow = new Show(date, golmaal, vega);

            dateInString = "Friday, Jun 7, 2020 01:00:00 PM";
            date = formatter.parse(dateInString);
            thirdShow = new Show(date, drishyam, nexus);

            dateInString = "Friday, Jun 7, 2020 04:00:00 PM";
            date = formatter.parse(dateInString);
            fourthShow = new Show(date, titanic, vega);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        ArrayList<Theater> list = new ArrayList<>();
        list.add(nexus);
        list.add(vega);
        BookMyShow main = new BookMyShow(list);

        ArrayList<Show> searchedShow = BookMyShow.searchShows("Ironman");

        Show bookingShow = searchedShow.get(0);

        TicketBookingThread t1 = new TicketBookingThread(bookingShow, suraj, 10);
        TicketBookingThread t2 = new TicketBookingThread(bookingShow, ganesh, 5);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(firstShow.getAvailableSeats());
        System.out.println(secondShow.getAvailableSeats());
    }
}