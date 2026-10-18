package ergasia.erg.p25120.bert.model;

public class DigitalBook extends Book{
    private float size;
    private String type;
    public DigitalBook(String code, String title, int PublicationYear, boolean isAvailable, String author, String ISBN, float size, String type){
        super(code,title,PublicationYear,isAvailable,author,ISBN);
        setSize(size);
        setType(type);
    }
    public float getSize(){
        return size;
    }
    public String getType(){
        return type;
    }
    public void setSize(float size){
        if(size<=0){
            System.out.println("Το μέγεθος δεν επιτρέπεται να είναι αρνητικό ή μηδέν");
        }
        else{
            this.size=size;
        }
    }
    public void setType(String type){
        if(type==null || type.trim().equals("")){
            System.out.println("Ο τύπος του ηλεκτρονικού βιβλίου δεν επιτρέπεται να είναι κενός");
        }
        else{
            this.type=type;
        }
    }


}

