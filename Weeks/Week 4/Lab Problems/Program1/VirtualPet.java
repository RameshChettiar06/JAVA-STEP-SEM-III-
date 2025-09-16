import java.util.Random;
import java.util.UUID;

public class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private int evolutionStageIndex;
    private boolean isGhost;

    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;

    // Default constructor: Mysterious egg with random species
    public VirtualPet() {
        this("Mysterious", getRandomSpecies(), 0, 50, 50, 0);
    }

    // Constructor with name only: Starts as Baby
    public VirtualPet(String name) {
        this(name, getRandomSpecies(), 1, 60, 60, 1);
    }

    // Constructor with name and species: Starts as Child
    public VirtualPet(String name, String species) {
        this(name, species, 3, 70, 70, 2);
    }

    // Full constructor
    public VirtualPet(String name, String species, int age, int happiness, int health, int stageIndex) {
        this.petId = generatePetId();
        this.petName = name;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStageIndex = stageIndex;
        this.isGhost = false;
        totalPetsCreated++;
    }

    private static String getRandomSpecies() {
        String[] speciesArray = {"Dragon", "Unicorn", "Phoenix", "Griffin"};
        return speciesArray[new Random().nextInt(speciesArray.length)];
    }

    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    public void evolvePet() {
        if (isGhost) return;

        if (health <= 0) {
            isGhost = true;
            species = "Ghost";
            System.out.println(petName + " has died and became a Ghost.");
            return;
        }

        if (age > 1 && evolutionStageIndex < EVOLUTION_STAGES.length - 1) {
            evolutionStageIndex++;
            System.out.println(petName + " has evolved to stage: " + getPetStatus());
        }
    }

    public void feedPet() {
        if (isGhost) return;
        health = Math.min(100, health + 10);
        System.out.println(petName + " has been fed. Health is now: " + health);
    }

    public void playWithPet() {
        if (isGhost) return;
        happiness = Math.min(100, happiness + 10);
        System.out.println(petName + " played happily. Happiness is now: " + happiness);
    }

    public void healPet() {
        if (isGhost) return;
        health = Math.min(100, health + 15);
        System.out.println(petName + " has been healed. Health is now: " + health);
    }

    public void simulateDay() {
        if (isGhost) return;

        age++;
        happiness -= new Random().nextInt(10);
        health -= new Random().nextInt(10);

        if (happiness < 0) happiness = 0;
        if (health < 0) health = 0;

        System.out.println(petName + " is now " + age + " days old. Happiness: " + happiness + ", Health: " + health);

        evolvePet();
    }

    public String getPetStatus() {
        return isGhost ? "Ghost" : EVOLUTION_STAGES[evolutionStageIndex];
    }

    public String getPetInfo() {
        return "ID: " + petId + ", Name: " + petName + ", Species: " + species + ", Age: " + age + ", Happiness: " + happiness + ", Health: " + health + ", Stage: " + getPetStatus();
    }
}
