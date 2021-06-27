package uk.co.tencil.Questions;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class QuestionsResponse {
    @SerializedName("userApiKey")
    String userApikey;
    @SerializedName("uid")
    private String userid;
    @SerializedName("1")
    private String q1;
    @SerializedName("2")
    private String q2;
    @SerializedName("3")
    private String q3;
    @SerializedName("4")
    private String q4;
    @SerializedName("5")
    private String q5;
    @SerializedName("6")
    private String q6;
    @SerializedName("7")
    private String q7;
    @SerializedName("8")
    private String q8;
    @SerializedName("9")
    private String q9;
    @SerializedName("10")
    private String q10;
    @SerializedName("11")
    private String q11;
    @SerializedName("12")
    private String q12;
    @SerializedName("13")
    private String q13;
    @SerializedName("qid")
    private String qid;

    @NonNull
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7;
    }

    public String getQ8() {
        return q8;
    }

    public void setQ8(String q8) {
        this.q8 = q8;
    }

    public String getQ9() {
        return q9;
    }

    public void setQ9(String q9) {
        this.q9 = q9;
    }

    public String getQ10() {
        return q10;
    }

    public void setQ10(String q10) {
        this.q10 = q10;
    }

    public String getQ11() {
        return q11;
    }

    public void setQ11(String q11) {
        this.q11 = q11;
    }

    public String getQ12() {
        return q12;
    }

    public void setQ12(String q12) {
        this.q12 = q12;
    }

    public String getQ13() {
        return q13;
    }

    public void setQ13(String q13) {
        this.q13 = q13;
    }

    public String getUserApikey() {
        return userApikey;
    }

    public void setUserApikey(String userApikey) {
        this.userApikey = userApikey;
    }
}
