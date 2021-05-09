package uk.co.tencil.Questions;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class QuestionsResponse {
    @SerializedName("userApiKey")
    String userApikey;
    @SerializedName("userid")
    private String userid;
    @SerializedName("q1")
    private long q1;
    @SerializedName("q2")
    private long q2;
    @SerializedName("q3")
    private long q3;
    @SerializedName("q4")
    private long q4;
    @SerializedName("q5")
    private long q5;
    @SerializedName("q6")
    private long q6;
    @SerializedName("q7")
    private long q7;
    @SerializedName("q8")
    private long q8;
    @SerializedName("q9")
    private long q9;
    @SerializedName("q10")
    private long q10;
    @SerializedName("q11")
    private long q11;
    @SerializedName("q12")
    private long q12;
    @SerializedName("q13")
    private long q13;
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

    public long getQ1() {
        return q1;
    }

    public void setQ1(long q1) {
        this.q1 = q1;
    }

    public long getQ2() {
        return q2;
    }

    public void setQ2(long q2) {
        this.q2 = q2;
    }

    public long getQ3() {
        return q3;
    }

    public void setQ3(long q3) {
        this.q3 = q3;
    }

    public long getQ4() {
        return q4;
    }

    public void setQ4(long q4) {
        this.q4 = q4;
    }

    public long getQ5() {
        return q5;
    }

    public void setQ5(long q5) {
        this.q5 = q5;
    }

    public long getQ6() {
        return q6;
    }

    public void setQ6(long q6) {
        this.q6 = q6;
    }

    public long getQ7() {
        return q7;
    }

    public void setQ7(long q7) {
        this.q7 = q7;
    }

    public long getQ8() {
        return q8;
    }

    public void setQ8(long q8) {
        this.q8 = q8;
    }

    public long getQ9() {
        return q9;
    }

    public void setQ9(long q9) {
        this.q9 = q9;
    }

    public long getQ10() {
        return q10;
    }

    public void setQ10(long q10) {
        this.q10 = q10;
    }

    public long getQ11() {
        return q11;
    }

    public void setQ11(long q11) {
        this.q11 = q11;
    }

    public long getQ12() {
        return q12;
    }

    public void setQ12(long q12) {
        this.q12 = q12;
    }

    public long getQ13() {
        return q13;
    }

    public void setQ13(long q13) {
        this.q13 = q13;
    }

    public String getUserApikey() {
        return userApikey;
    }

    public void setUserApikey(String userApikey) {
        this.userApikey = userApikey;
    }
}
