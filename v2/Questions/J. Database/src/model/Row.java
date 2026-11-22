package model;

public class Row {
    private String name;
    private int marks;
    private String Branch;

    public Row(String name, int marks, String branch) {
        this.name = name;
        this.marks = marks;
        Branch = branch;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getBranch() {
        return Branch;
    }

    @Override
    public String toString() {
        return "Row{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                ", Branch='" + Branch + '\'' +
                '}';
    }
}
