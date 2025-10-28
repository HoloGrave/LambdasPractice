import java.util.*;
import java.util.stream.Collector;
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
        Adventurer a4 = new Adventurer(106, "Hosk Doe", "Necromage", List.of(HoskSkills), 154);
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


        //3. Find the adventurer with the most skills - DONE
        System.out.println("\n\nEx3:");

        //WE ARE GETTING AN OPTIONAL BECAUSE WE COULD NOT HAVE A SINGLE MAX
        Optional<Adventurer> tempvar = Arrays.stream(glist)
                .flatMap(g -> g.getAdventurers().stream())
                .collect(Collectors.toList())
                .stream().max((Comparator.comparing(adventurer -> adventurer.getSkills().size())));

        //Optional wrapper class is a result of the .max() stream method
        //Allows us to handle whatever is present as a result of the .max() method being called
        //Would return null if we have no adventurers, because we do it will rather return the FIRST one in the list that has the most skills
            //!!!In the future it may be a good idea to improve this to allow us to choose between who is max maybe???????????
            //otherwise works for the assignment for now I believe
        System.out.println(tempvar);

        //4. Rank Guilds by average adventurer age - DONE
        //Write a method that ranks guilds in ascending order of their average adventurer age.
        System.out.println("\n\nEx4:");

        List<Guild> templist2 = Arrays.stream(glist)
                .sorted(Comparator.comparingInt(guild -> Math.round((int) guild.getAdventurers().stream()
                                .mapToInt(a -> a.getAge()).average().orElse(0.0))))
                .collect(Collectors.toList());//Collecting the sorted list
        //now the only issue left is the sort function sorts in descending order rather than ascending
        Collections.reverse(templist2); // Reverses the list's data
        templist2.stream().forEach(System.out::println);
        //(int) is required to cast to an int as .average() only works with doubles

        //orElse is also required to provide a default value if the optional double is null, not because there is no values but rather that the stream itself could be null
        //According to stack overflow and AI overviews on the problem
        //https://stackoverflow.com/questions/53525066/why-stream-average-method-returns-optionaldouble-instead-of-double

        //5.Create a skill-wise adventurer count map - DONE
        System.out.println("\n\nEx5:");
        // Write a method that creates and prints a map where the keys are the names of the skills and the values are the number of adventurers proficient in that skill.

        Map<Enum, Integer> varMap = new HashMap<>();
        List<Adventurer> templist3 = Arrays.stream(glist).flatMap(guild -> guild.getAdventurers().stream()).toList();

        //DUMMED DOWN WAY TO DO IT, probably a way to do this with only streams maybe???
        for(Skill skill: Skill.values()){
            varMap.put(skill,templist3.stream().filter(adventurer -> adventurer.skills.contains(skill)).toList().size());
        }
        System.out.println(varMap);


        //6. Bonus Gold event - TODO
        System.out.println("\n\nEx6:");
        // Write a method that grants a 20% bonus gold to all adventurers who have earned less than 1000 gold and prints the updated adventurer list.
        Arrays.stream(glist).flatMap(guild -> guild.getAdventurers().stream())//getting the adventurer stream
                .filter(adventurer -> adventurer.getGoldEarned() < 1000)//filter out all adventurers who have more than 1k gold
                .forEach(adventurer -> {
                    //Add 20% more gold to the remaining adventurers
                    double newGold = adventurer.getGoldEarned() + (adventurer.goldEarned * 0.2);
                    adventurer.setGoldEarned(newGold);
                });
        Arrays.stream(glist).map(Guild::getAdventurers).forEach(adventurers -> System.out.println(adventurers.toString()));
    }
}