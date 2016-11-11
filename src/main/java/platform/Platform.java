package platform;

/**
 * Created by c1mnf3tddty3 on 9/28/15.
 */
public class Platform {
    private String platformName;

    public Platform(){
        this.getPlatformName();
    }

    public Platform(String platformName){
        this.setPlatformName(platformName);
        this.getPlatformName();
    }

    public void setPlatformName(String platformName){
        this.platformName = platformName;
    }

    public String getPlatformName(){
        return platformName;
    }
}
