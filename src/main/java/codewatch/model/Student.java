package codewatch.model;

public class Student {

    private int id;
    private String name;
    private String leetcodeUsername;
    private String email;
    private String batch;
    private int easySolved;
    private int mediumSolved;
    private int hardSolved;
    private int totalSolved;
    private int lcRanking;
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeetcodeUsername() {
        return leetcodeUsername;
    }

    public void setLeetcodeUsername(String leetcodeUsername) {
        this.leetcodeUsername = leetcodeUsername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
    public int getEasySolved()
    {
    	return easySolved;
    }
    public void setEasySolved(int easySolved)
    {
    	this.easySolved=easySolved;
    }
    public int getMediumSolved()
    {
    	return mediumSolved;
    }
    public void setMediumSolved(int mediumSolved)
    {
    	this.mediumSolved=mediumSolved;
    }
    public int getHardSolved()
    {
    	return hardSolved;
    }
    public void setHardSolved(int hardSolved)
    {
    this.hardSolved=hardSolved;	
    }
    public int getTotalSolved()
    {
    	return totalSolved;
    }
    public void setTotalSolved(int totalSolved)
    {
    	this.totalSolved=totalSolved;
    }
    public int getRank()
    {
    	return lcRanking;
    }
    public void setRank(int lcRanking)
    {
    	this.lcRanking=lcRanking;
    }
}