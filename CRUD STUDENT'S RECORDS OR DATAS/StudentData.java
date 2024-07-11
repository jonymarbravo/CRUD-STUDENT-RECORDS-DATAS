public class StudentData {
    private int id;
    private String name;
    private String gender;
    private String nationality;
    private String course;
    private int age;

    public StudentData(int id, String name, String gender, String nationality, String course, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.course = course;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nGender: " + gender +
                "\nNationality: " + nationality +
                "\nCourse: " + course +
                "\nAge: " + age + "\n";
    }
}
