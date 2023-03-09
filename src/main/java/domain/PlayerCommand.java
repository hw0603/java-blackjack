package domain;

public enum PlayerCommand {

    HIT,
    STAND;

    public static PlayerCommand from(final boolean isHit) {
        if (isHit) {
            return HIT;
        }
        return STAND;
    }

    public boolean isHit() {
        return this.equals(HIT);
    }
}
