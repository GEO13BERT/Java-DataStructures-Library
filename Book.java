package ergasia.erg.p25120.bert.model;

import ergasia.erg.p25120.bert.contracts.Reviewable;

public class Book extends LibraryItem implements Reviewable {
    private String author;
    private String ISBN;
    private int total;
    private int count;
    public Book(String code, String title, int PublicationYear, boolean isAvailable, String author, String ISBN){
        super(code,title,PublicationYear,isAvailable);
        setISBN(ISBN);
        setAuthor(author);


    }
    public String getAuthor(){
        return author;
    }
    public String getISBN(){
        return ISBN;
    }
    public void setAuthor(String author){
        if(author==null || author.trim().equals("")){
            System.out.println("Το όνομα του συγγραφέα δεν επιτρέπεται να είναι κενό");
        }
        else{
            this.author=author;
        }
    }
    public void setISBN(String ISBN){
        if(ISBN==null || ISBN.trim().equals("")){
            System.out.println("Το ISBN δεν επιτέπεται να είναι κενό");
        }
        else{
            this.ISBN=ISBN;
        }
    }
    @Override
    public String getInformation(){
        return "Βιβλίο: "+ getTitle()+ "Συγγραφέας: "+ getAuthor() +"ISBN: "+ getISBN();
    }
    @Override
    public void addRating(int rate){
        total+=rate;
        count++;

    }
    @Override
    public double getAverage(){
        if(count!=0) {
            return (double) total / count;
        }
        else{
            return 0;
        }
    }

}
