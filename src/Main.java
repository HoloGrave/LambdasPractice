import java.util.List;


public class Main {
    public static void main(String[] args) {
        //Object instantiation

        Skill[] JohnSkills = new Skill[]{Skill.SWORDSMANSHIP,Skill.STEALTH};
        Skill[] JakeSkills = new Skill[]{Skill.RUNECRAFTING,Skill.MEMECRAFTING};
        Skill[] JaneSkills = new Skill[]{Skill.ARCHERY,Skill.HORSEMANSHIP};
        Skill[] HoskSkills = new Skill[]{Skill.NECROMANCY,Skill.THIEVERY};
        Skill[] ParkerSkills = new Skill[]{Skill.SWORDSMANSHIP,Skill.BLACKSMITHING,Skill.RUNECRAFTING};
        Skill[] LarrySkills = new Skill[]{Skill.RUNECRAFTING,Skill.HEALING};

        //Creat Adventurers
        //!!!!!FIRST CONSTRUCTOR IS NOT USING THE SKILLS MADE ABOVE TO SHOW HOW YOU DONT NEED TO MAKE THEM INTO AN ARRAY BEFOREHAND TO WORK!!!!!
        Adventurer a1 = new Adventurer(26, "John Doe", "Rogue", List.of(Skill.SWORDSMANSHIP,Skill.STEALTH), 400);
        Adventurer a2 = new Adventurer(15,"Jake Doe", "Mage", List.of(JakeSkills), 320);
        Adventurer a3 = new Adventurer(34, "Jane Doe", "Druid", List.of(JaneSkills), 560);
        Adventurer a4 = new Adventurer(41, "Hosk Doe", "Necromage", List.of(HoskSkills), 154);
        Adventurer a5 = new Adventurer(45, "Parker", "Enchanter", List.of(ParkerSkills), 445);
        Adventurer a6 = new Adventurer(60, "Larry Doe", "Cleric", List.of(LarrySkills), 977);

        //toss them into guilds (not litterally)
        Guild g1 = new Guild("HearthFire",List.of(a1,a2));
        Guild g2 = new Guild("DarkBane",List.of(a4,a5));
        Guild g3 = new Guild("ElderLeaf",List.of(a6,a3));


        //Lambda demonstrations


    }
}