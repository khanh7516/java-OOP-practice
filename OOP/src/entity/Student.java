package entity;

public class Student {
    private static int autoID;
    private int id;
    private String name;
    private double scoreMath;
    private double scorePhysic;
    private double scoreChemistry;

    public Student(String name, double scoreMath, double scorePhysic, double scoreChemistry) {
        this.id = ++autoID;
        this.name = name;
        this.scoreMath = scoreMath;
        this.scorePhysic = scorePhysic;
        this.scoreChemistry = scoreChemistry;
    }
    public Student() {
        this.id = ++autoID;
    }

    public double avgScore() {
        return (scoreMath + scorePhysic + scoreChemistry) / 3;
    }

    public String xepLoai() {
        String result = "";
        double score = avgScore();

        if (score >= 8 ) result = "A";
        else if (score >= 6.5 ) result = "B";
        else result = "C";
        return result;
    }

    @Override
    public String toString() {
        double score = avgScore();
        return    "ID: "  + id   + "\n"
                + "Name: "+ name + "\n"
                + "Math: "+ scoreMath+ "\n"
                + "Physic: "+ scorePhysic + "\n"
                + "Chemistry: "+ scoreChemistry + "\n"
                + "Điểm trung bình: " + String.format("%.1f", score) + "\n"
                + "Xếp loại: "   + xepLoai() + "\n"
                + "-".repeat(10);

        // Output:
        //ID: 2
        //Name: Nam
        //Math: 6.0
        //Physic: 7.0
        //Chemistry: 10.0
        //Điểm trung bình: 7.7
        //Xếp loại: B
        //----------
    }
}
