public class Players extends Characters {
    private String gender;
    private String name;
    private int monsterSlain;
    private String inventory[];
    public void setName(String name)
    {
        this.name = name;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public String getName()
    {
        return name;
    }
    public String getGender()
    {
        return gender;
    }
}
