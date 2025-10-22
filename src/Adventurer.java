import java.util.List;

public class Adventurer implements Comparable{
    String name;
    int age;
    String role;
    double goldEarned;
    List<Skill> skills;

    public Adventurer(int age, String name, String role, List<Skill> skills, double goldEarned) {
        this.age = age;
        this.name = name;
        this.role = role;
        this.skills = skills;
        this.goldEarned = goldEarned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(double goldEarned) {
        this.goldEarned = goldEarned;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", goldEarned=" + goldEarned +
                ", skills=" + skills +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
