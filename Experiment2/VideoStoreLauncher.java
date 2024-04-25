package University.Java_Using_Project.Experiment2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Video {
    private String title;
    private boolean available;
    private int rating;

    public Video() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

class VideoStore {

    List<Video> videos = new ArrayList<>();
    Video v;


    // Add new video
    void addVideo(String title) {
        v = new Video();
        v.setTitle(title);
        v.setAvailable(true);
        videos.add(v);
    }

    // Checkout
    void rent(String title, Scanner in) {
        int count = 0;
        for (Video v : videos) {
            if (v.getTitle().equals(title) && v.isAvailable()) {
                count++;
                System.out.println("Title: " + v.getTitle() + " || Rating: " + v.getRating() + " || is available to rent.");
                System.out.println("Enter 1 for check out.\nEnter 0 for return back to store.");
                int n = in.nextInt();
                if (n == 1) {
                    System.out.println("Video is yours for 7 days. Have a nice day!!!\n");
                    v.setAvailable(false);
                } else {
                    System.out.println("You are in the gallery again.\n");
                }
            }
        }
        if (count == 0) {
            System.out.println("Video with " + title + " not available to rent.\n");
        }
    }

    // Return back
    void returnBack(String title) {
        int count = 0;
        for (Video v : videos) {
            if (v.getTitle().equals(title) && !v.isAvailable()) {
                count++;
                v.setAvailable(true);
                System.out.println("Video returned to store.\n");
            }
        }
        if (count == 0) {
            System.out.println("Video with title " + title + " never existed in store\n");
        }
    }


    // Rating
    String rating(String title, int rating) {
        for (Video v : videos) {
            if (v.getTitle().equals(title)) {
                v.setRating(rating);
                return title + " rated " + rating + " star.\n";
            }
        }
        return "Video with " + title + " not found.\n";
    }

    // Display
    void displayAll() {
        for (Video v : videos) {
            System.out.println("Title: " + v.getTitle() + " || Rating: " + v.getRating() + " || Available: " + v.isAvailable());
        }
        System.out.println();
    }

    // Get video by title
    void getVideoByTitle(String title) {
        for (Video v : videos) {
            if (v.getTitle().equals(title)) {
                System.out.println("Title: " + v.getTitle() + " || Rating: " + v.getRating() + " || Available: " + v.isAvailable());
            }
        }
        System.out.println();
    }




    // Run method
    void run(Scanner in) {


        while (true) {

            System.out.println("Enter 1 for adding a video to the gallery.");
            System.out.println("Enter 2 for rating a video.");
            System.out.println("Enter 3 for display all video records. ");
            System.out.println("Enter 4 for get video by title.");
            System.out.println("Enter 5 for rent a video.");
            System.out.println("Enter 6 for returning rented video");
            System.out.println("Enter 7 for exit store");
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the title of the video");
                    String title = in.nextLine();
                    addVideo(title);

                }
                break;
                case 2: {
                    System.out.println("Enter the title for rating");
                    String title = in.nextLine();
                    System.out.println("Enter the rating out of 5");
                    int rating = in.nextInt();
                    System.out.println(rating(title, rating));
                }
                break;
                case 3: {
                    displayAll();
                }
                break;
                case 4: {
                    System.out.println("Enter the title");
                    String title = in.nextLine();
                    getVideoByTitle(title);
                }
                break;
                case 5: {
                    System.out.println("Enter the title to rent video ");
                    String title = in.nextLine();
                    rent(title, in);
                }
                break;
                case 6: {
                    System.out.println("Enter video title to return back");
                    String title = in.nextLine();
                    returnBack(title);

                }
                break;
                case 7: {
                    System.exit(0);
                }
                break;
                default:
                    System.out.println("Invalid Choice");
            }

        }

    }
}

public class VideoStoreLauncher {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        VideoStore videoStore = new VideoStore();
        videoStore.run(in);
    }


}
