package show ;

public enum Buttontype {
    selectbtn("select.jpg"),
    associationbtn("select.jpg"),
    generalizationbtn("select.jpg"),
    compositionbtn("select.jpg"),
    classbtn("select.jpg"),
    use_casebtn("select.jpg");

    private String filename;

    Buttontype(String name) {
        this.filename = name ;

    }

    public String getfilename() {
        return filename;
    }
}