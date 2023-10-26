
package ru.training.at.hw8.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class LabelNames {

    @SerializedName("purple")
    @Expose
    private String purple;

    public String getPurple() {
        return purple;
    }

    public void setPurple(String purple) {
        this.purple = purple;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LabelNames.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("purple");
        sb.append('=');
        sb.append(((this.purple == null)?"<null>":this.purple));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31)+((this.purple == null)? 0 :this.purple.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LabelNames) == false) {
            return false;
        }
        LabelNames rhs = ((LabelNames) other);
        return ((this.purple == rhs.purple)||((this.purple!= null)&&this.purple.equals(rhs.purple)));
    }

}
