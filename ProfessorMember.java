package ergasia.erg.p25120.bert.model;

public class ProfessorMember extends Member{
    private String subject;
    public ProfessorMember(String id, String name, String email, int maxNumber, String subject){
        super(id,name,email,maxNumber);
        setSubject(subject);
    }
    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject){
        if(subject==null || subject.trim().equals("")){
            System.out.println("Το γνωστικό αντικείμενο δεν επιτρέπεται να είναι κενό.");
        }
        else{
            this.subject = subject;
        }
    }
}
