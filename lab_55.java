class MembershipProfile {
    private String membershipType;
    private String attendanceHistory;
    private Member member;

    public MembershipProfile(String membershipType) {
        this.membershipType = membershipType;
        this.attendanceHistory = "";
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void addAttendance(String sessionName) {
        attendanceHistory += sessionName + " ";
    }

    public void showProfile() {
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Attendance History: " + attendanceHistory);
        System.out.println("Belongs to: " + member.getName());
    }
}

class Member {
    private String name;
    private MembershipProfile profile;

    public Member(String name, MembershipProfile profile) {
        this.name = name;
        this.profile = profile;
        profile.setMember(this);
    }

    public String getName() {
        return name;
    }

    public MembershipProfile getProfile() {
        return profile;
    }
}

class YogaSession {
    private String sessionName;
    private String trainerName;
    private String schedule;
    private Member member;

    public YogaSession(String sessionName, String trainerName, String schedule) {
        this.sessionName = sessionName;
        this.trainerName = trainerName;
        this.schedule = schedule;
    }

    public void addMember(Member member) {
        this.member = member;
        member.getProfile().addAttendance(sessionName);
    }

    public void showSession() {
        System.out.println("Session: " + sessionName);
        System.out.println("Trainer: " + trainerName);
        System.out.println("Schedule: " + schedule);
    }
}

public class lab_55 {
    public static void main(String[] args) {

        MembershipProfile profile = new MembershipProfile("Premium");
        Member rafi = new Member("Rafi", profile);

        YogaSession yoga = new YogaSession("Morning Yoga", "Anika", "7:00 AM");

        yoga.addMember(rafi);

        yoga.showSession();
        rafi.getProfile().showProfile();
    }
}
