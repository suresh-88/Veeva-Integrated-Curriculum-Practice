import java.util.*;
import java.util.stream.Collectors;

class Participant{
    private String username;
    private int problemsSolved;
    private int penaltyTime;
    private int rating;

    public Participant(String username, int problemsSolved, int penaltyTime, int rating) {
        this.username = username;
        this.problemsSolved = problemsSolved;
        this.penaltyTime = penaltyTime;
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public int getProblemsSolved() {
        return problemsSolved;
    }

    public int getPenaltyTime() {
        return penaltyTime;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return problemsSolved == that.problemsSolved && penaltyTime == that.penaltyTime && rating == that.rating && Objects.equals(username, that.username);
    }

    @Override
    public String toString() {
        return  username + " " +
                problemsSolved + " " +
                penaltyTime + " " +
                rating;
    }
}
public class SortingParticipants {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String username = sc.next();
            int problemsSolved = sc.nextInt();
            int penaltyTime = sc.nextInt();
            int rating = sc.nextInt();
            Participant participant = new Participant(username,problemsSolved,penaltyTime,rating);
            participants.add(participant);
        }
        participants.sort(Comparator.comparing(Participant::getProblemsSolved,Comparator.reverseOrder())
                .thenComparingInt(Participant::getPenaltyTime)
                .thenComparing(Participant::getRating, Comparator.reverseOrder())
                .thenComparing(Participant::getUsername));
        for(Participant p : participants)
            System.out.println(p);
    }
}
