package model;

import javax.swing.*;
import java.util.ArrayList;

public class DataManager<E> {

    private ArrayList<E> data;

    public DataManager() {
        this.data = new ArrayList<>();
    }

    public ArrayList<E> getData() {
        return data;
    }

    public void setData(ArrayList<E> data) {
        this.data = data;
    }

    public void addEntity(E data) {
        if (data != null && !this.data.contains(data)) {
            this.data.add(data);
        } else {
            JOptionPane.showMessageDialog(null, "Entity already exists in the database.");
        }
    }

    public void removeEntity(E data) {
        if (this.data.contains(data)) {
            this.data.remove(data);
        } else {
            JOptionPane.showMessageDialog(null, "Entity does not exist in the database.");
        }
    }

    public void removeLastAddedEntity() {
        data.remove(data.size() - 1);
    }
}
