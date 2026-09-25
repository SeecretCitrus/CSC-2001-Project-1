public class Session {
    private int id;
    private String title;
    private String mentor;
    private String date;
    private String location;
    private int participants;
    private int maxParticipants;

    public Session(int id, String title, String mentor, String date, String location, int maxParticipants) {
        this.participants = 0;
        this.id = id;
        this.title = title;
        this.mentor = mentor;
        this.date = date;
        this.location = location;
        this.maxParticipants = maxParticipants;

    }

    public int getID() {
        return id;
    }

    public String getMentor() {
        return mentor;
    }

    public String getDate() {
        return date;
    }

    public boolean canAddParticipant() {
        return participants < maxParticipants;
    }

    public void addParticipant() {
        participants++;
    }

    public String toString() {
        return "ID: " + id
                + "\nTitle: " + title
                + "\nMentor: " + mentor
                + "\nDate: " + date
                + "\nLocation: " + location
                + "\nParticipants: " + participants + "/" + maxParticipants;
    }




}
