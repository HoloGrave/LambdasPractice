import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Skill implements Predicate<List<Adventurer>> {
    SWORDSMANSHIP,
    ARCHERY,
    THIEVERY,
    HORSEMANSHIP,
    STEALTH,
    HEALING,
    NECROMANCY,
    BLACKSMITHING,
    RUNECRAFTING,
    MEMECRAFTING;

    @Override
    public boolean test(List<Adventurer> adventurers) {
        return false;
    }
}
