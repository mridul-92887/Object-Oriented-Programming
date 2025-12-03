import java.util.ArrayList;

// Abstract Class
abstract class Candidate {
    int candidateID;
    String name;
    String party;
    
    Candidate(int candidateID, String name, String party) {
        this.candidateID = candidateID;
        this.name = name;
        this.party = party;
    }
    
    // Abstract method - must be implemented by subclasses
    abstract void displayInfo();
    
    // Concrete method - common for all
    void showBasicInfo() {
        System.out.println("ID: " + candidateID + " | Name: " + name);
    }
}

// Subclass 1: Local Candidate
class LocalCandidate extends Candidate {
    String constituency;
    
    LocalCandidate(int candidateID, String name, String party, String constituency) {
        super(candidateID, name, party);
        this.constituency = constituency;
    }
    
    // Method Overriding
    @Override
    void displayInfo() {
        System.out.println("=== LOCAL CANDIDATE ===");
        showBasicInfo();
        System.out.println("Party: " + party);
        System.out.println("Constituency: " + constituency);
        System.out.println("Type: Local Election Candidate");
        System.out.println();
    }
}

// Subclass 2: National Candidate
class NationalCandidate extends Candidate {
    String region;
    int numberOfDistricts;
    
    NationalCandidate(int candidateID, String name, String party, String region, int numberOfDistricts) {
        super(candidateID, name, party);
        this.region = region;
        this.numberOfDistricts = numberOfDistricts;
    }
    
    // Method Overriding
    @Override
    void displayInfo() {
        System.out.println("=== NATIONAL CANDIDATE ===");
        showBasicInfo();
        System.out.println("Party: " + party);
        System.out.println("Region: " + region);
        System.out.println("Districts Covered: " + numberOfDistricts);
        System.out.println("Type: National Election Candidate");
        System.out.println();
    }
}

// Main class
public class lab_45 {
    public static void main(String[] args) {
        
        System.out.println("=== BANGLADESH ELECTION COMMISSION ===\n");
        
        // Create candidates
        Candidate candidate1 = new LocalCandidate(101, "Abdul Karim", "Bangladesh Awami League", "Dhaka-8");
        Candidate candidate2 = new LocalCandidate(102, "Fatema Begum", "Bangladesh Nationalist Party", "Chittagong-5");
        Candidate candidate3 = new NationalCandidate(201, "Mohammad Ali", "Bangladesh Awami League", "Dhaka Division", 13);
        Candidate candidate4 = new NationalCandidate(202, "Rahman Khan", "Jatiya Party", "Rajshahi Division", 16);
        
        // A. Display basic information
        System.out.println("A. BASIC CANDIDATE INFORMATION:");
        System.out.println("--------------------------------");
        candidate1.showBasicInfo();
        candidate2.showBasicInfo();
        candidate3.showBasicInfo();
        candidate4.showBasicInfo();
        
        System.out.println("\n\nB. DETAILED INFORMATION (POLYMORPHISM):");
        System.out.println("--------------------------------------");
        
        // Using ArrayList for polymorphism
        ArrayList<Candidate> allCandidates = new ArrayList<>();
        allCandidates.add(candidate1);
        allCandidates.add(candidate2);
        allCandidates.add(candidate3);
        allCandidates.add(candidate4);
        
        // B. Demonstrate polymorphism
        for(Candidate candidate : allCandidates) {
            candidate.displayInfo();  // Same method, different behavior
        }
        
        // C. Show summary
        System.out.println("C. ELECTION SUMMARY:");
        System.out.println("-------------------");
        
        int localCount = 0;
        int nationalCount = 0;
        
        for(Candidate candidate : allCandidates) {
            if(candidate instanceof LocalCandidate) {
                localCount++;
            } else if(candidate instanceof NationalCandidate) {
                nationalCount++;
            }
        }
        
        System.out.println("Total Candidates: " + allCandidates.size());
        System.out.println("Local Candidates: " + localCount);
        System.out.println("National Candidates: " + nationalCount);
        System.out.println("\n=== ELECTION COMMISSION OF BANGLADESH ===");
    }
}