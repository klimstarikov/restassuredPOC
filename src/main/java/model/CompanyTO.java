package model;

import java.util.Objects;

public class CompanyTO {
    private String name;
    private String catchPhrase;
    private String bs;

    public CompanyTO(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
    public CompanyTO() {
        // Default constructor for deserialization
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CompanyTO companyTO)) return false;
        return Objects.equals(getName(), companyTO.getName()) && Objects.equals(getCatchPhrase(), companyTO.getCatchPhrase()) && Objects.equals(getBs(), companyTO.getBs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCatchPhrase(), getBs());
    }
}
