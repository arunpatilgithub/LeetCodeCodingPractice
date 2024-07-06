package proofpoint;

public class WordCount {

    private int count;
    private String word;

    public WordCount(int count, String word) {
        this.count = count;
        this.word = word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }
}
