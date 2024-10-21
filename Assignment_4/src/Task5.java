abstract class Approver {
    protected Approver nextApprover;

    public void setNext(Approver next) {
        this.nextApprover = next;
    }

    public abstract void handleRequest(ExpenseRequest request);
}

class TeamLead extends Approver {
    public void handleRequest(ExpenseRequest request) {
        if (request.getAmount() < 1000) {
            System.out.println("TeamLead approved $" + request.getAmount() + " for " + request.getPurpose());
        } else if (nextApprover != null) {
            nextApprover.handleRequest(request);
        }
    }
}

class Manager extends Approver {
    public void handleRequest(ExpenseRequest request) {
        if (request.getAmount() < 5000) {
            System.out.println("Manager approved $" + request.getAmount() + " for " + request.getPurpose());
        } else if (nextApprover != null) {
            nextApprover.handleRequest(request);
        }
    }
}

class Director extends Approver {
    public void handleRequest(ExpenseRequest request) {
        if (request.getAmount() < 10000) {
            System.out.println("Director approved $" + request.getAmount() + " for " + request.getPurpose());
        } else if (nextApprover != null) {
            nextApprover.handleRequest(request);
        }
    }
}

class CEO extends Approver {
    public void handleRequest(ExpenseRequest request) {
        System.out.println("CEO approved $" + request.getAmount() + " for " + request.getPurpose());
    }
}

class ExpenseRequest {
    private double amount;
    private String purpose;

    public ExpenseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }
}

public class Task5 {
    public static void main(String[] args) {
        Approver teamLead = new TeamLead();
        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        teamLead.setNext(manager);
        manager.setNext(director);
        director.setNext(ceo);

        ExpenseRequest req1 = new ExpenseRequest(500, "Office Supplies");
        ExpenseRequest req2 = new ExpenseRequest(3000, "Team Event");
        ExpenseRequest req3 = new ExpenseRequest(12000, "New Equipment");

        teamLead.handleRequest(req1);
        teamLead.handleRequest(req2);
        teamLead.handleRequest(req3);
    }
}
