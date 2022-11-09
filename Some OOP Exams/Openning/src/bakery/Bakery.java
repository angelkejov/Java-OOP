package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;
    List<Employee> data;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Employee employee) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(employee);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(this.data.get(i));
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int oldest = Integer.MIN_VALUE;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getAge() > oldest) {
                return this.data.get(i);
            }
        }
        return null;
    }

    public Employee getEmployee(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                return this.data.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        System.out.println("Employees working at Bakery: ");
        for (Employee e : data) {
            System.out.println(e);
        }

        return "";
    }
}
