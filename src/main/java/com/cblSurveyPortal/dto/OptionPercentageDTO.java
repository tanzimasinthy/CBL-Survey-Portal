package com.cblSurveyPortal.dto;

import java.io.Serializable;

public class OptionPercentageDTO implements Serializable {

    private static final long serialVersionUID = -7338047997792280285L;

    private String optionTag;
    private double optionValue;
    private double optionValueInPercent;

    public OptionPercentageDTO() {
    }

    public OptionPercentageDTO(String optionTag, double optionValue, double optionValueInPercent) {
        this.optionTag = optionTag;
        this.optionValue = optionValue;
        this.optionValueInPercent = optionValueInPercent;
    }

    public String getOptionTag() {
        return optionTag;
    }

    public void setOptionTag(String optionTag) {
        this.optionTag = optionTag;
    }

    public double getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(double optionValue) {
        this.optionValue = optionValue;
    }

    public double getOptionValueInPercent() {
        return optionValueInPercent;
    }

    public void setOptionValueInPercent(double optionValueInPercent) {
        this.optionValueInPercent = optionValueInPercent;
    }
}
