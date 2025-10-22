import java.util.List;

public class Guild implements Comparable{
    String name;
    List<Adventurer> adventurers;

    public Guild(String name, List<Adventurer> adventurers) {
        this.name = name;
        this.adventurers = adventurers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setAdventurers(List<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }

    @Override
    public String toString() {
        return "Guild{" +
                "name='" + name + '\'' +
                ", adventurers=" + adventurers +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
