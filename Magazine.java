package ergasia.erg.p25120.bert.model;

public class Magazine extends LibraryItem{
    private int NumberOfIssue;
    public Magazine(String code, String title, int PublicationYear, boolean isAvailable, int NumberOfIssue){
        super(code,title,PublicationYear,isAvailable);
        setNumberOfIssue(NumberOfIssue);
    }
    public int getNumberOfIssue(){
        return NumberOfIssue;
    }
    public void setNumberOfIssue(int NumberOfIssue){
        if(NumberOfIssue<=0){
            System.out.println("Ο αριθμός του τεύχους δεν επιτρέπεται να είναι μηδέν ή αρνητικός αριθμός");
        }
        else{
            this.NumberOfIssue = NumberOfIssue;
        }
    }
    @Override
    public String getInformation(){
        return "Τίτλος περιοδικού: "+ getTitle()+ "Τεύχος: "+ getNumberOfIssue();
    }
}
