package resources;

import pojo.AttendChallenge;
import pojo.LeaveChallenge;
import stepDefinations.Hooks;

public class TestDataBuild {

    public AttendChallenge joinChallengePayload() {

        AttendChallenge ac = new AttendChallenge();
        ac.setSignature("");
        ac.setChallenge_id("mrQ");

        return ac;
    }

    public LeaveChallenge leaveChallengePayload() {

        LeaveChallenge lc = new LeaveChallenge();
        lc.setSignature("");
        lc.setChallenge_id("mrQ");

        return lc;
    }
}
