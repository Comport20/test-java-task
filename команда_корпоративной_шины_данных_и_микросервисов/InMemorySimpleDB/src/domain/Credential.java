package domain;


public class Credential {
    private long account;
    private String name;
    private double value;
    public Credential(){
    }
    public Credential(long account, String name, double value){
        this.account = account;
        this.name = name;
        this.value = value;
    }
    public long getAccount(){
        return account;
    }
    public String getName(){
        return name;
    }
    public double getValue(){
        return value;
    }
    public void setAccount(long account){
        this.account = account;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setValue(double value){
        this.value = value;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int) (account ^ (account >>> 32));
        result = 31 * result + (name == null ? 0 : name.hashCode());
        long doubleToLongBits = Double.doubleToLongBits(value);
        result = 31 * result + (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Credential credential))
            return false;
        return account == credential.account && name.equals(credential.name) && value == credential.value;
    }

    @Override
    public String toString() {
        return "account: " + account + "\nname: " + name + "\nvalue: " + value;
    }

}
