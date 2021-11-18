package com.cblSurveyPortal.dto;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

public class AnsPercentageReportDTO implements Serializable {

    private static final long serialVersionUID = -7338047997792280285L;

    private ObjectId questionId;
    private String questionTitle;
    private List<OptionPercentageDTO> optionList;

    public AnsPercentageReportDTO() {
    }

    public AnsPercentageReportDTO(ObjectId questionId, String questionTitle, List<OptionPercentageDTO> optionList) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.optionList = optionList;
    }

    public ObjectId getQuestionId() {
        return questionId;
    }

    public void setQuestionId(ObjectId questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public List<OptionPercentageDTO> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionPercentageDTO> optionList) {
        this.optionList = optionList;
    }
}
