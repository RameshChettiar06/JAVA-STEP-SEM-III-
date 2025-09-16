public class Program2 {
    public static void main(String[] args) {
        MagicalStructure[] structures = new MagicalStructure[5];

        structures[0] = new WizardTower("Wizard Tower Alpha", 100, "North", 50, new String[]{"Fireball", "Teleport"});
        structures[1] = new EnchantedCastle("Royal Enchanted Castle", 150, "East", 300, true);
        structures[2] = new MysticLibrary("Ancient Library", 80, "West", 5000, "Elder Tongue");
        structures[3] = new DragonLair("Dragon's Den", 200, "South", "Fire Drake", 10000);
        structures[4] = new WizardTower("Simple Tower", 60, "Central");

        System.out.println("=== Kingdom Structure Info ===");
        for (MagicalStructure structure : structures) {
            System.out.println(structure.getStructureInfo());
        }

        System.out.println("\n=== Magic Interactions ===");
        System.out.println(MagicalStructure.performMagicBattle(structures[0], structures[1]));
        System.out.println(MagicalStructure.performMagicBattle(structures[1], structures[3]));
        System.out.println(MagicalStructure.performMagicBattle(structures[0], structures[2]));

        System.out.println("\nTotal Kingdom Magic Power: " + MagicalStructure.calculateKingdomMagicPower(structures));

        System.out.println("\nSpecial Interactions:");
        System.out.println("Can structures[0] and structures[2] interact? " +
                MagicalStructure.canStructuresInteract(structures[0], structures[2]));
    }
}
