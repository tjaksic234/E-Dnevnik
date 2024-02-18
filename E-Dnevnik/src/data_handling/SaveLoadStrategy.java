package data_handling;

public interface SaveLoadStrategy {

    <E> void save(E content, String filePath);

    <E> E load(String filePath);
}
