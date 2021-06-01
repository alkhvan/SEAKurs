package de.telekom.sea;

public enum Salutation {
    MR,
    MRS,
    DIVERS;

    public static Salutation fromString(String string) throws IllegalAccessException {
        switch (string.toUpperCase()) {
            case "women":
            case "w":
                return MRS;
            case "men":
            case "m":
                return MR;
            case "d":
            case "divers":
                return DIVERS;
            default:
                throw new IllegalAccessException("Unexpected value: " + string);

        }
    }

    @Override
    public String toString() {
        switch (this) {
            case MRS:
                return "Woman";
            case MR:
                return "Men";
            case DIVERS:
                return "Diverse";
            default:
                return "Diverse";
        }
    }
}
