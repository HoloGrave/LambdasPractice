import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        Adventurer a6 = new Adventurer(60, "Larry Doe Original - ElderLeaf", "Cleric", List.of(LarrySkills), 977);
        Adventurer a7 = new Adventurer(60, "Larry Doe COPY - HearthFire", "Cleric", List.of(LarrySkills), 977);

        //toss them into guilds (not litterally)
        Guild g1 = new Guild("HearthFire",List.of(a1,a2,a7));
        Guild g2 = new Guild("DarkBane",List.of(a4,a5));
        Guild g3 = new Guild("ElderLeaf",List.of(a6,a3));

        //array containing all the guilds
        Guild[] glist = new Guild[]{g1,g2,g3};

        //Lambda demonstrations
        //1.Filter Adventurers by skill - DONE
        System.out.println("Ex1:");
        //Input - Skill
        //Return - flat list<adventurers> that possess the skill

        Arrays.stream(glist)
                .flatMap(g -> g.getAdventurers().stream())
                // Flatmap to make a flat list of just adventurer objects, no other objects below is what makes it flat
                //calling for each guild in the array to get the adventurers from them
                //however we also need to put that to a stream since we are working with streams right now
                //otherwise flatmap will not work
                .filter(s -> s.skills.contains(Skill.SWORDSMANSHIP))
                .toList()
                .forEach(i -> System.out.println(i));

        //now that we should have our list we print out all of the adventurers that the stream kept
        /*
        THIS DOES NOT WORK SINCE IT IS A LIST RATHER THAN ARRAY
        for(int i = 0; i < returnvar.size(); i++)
            System.out.println(returnvar[i]);
         */
        //DO THIS INSTEAD


        //2.Group adventurers by role - DONE
        //Write a method that groups adventurers across all guilds by their roles (e.g., "Wizard", "Rogue") and prints the groups.
        //END BY PRINT?
        System.out.println("\n\nEx2:");

        Arrays.stream(glist)
                .flatMap(g -> g.getAdventurers().stream())
                .collect(Collectors.groupingBy(a -> a.getRole()))
                .forEach((string,alist) ->
                        System.out.println(string + "s : " + alist.toString()));


        //3. Find the adventurer with the most skills - TODO
        System.out.println("\n\nEx3:");

        //WE ARE GETTING AN OPTIONAL BECAUSE WE COULD NOT HAVE A SINGLE MAX
        Optional<Adventurer> tempvar = Arrays.stream(glist)
                .flatMap(g -> g.getAdventurers().stream())
                .collect(Collectors.toList())
                .stream().max((Comparator.comparing(adventurer -> adventurer.skills.size())));

        //Optional wrapper class is a result of the .max() stream method
        //Allows us to handle whatever is present as a result of the .max() method being called
        //Would return null if we have no adventurers, because we do it will rather return the FIRST one in the list that has the most skills
            //!!!In the future it may be a good idea to improve this to allow us to choose between who is max maybe???????????
            //otherwise works for the assignment for now I believe
        System.out.println(tempvar);

        //4. Rank Guilds by average adventurer age - TODO
        System.out.println("\n\nEx4:");

        Arrays.stream(glist)
                .map(Guild :: getAdventurers)

        ;

        //5.Create a skill-wise adventurer count map - TODO
        System.out.println("\n\nEx5:");

        //6. Bonus Gold event - TODO
        System.out.println("\n\nEx6:");

    }
}