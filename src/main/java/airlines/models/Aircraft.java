package main.java.airlines.models;

public class Aircraft {
    private int id;
    private AirplaneClass _class;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AirplaneClass get_class() {
        return _class;
    }

    public void set_class(AirplaneClass _class) {
        this._class = _class;
    }
}
