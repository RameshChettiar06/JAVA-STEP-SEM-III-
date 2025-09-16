public class Program1 {
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Fluffy");
        VirtualPet pet3 = new VirtualPet("Spark", "Dragon");

        VirtualPet[] pets = {pet1, pet2, pet3};

        System.out.println("Initial Pet Statuses:");
        for (VirtualPet pet : pets) {
            System.out.println(pet.getPetInfo());
        }

        // Simulate several days
        for (int day = 1; day <= 5; day++) {
            System.out.println("\n=== Day " + day + " ===");
            for (VirtualPet pet : pets) {
                pet.simulateDay();
                pet.feedPet();
                pet.playWithPet();
                pet.healPet();
                System.out.println(pet.getPetInfo());
            }
        }
    }
}
