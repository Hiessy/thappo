package org.thappo.commons.model;

public class Cause {

    private String value;
    private String label;

    public Cause(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }


    public static class Builder {

        private String value;
        private String label;

        public void setValue(String value) {
            this.value = value;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Cause build() {
            return new Cause(this.value, this.label);
        }

    }

    @Override
    public String toString() {
        return "Cause [value=" + this.value + ", label=" + this.label + "]";
    }

}
