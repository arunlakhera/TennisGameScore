package com.example.android.tennisgamescore;

public class Player {

    private String m_PlayerName;
    private Integer m_Set1;
    private Integer m_Set2;
    private Integer m_Set3;

    private Integer m_CurrentScore;
    private Integer m_Ace;
    private Integer m_Forced;
    private Integer m_Unforced;

    private String set1Flag;
    private String set2Flag;
    private String set3Flag;


    Player(){
        m_PlayerName = "Name";
        m_Set1 = 0;
        m_Set2 = 0;
        m_Set3 = 0;

        m_CurrentScore = 0;
        m_Ace = 0;
        m_Forced = 0;
        m_Unforced = 0;

        set1Flag = "I";
        set2Flag = "I";
        set3Flag = "I";
    }

    public String getM_PlayerName() {
        return m_PlayerName;
    }

    public void setM_PlayerName(String m_PlayerName) {
        this.m_PlayerName = m_PlayerName;
    }

    public Integer getM_Set1() {
        return m_Set1;
    }

    public void setM_Set1(Integer m_Set1) {
        this.m_Set1 = m_Set1;
    }

    public Integer getM_Set2() {
        return m_Set2;
    }

    public void setM_Set2(Integer m_Set2) {
        this.m_Set2 = m_Set2;
    }

    public Integer getM_Set3() {
        return m_Set3;
    }

    public void setM_Set3(Integer m_Set3) {
        this.m_Set3 = m_Set3;
    }

    public Integer getM_CurrentScore() {
        return m_CurrentScore;
    }

    public void setM_CurrentScore(Integer m_CurrentScore) {
        this.m_CurrentScore = m_CurrentScore;
    }

    public Integer getM_Ace() {
        return m_Ace;
    }

    public void setM_Ace(Integer m_Ace) {
        this.m_Ace = m_Ace;
    }

    public Integer getM_Forced() {
        return m_Forced;
    }

    public void setM_Forced(Integer m_Forced) {
        this.m_Forced = m_Forced;
    }

    public Integer getM_Unforced() {
        return m_Unforced;
    }

    public void setM_Unforced(Integer m_Unforced) {
        this.m_Unforced = m_Unforced;
    }

    public String getSet1Flag() {
        return set1Flag;
    }

    public void setSet1Flag(String set1Flag) {
        this.set1Flag = set1Flag;
    }

    public String getSet2Flag() {
        return set2Flag;
    }

    public void setSet2Flag(String set2Flag) {
        this.set2Flag = set2Flag;
    }

    public String getSet3Flag() {
        return set3Flag;
    }

    public void setSet3Flag(String set3Flag) {
        this.set3Flag = set3Flag;
    }
}
