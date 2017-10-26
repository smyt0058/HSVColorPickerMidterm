package model;

import java.util.Observable;

/**
 * HSV Color Model
 * <p>
 * Gets/Sets and controls HSV values
 *
 * @author Jason Smyth (smyt0058@algonquinlive.com)
 * @version 1.0
 */

public class HSVModel extends Observable {

    private static final Integer MAX_HUE = 359;
    private static final Integer MAX_SAT = 100;
    private static final Integer MAX_VAL = 100;
    private static final Integer MIN_HUE = 0;
    private static final Integer MIN_SAT = 0;
    private static final Integer MIN_VAL = 0;

    private Integer hue;
    private Integer sat;
    private Integer val;

    /**
     * Default constructor (sets to black)
     */
    public HSVModel() {
        this(MIN_HUE, MIN_SAT, MIN_VAL);
    }

    /**
     * Overloaded constructor (sets to given HSV value)
     *
     * @param hue
     * @param sat
     * @param val
     */
    private HSVModel(Integer hue, Integer sat, Integer val) {
        super();
        setHSV(hue, sat, val);
    }

    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }

    // Getters
    public Integer getHue() {
        return hue;
    }

    public Integer getSaturation() {
        return sat;
    }

    public Integer getValue() {
        return val;
    }

    // Setters
    public void setAsBlack() {
        setHSV(MIN_HUE, MIN_SAT, MIN_VAL);
    }

    public void setAsRed() {
        setHSV(MIN_HUE, MAX_SAT, MAX_VAL);
    }

    public void setAsLime() {
        setHSV(120, 76, 80);
    }

    public void setAsBlue() {
        setHSV(240, MAX_SAT, MAX_VAL);
    }

    public void setAsYellow() {
        setHSV(60, MAX_SAT, MAX_VAL);
    }

    public void setAsCyan() {
        setHSV(180, MAX_SAT, MAX_VAL);
    }

    public void setAsMagenta() {
        setHSV(300, MAX_SAT, MAX_VAL);
    }

    public void setAsSilver() {
        setHSV(MIN_HUE, MIN_SAT, 75);
    }

    public void setAsGray() {
        setHSV(MIN_HUE, MIN_SAT, 50);
    }

    public void setAsMaroon() {
        setHSV(MIN_HUE, MAX_SAT, 50);
    }

    public void setAsOlive() {
        setHSV(60, MAX_SAT, 50);
    }

    public void setAsGreen() {
        setHSV(120, MAX_SAT, 50);
    }

    public void setAsPurple() {
        setHSV(300, MAX_SAT, 50);
    }

    public void setAsTeal() {
        setHSV(180, MAX_SAT, 50);
    }

    public void setAsNavy() {
        setHSV(240, MAX_SAT, 50);
    }

    public void setHue(Integer hue) {
        if (hue <= MAX_HUE && hue >= MIN_HUE) {
            this.hue = hue;
        }
        this.updateObservers();
    }

    public void setSaturation(Integer sat) {
        if (sat <= MAX_SAT && sat >= MIN_SAT) {
            this.sat = sat;
        }
        this.updateObservers();
    }

    public void setValue(Integer val) {
        if (val <= MAX_VAL && val >= MIN_VAL) {
            this.val = val;
        }
        this.updateObservers();
    }

    public void setHSV(Integer hue, Integer sat, Integer val) {
        setHue(hue);
        setSaturation(sat);
        setValue(val);
    }

}

