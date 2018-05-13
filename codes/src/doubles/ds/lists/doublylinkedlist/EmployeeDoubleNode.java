package doubles.ds.lists.doublylinkedlist;

import doubles.ds.Employee;

public class EmployeeDoubleNode {

    private Employee employee;
    private EmployeeDoubleNode next;
    private EmployeeDoubleNode prev;

    public EmployeeDoubleNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDoubleNode getNext() {
        return next;
    }

    public void setNext(EmployeeDoubleNode next) {
        this.next = next;
    }

    public EmployeeDoubleNode getPrev() {
        return prev;
    }

    public void setPrev(EmployeeDoubleNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
