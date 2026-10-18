package ergasia.erg.p25120.bert.model;

public class Newspaper extends LibraryItem {
    private String publisher;
    private String regularity;
    public Newspaper(String code, String title,int PublicationYear, boolean isAvailable, String publisher, String regularity){
        super(code, title, PublicationYear, isAvailable);
        setPublisher(publisher);
        setRegularity(regularity);

    }
    public String getPublisher(){
        return publisher;

    }
    public String getRegularity(){
        return regularity;
    }
    public void setPublisher(String publisher){
        if(publisher==null || publisher.trim().equals("")){
            System.out.println("Ο εκδότης δεν επιτρέπεται να είναι κενός.");

        }
        else{
            this.publisher = publisher;
        }
    }
    public void setRegularity(String regularity){
        if(regularity==null || regularity.trim().equals("")){
            System.out.println("Η συχνότητα έκδοσης δεν επιτρέπεται να είναι κενή.");

        }
        else{
            this.regularity = regularity;
        }
    }
    @Override
    public String getInformation(){
        return "Εκδότης: "+ getPublisher()+ "Συχνότητα έκδοσης: "+ getRegularity();
    }
}
