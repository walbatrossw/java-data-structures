package doubles.ds.lists.siglylinkedlist;

import doubles.ds.Employee;

public class EmployeeSingleNode {

    private Employee employee;
    private EmployeeSingleNode next;

    public EmployeeSingleNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeSingleNode getNext() {
        return next;
    }

    public void setNext(EmployeeSingleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
