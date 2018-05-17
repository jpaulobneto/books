package com.becoming_functional.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  static public ArrayList<Customer> allCustomers = new ArrayList<Customer>();
  public Integer id = 0;
  public String name = "";
  public String address = "";
  public String state = "";
  public String primaryContact = "";
  public String domain = "";
  public Boolean enabled = true;

  public Customer() {}

  private interface Function1<A1, B> {
    public B call(A1 in1);
  }

  static final public Function1<Customer,Boolean> EnabledCustomer = new Function1<Customer,Boolean>() {
    public Boolean call(Customer customer) {
      return customer.enabled == true;
    }
  };

  static final public Function1<Customer,Boolean> DisabledCustomer = new Function1<Customer,Boolean>() {
    public Boolean call(Customer customer) {
      return customer.enabled == false;
    }
  };

  static private class CustomerAsCustomer implements Function1<Customer, Customer> {
    public String call(Customer customer) { return customer; }
  }

  public static List<String> getEnabledCustomerAddresses() {
    return Customer.getField(Customer.EnabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.address; }
    });
  }

  public static List<String> getDisabledCustomerAddresses() {
    return Customer.getField(Customer.DisabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.address; }
    });
  }

  public static List<String> getEnabledCustomerDomains() {
    return Customer.getField(Customer.EnabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.domain; }
    });
  }

  public static List<String> getDisabledCustomerDomains() {
    return Customer.getField(Customer.DisabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.domain; }
    });
  }

  public static List<String> getEnabledCustomerNames() {
    return Customer.getField(Customer.EnabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.name; }
    });
  }

  public static List<String> getDisabledCustomerNames() {
    return Customer.getField(Customer.DisabledCustomer, new Function1<Customer, String>() {
      public String call(Customer customer) { return customer.name; }
    });
  }

  public static List<String> getEnabledCustomerPrimaryContacts() {
    return Customer.getField(Customer.EnabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.primaryContact; }
    });
  }

  public static List<String> getDisabledCustomerPrimaryContacts() {
    return Customer.getField(Customer.DisabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.primaryContact; }
    });
  }

  public static List<String> getEnabledCustomerStates() {
    return Customer.getField(Customer.EnabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.state; }
    });
  }

  public static List<String> getDisabledCustomerStates() {
    return Customer.getField(Customer.DisabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) { return customer.state; }
    });
  }

  public static List<String> getEnabledCustomerSomeoneEmail(final String someone) {
    return Customer.getField(Customer.EnabledCustomer, new Function1<Customer,String>() {
      public String call(Customer customer) {
        return someone + "@" + customer.domain;
      }
    });
  }

  public static List<String> getDisabledSomeoneEmail(final String someone) {
    return Customer.getField(Customer.Disabled, new Function1<Customer,String>() {
      public String call(Customer customer) {
        return someone + "@" + customer.domain;
      }
    });
  }

  public static <B> List<B> getField(Function1<Customer,Boolean> test, Function1<Customer, B> func) {
    ArrayList<B> outList = new ArrayList<B>();
    for (Customer customer : Customer.allCustomers) {
      if (test.call(customer)) {
        outList.add(func.call(customer));
      }
    }
    return outList;
  }

  /* TODO: Add a main function */
}
