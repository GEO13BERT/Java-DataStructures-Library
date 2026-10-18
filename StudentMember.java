package ergasia.erg.p25120.bert.model;

public class StudentMember extends Member{
    private String AM;
    private String department;

    public StudentMember(String id, String name, String email, int maxNumber, String AM, String department){
        super(id,name,email,maxNumber);
        setAM(AM);
        setDepartment(department);

    }
    public String getAM(){
        return AM;
    }
    public String getDepartment(){
        return department;
    }
    public void setAM(String AM){
        if(AM==null|| AM.trim().equals("")){
            System.out.println("Ο αριθμός μητρώου δεν επιτρέπεται να είναι κενός.");

        }
        else{
            this.AM=AM;
        }
    }
    public void setDepartment(String department){
        if(department==null|| department.trim().equals("")){
            System.out.println("Το τμήμα σπουδών δεν επιτρέπεται να είναι κενό ");

        }
        else{
            this.department=department;
        }
    }

}
