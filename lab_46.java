import java.util.ArrayList;

// Interface
interface MachineOperations {
    void start();
    void stop();
}

// Abstract class
abstract class VotingMachine implements MachineOperations {
    String id;
    String location;
    
    VotingMachine(String id, String location) {
        this.id = id;
        this.location = location;
    }
    
    void showInfo() {
        System.out.println("Machine: " + id);
        System.out.println("Location: " + location);
    }
}

// EVM class
class EVM extends VotingMachine {
    int battery;
    
    EVM(String id, String location, int battery) {
        super(id, location);
        this.battery = battery;
    }
    
    @Override
    public void start() {
        System.out.println("EVM " + id + " starting...");
        System.out.println("Battery: " + battery + "%");
        System.out.println("Ready for voting!");
    }
    
    @Override
    public void stop() {
        System.out.println("EVM " + id + " stopping...");
        System.out.println("Data saved!");
    }
}

// BVM class
class BVM extends VotingMachine {
    int ballots;
    
    BVM(String id, String location, int ballots) {
        super(id, location);
        this.ballots = ballots;
    }
    
    @Override
    public void start() {
        System.out.println("BVM " + id + " starting...");
        System.out.println("Ballots: " + ballots);
        System.out.println("Ready for voting!");
    }
    
    @Override
    public void stop() {
        System.out.println("BVM " + id + " stopping...");
        System.out.println("Ballots counted!");
    }
}

// Main class
public class lab_46 {
    public static void main(String[] args) {
        
        // Create ArrayList
        ArrayList<VotingMachine> machines = new ArrayList<>();
        
        // Add machines to ArrayList
        machines.add(new EVM("EVM-001", "Dhaka Center", 80));
        machines.add(new EVM("EVM-002", "Chittagong", 60));
        machines.add(new BVM("BVM-001", "Rajshahi", 1000));
        machines.add(new BVM("BVM-002", "Khulna", 500));
        
        System.out.println("=== VOTING MACHINE SYSTEM ===\n");
        
        // 1. Show all machines
        System.out.println("All Voting Machines:");
        System.out.println("-------------------");
        for(VotingMachine m : machines) {
            m.showInfo();
            System.out.println();
        }
        
        // 2. Start all machines
        System.out.println("\nStarting Machines:");
        System.out.println("-----------------");
        for(VotingMachine m : machines) {
            m.start();
            System.out.println();
        }
        
        // 3. Stop all machines
        System.out.println("\nStopping Machines:");
        System.out.println("-----------------");
        for(VotingMachine m : machines) {
            m.stop();
            System.out.println();
        }
        
        // 4. Count machines
        System.out.println("\nMachine Count:");
        System.out.println("--------------");
        int evmCount = 0;
        int bvmCount = 0;
        
        for(VotingMachine m : machines) {
            if(m instanceof EVM) {
                evmCount++;
            } else if(m instanceof BVM) {
                bvmCount++;
            }
        }
        
        System.out.println("Total: " + machines.size());
        System.out.println("EVM: " + evmCount);
        System.out.println("BVM: " + bvmCount);
        
        // 5. Add more machines
        System.out.println("\nAdding more machines...");
        machines.add(new EVM("EVM-003", "Sylhet", 90));
        machines.add(new BVM("BVM-003", "Barisal", 800));
        
        System.out.println("Now total: " + machines.size());
    }
}