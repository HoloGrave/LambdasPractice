import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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

        //array containing all the guilds
        Guild[] glist = new Guild[]{g1,g2,g3};

        //Lambda demonstrations
        //1.Filter Adventurers by skill - DONE
        //Input - Skill
        //Return - flat list<adventurers> that possess the skill

        var returnvar = Arrays.stream(glist)
                .flatMap(g -> g.getAdventurers().stream())
                // Flatmap to make a flat list of just adventurer objects, no other objects below is what makes it flat
                //calling for each guild in the array to get the adventurers from them
                //however we also need to put that to a stream since we are working with streams right now
                //otherwise flatmap will not work
                .filter(s -> s.skills.contains(Skill.SWORDSMANSHIP))
                .toList();

        //now that we should have our list we print out all of the adventurers that the stream kept
        /*
        THIS DOES NOT WORK SINCE IT IS A LIST RATHER THAN ARRAY
        for(int i = 0; i < returnvar.size(); i++)
            System.out.println(returnvar[i]);
         */
        //DO THIS INSTEAD
        returnvar.forEach(i -> System.out.println(i));


        //2.Group adventurers by role - TODO


        //3. Find the adventurer with the most skills - TODO


        //4. Rank Guilds by average adventurer age - TODO


        //5.Create a skill-wise adventurer count map - TODO


        //6. Bonus Gold event - TODO


    }
}