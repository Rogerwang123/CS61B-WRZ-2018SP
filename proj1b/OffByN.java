public class OffByN implements CharacterComparator{

    private int deviateN;
    public OffByN(int N) {
        this.deviateN = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == this.deviateN;
    }
}
