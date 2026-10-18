package ergasia.erg.p25120.bert.model;

public class AudioBook extends Book{
    private String narrator;
    private int duration;
    public AudioBook(String code, String title, int PublicationYear, boolean isAvailable, String author, String ISBN, String narrator,int duration){
        super(code,title,PublicationYear,isAvailable,author,ISBN);
        setDuration(duration);
        setNarrator(narrator);
    }
    public String getNarrator() {
        return narrator;

    }
    public int getDuration(){
        return duration;
    }
    public void setNarrator(String narrator){
        if(narrator==null || narrator.trim().equals("")){
            System.out.println("Ο αφηγητής δεν επιτρέπται να είναι κενός");

        }
        else{
            this.narrator=narrator;
        }
    }
    public void setDuration(int duration){
        if(duration<=0){
            System.out.println("Η διάρκεια δεν επιτρέπεται να έιναι αρνητικός αριθμός ή ίση με μηδέν.");
        }
        else{
            this.duration=duration;
        }
    }
}
