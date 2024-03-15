package resources;

//enum is special class in java where we can add collection of constants or methods
public enum ApiResources {

    GetChallengeApi("/api/v1/challenges"),
    AttendChallengeApi("/api/v1/challenges/attend"),
    LeaveChallengeApi("/api/v1/challenges/leave");
    private String resource;
    ApiResources(String resource) {
        this.resource=resource;
    }
    public String getResource(){
        return resource;
    }
}
