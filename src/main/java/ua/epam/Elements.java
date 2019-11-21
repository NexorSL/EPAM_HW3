package ua.epam;

public enum Elements {
    Rock(0,"Rock"),
    Paper(1,"Paper"),
    Scissors(2,"Scissors");

    private int num;
    private String name;

    Elements(int num, String name){
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
