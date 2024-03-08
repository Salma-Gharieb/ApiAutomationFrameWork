package resources;

import pojo.AttendChallenge;

public class TestDataBuild {

    public AttendChallenge joinChallengePayload() {

        AttendChallenge ac = new AttendChallenge();
        ac.setSignature("");
        ac.setChallenge_id("mrQ");

        return ac;
    }
}
