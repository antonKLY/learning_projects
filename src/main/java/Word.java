public class Word {

    String word;
    String partOfSpeech;

    public Word(String word, String partOfSpeech){
        this.word = word;
        this.partOfSpeech = partOfSpeech;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                '}';
    }
}
