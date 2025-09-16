import java.util.Arrays;

abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    public MagicalStructure(String structureName, int magicPower, String location) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = true;
    }

    public abstract String castMagicSpell();

    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
            return true; // Knowledge boost
        }
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) {
            return true; // Dragon guard
        }
        return false;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (!attacker.isActive || !defender.isActive) {
            return "One of the structures is inactive.";
        }

        int attackPower = attacker.magicPower;
        int defensePower = defender.magicPower;

        if (attacker instanceof WizardTower && defender instanceof MysticLibrary) {
            attackPower *= 2;
        } else if (attacker instanceof EnchantedCastle && defender instanceof DragonLair) {
            defensePower *= 3;
        }

        return attackPower > defensePower ? attacker.structureName + " wins the battle!" :
               (attackPower < defensePower ? defender.structureName + " defends successfully!" :
               "It's a tie!");
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int totalPower = 0;
        int wizardTowers = 0;

        for (MagicalStructure s : structures) {
            totalPower += s.magicPower;
            if (s instanceof WizardTower) wizardTowers++;
        }

        if (wizardTowers >= 2) {
            totalPower += wizardTowers * 50;  // Magic network bonus
        }

        return totalPower;
    }

    public String getStructureInfo() {
        return structureName + " (" + location + ") - Power: " + magicPower + ", Active: " + isActive;
    }
}

class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower(String structureName, int magicPower, String location) {
        this(structureName, magicPower, location, 10, new String[]{"Basic Spell"});
    }

    public WizardTower(String structureName, int magicPower, String location, int spellCapacity, String[] knownSpells) {
        super(structureName, magicPower, location);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }

    @Override
    public String castMagicSpell() {
        return structureName + " casts powerful spells: " + Arrays.toString(knownSpells);
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String structureName, int magicPower, String location, int defenseRating, boolean hasDrawbridge) {
        super(structureName, magicPower, location);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    @Override
    public String castMagicSpell() {
        return structureName + " casts a protective barrier!";
    }
}

class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary(String structureName, int magicPower, String location, int bookCount, String ancientLanguage) {
        super(structureName, magicPower, location);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }

    @Override
    public String castMagicSpell() {
        return structureName + " reveals ancient secrets in " + ancientLanguage;
    }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair(String structureName, int magicPower, String location, String dragonType, int treasureValue) {
        super(structureName, magicPower, location);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    public String castMagicSpell() {
        return structureName + " breathes " + dragonType + " fire!";
    }
}
